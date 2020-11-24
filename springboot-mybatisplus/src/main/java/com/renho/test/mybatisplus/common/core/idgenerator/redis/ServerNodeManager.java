package com.renho.test.mybatisplus.common.core.idgenerator.redis;

import com.renho.test.mybatisplus.common.core.idgenerator.dto.LeafAlloc;
import com.renho.test.mybatisplus.common.core.idgenerator.service.SeqSaveService;
import com.renho.test.mybatisplus.common.core.idgenerator.utils.ConfigContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.exceptions.JedisConnectionException;

/**
 * 管理redis连接池
 *
 * @author
 */
@Service("ServerNodeManager")
public class ServerNodeManager implements ServerNodeListener {

    private static final Logger LOG = LoggerFactory.getLogger(ServerNodeManager.class);

    @Autowired
    private RedisClient redisClient;
    @Autowired
    private SeqSaveService seqSaveService;

    private volatile ConfigContext context;
    /**
     * 重试次数
     */
    private static final int RETRY = 3;

    /**
     * 从redis集群取值，最多重试3次
     *
     * @param
     * @return
     */
    public long incr(String seqName) {
        long max = 0L;
        int step = 0;
        for (int i = 0; i < RETRY; i++) {
            try {
                JedisCluster pool = getShuffledNodesPool();
                try {
                    step = context.getStep();

                    max = pool.incrBy(seqName, Long.valueOf(context.getStep()));
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (pool != null) {
                        pool.close();
                    }
                }
                //ok!jump out or go on loop
                if (max > 0L) {
                    break;
                }
            } catch (Exception e) {
                throw new JedisConnectionException("redis连接失败");
            }
        }
        //将序列信息持久化到数据库
        LeafAlloc seqSave = new LeafAlloc();

        seqSave.setStep(step);
        seqSave.setBizTag(seqName);
        seqSave.setMaxId(max);
        seqSaveService.updateSeqByName(seqSave);
        return max;
    }

    private JedisCluster getShuffledNodesPool() {
        return context.getPool();
    }


    public void init(LeafAlloc seqSave) {
        int step = seqSave.getStep();

        JedisCluster pools = redisClient.getPool();

        reconstructWorld(pools, step);
    }

    /*private JedisCluster initPools() {
        //List<JedisCluster> pools = new ArrayList<JedisCluster>();
        Set<HostAndPort> nodes = new HashSet<>();
        nodes.add(new HostAndPort("192.168.1.12", 6379));
        nodes.add(new HostAndPort("192.168.1.12", 6380));
        nodes.add(new HostAndPort("192.168.1.13", 6379));
        nodes.add(new HostAndPort("192.168.1.13", 6380));
        nodes.add(new HostAndPort("192.168.1.14", 6379));
        nodes.add(new HostAndPort("192.168.1.14", 6380));
        JedisCluster cluster = new JedisCluster(nodes, getPoolConfig());
        //pools.add(cluster);
        return redisClient.getPool();
    }*/

    private void reconstructWorld(JedisCluster tempPool, int step) {
        this.context = new ConfigContext.ConfigContextBuilder(tempPool, step).build();
    }

    public void eventOccured(ServerNodeEventType event, LeafAlloc seqSave) {
        if (seqSave == null) {
            return;
        }
        switch (event) {
            case UPDATE:
                //重新初始化
                init(seqSave);
                break;
            case REMOVE:
                destroy();
                break;
            default:
                break;
        }
    }

    private void destroy() {
        LOG.info("destorying context");
        // help gc
        this.context = null;
    }

    /**
     * 步长，每个业务在后台设置
     *
     * @return
     */
    public int getStep() {
        return this.context.getStep();
    }

}
