package com.renho.idgenerator.core.ext.sf.workeridpolicy;

import com.renho.idgenerator.core.ext.sf.IWorkerIdPolicy;
import com.renho.idgenerator.core.ext.sf.config.SnowFlakeConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.NetworkInterface;

/**
 * copy from mybatis-plus: com.baomidou.mybatisplus.core.toolkit.Sequence
 * 根据ip、mac、pid生成workerId
 * @author renho
 * @date 2020/10/28
 */
public class MacIpWorkerIpPolicy implements IWorkerIdPolicy {

    private final static Logger logger = LoggerFactory.getLogger(MacIpWorkerIpPolicy.class);

    @Override
    public long getWorkId(SnowFlakeConfig snowFlakeConfig) {
        long mac = getMac();
        long workerIdBits = snowFlakeConfig.getWorkerIdBits();
        long maxWorkerId = -1L ^ (-1L << workerIdBits);
        long workerId = getMaxWorkerId(mac, maxWorkerId);
        return workerId;
    }

    /**
     * 获取 maxWorkerId
     */
    private static long getMaxWorkerId(long mac, long maxWorkerId) {
        StringBuilder mpid = new StringBuilder();
        mpid.append(mac);
        String name = ManagementFactory.getRuntimeMXBean().getName();
        if (null!=name && !"".equals(name)) {
            /*
             * GET jvmPid
             */
            mpid.append(name.split("@")[0]);
        }
        /*
         * MAC + PID 的 hashcode 获取16个低位
         */
        return (mpid.toString().hashCode() & 0xffff) % (maxWorkerId + 1);
    }

    /**
     * 数据标识id部分
     */
    private static long getMac() {
        long id = 0L;
        try {
            InetAddress ip = InetAddress.getLocalHost();
            NetworkInterface network = NetworkInterface.getByInetAddress(ip);
            if (network == null) {
                id = 1L;
            } else {
                byte[] mac = network.getHardwareAddress();
                if (null != mac) {
                    id = ((0x000000FF & (long) mac[mac.length - 2]) | (0x0000FF00 & (((long) mac[mac.length - 1]) << 8))) >> 6;
                    return id;
                }
            }
        } catch (Exception e) {
            logger.warn(" getMac: " + e.getMessage());
        }
        return id;
    }
}
