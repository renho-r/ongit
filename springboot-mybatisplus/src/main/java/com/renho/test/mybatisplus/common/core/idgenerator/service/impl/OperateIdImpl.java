package com.renho.test.mybatisplus.common.core.idgenerator.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.renho.test.mybatisplus.common.core.idgenerator.common.Constants;
import com.renho.test.mybatisplus.common.core.idgenerator.dto.LeafAlloc;
import com.renho.test.mybatisplus.common.core.idgenerator.redis.RedisClient;
import com.renho.test.mybatisplus.common.core.idgenerator.service.SeqSaveService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

@Service
@Configuration
public class OperateIdImpl{

	private static final Logger LOG = LoggerFactory.getLogger(OperateIdImpl.class);


	@Autowired
	private RedisClient redisClient;

	@Autowired
	private SeqSaveService seqSaveService;

	/**
	 * 欣赏世界里的房子
	 * @param house
	 * @return
	 * @throws Exception
	 */
	public LeafAlloc appreciate(String house) throws Exception{

		String seqName= house;

		LeafAlloc ss = seqSaveService.getSeqByName(seqName);
		ss.setBizTag(seqName);
		JSONObject json = toJSON(ss);
		LOG.info("查询序列{}当前数据{}", seqName, json);
		return ss;
	}
	/**
	 * 修改序列(重新粉刷房子)
	 * @param
	 * @throws Exception
	 */
	public void repaint(LeafAlloc seqSave) throws Exception{
		if(seqSave == null){
			return ;
		}
		//拼JSON
		JSONObject json = toJSON(seqSave);
		LOG.info("利用参数拼装出{}", json);
		String seqName = seqSave.getBizTag();
		//LeafAlloc
		LeafAlloc oldSeqSave = appreciate(seqName);
		//调平redis
		reconstructWorld(seqSave, oldSeqSave);
		seqSaveService.updateSeqByName(seqSave);
	}
	/**
	 * 修改序列(重新粉刷房子), 后台指定每台redis的值
	 * @param
	 * @throws Exception
	 */
	public void balanceByPeople(LeafAlloc seqSave) throws Exception{
		if(seqSave == null){
			return ;
		}
		LOG.info("修改序列{}", seqSave.getBizTag());

		reconstructWorldByPeople(seqSave);

		seqSaveService.updateSeqToZero(seqSave);
	}
	/**
	 * 新增序列
	 * @param
	 * @throws Exception
	 */
	public void construct(LeafAlloc seqSave) throws Exception{
		LOG.info("新增序列{}", seqSave.getBizTag());
		LeafAlloc ss  = new LeafAlloc();
		ss = seqSaveService.getSeqByName(seqSave.getBizTag());
		String seqName = seqSave.getBizTag();
		//判断序列名称是否存在
		if(ss != null){
			if(ss.getBizTag().equals(seqName)){
				throw new IllegalArgumentException(seqName + "重复");
			}
		}

		reconstructWorld(seqSave);
		LOG.info("修改成功{}", seqSave.getBizTag());

		seqSaveService.insertSeq(seqSave);

	}

	private JSONObject toJSON(LeafAlloc seqSave){
		JSONObject json = new JSONObject();
		json.put(Constants.KEY_START_INDEX, seqSave.getStartIndex());
		json.put(Constants.KEY_STEP, seqSave.getStep());
		return json;
	}

	/**
	 * 将序列信息新增到redis中
	 * @param seqSave
	 */
	private void reconstructWorld(LeafAlloc seqSave){
		//获取序列的步长信息
		//long maxVal = seqSave.getStep();
		long maxVal = seqSave.getStartIndex();
		JedisCluster pool = redisClient.getPool();
		String seqName = seqSave.getBizTag();
		try{

			long tempVal = 0L;
			//判断redis中是否有序列信息。有的话直接删除
			if(pool.exists(seqName)){
				tempVal = Long.valueOf(pool.get(seqName));
			}
			if(tempVal > maxVal){
				maxVal = tempVal;
			}

			long currentVal = maxVal;

			pool.set(seqName, String.valueOf(currentVal));

			String aaa = pool.get(seqName);
			System.err.print(aaa);
		}catch(Exception e){
			LOG.error("调平失败", e);
			throw new RuntimeException(e);
		}finally{
			try{
				pool.close();
			}catch(Exception e){
				LOG.error("关闭redispool实例异常", e);
			}
		}
	}

	private void reconstructWorld(LeafAlloc seqSave, LeafAlloc oldSeqSave) {
		JedisCluster pool = redisClient.getPool();

		try {
            long maxVal = 0L;
            long tempVal = 0L;
            String seqName = seqSave.getBizTag();
            if(pool.exists(seqName)){
                tempVal = Long.valueOf(pool.get(seqName));
            }

            if (tempVal > maxVal) {
                maxVal = tempVal;
            }

			//long maxVal = getMaxAndLock(oldSeqSave,pool);
			//String seqName = seqSave.getBizTag();
			//long currentVal = maxVal;

			pool.set(seqName, String.valueOf(maxVal));

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				pool.close();
			} catch (Exception e) {
				LOG.error("关闭redispool实例异常", e);
			}
		}
	}

	private void reconstructWorldByPeople(LeafAlloc seqSave) {
		JedisCluster pool = redisClient.getPool();

		try {
			String seqName = seqSave.getBizTag();
			LeafAlloc leafAlloc = seqSaveService.getSeqByName(seqName);
			String currentVal = String.valueOf(leafAlloc.getStep());
			pool.set(seqName, currentVal);

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				pool.close();
			} catch (Exception e) {
				LOG.error("关闭redis实例异常", e);
			}
		}
	}

	/**
	 * 删除序列信息（Redis和数据库）
	 * @param bizTag
	 * @throws Exception
	 */
	public void deleteSeq(String bizTag) throws Exception{
		JedisCluster pool = redisClient.getPool();
		try {
			pool.del(bizTag);
			String aaa = pool.get(bizTag);
			seqSaveService.deleteSeq(bizTag);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				pool.close();
			} catch (Exception e) {
				LOG.error("关闭redis实例异常", e);
			}
		}
	}

	/**
	 * 获取最大值并暂停服务
	 * @param
	 * @return
	 */
	private long getMaxAndLock(LeafAlloc seqSave,JedisCluster pool) {
		//JedisCluster pool = redisClient.getPool();
		String seqName = seqSave.getBizTag();
		try {
			long maxVal = 0L;
			long tempVal = 0L;

			if(pool.exists(seqName)){
				tempVal = Long.valueOf(pool.get(seqName));
			}

			if (tempVal > maxVal) {
				maxVal = tempVal;
			}LOG.info("{}序列找到最大值{}", seqName, maxVal);
			return maxVal;
		} catch (Exception e) {
			LOG.error("设置redis序列暂时不可用报错" + seqName, e);
			throw new RuntimeException(e);
		} finally {
			try {
				pool.close();
			} catch (Exception e) {
				LOG.error("关闭redispool实例异常", e);
			}
		}
	}

}
