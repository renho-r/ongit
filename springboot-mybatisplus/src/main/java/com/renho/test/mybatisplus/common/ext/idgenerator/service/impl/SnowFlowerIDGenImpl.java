package com.renho.test.mybatisplus.common.ext.idgenerator.service.impl;
import com.renho.test.mybatisplus.common.core.IdGen;
import com.renho.test.mybatisplus.common.ext.idgenerator.dto.WorkerNodeEntity;
import com.renho.test.mybatisplus.common.ext.idgenerator.exception.ClockMovedBackException;
import com.renho.test.mybatisplus.common.ext.idgenerator.service.SnowFlowerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SnowFlowerIDGenImpl implements IdGen {

    @Value("${idgenerator.sf.bit}")
    private String bit;
    @Override
    public boolean init() {
        return true;
    }

    @Autowired
    private SnowFlowerService snowFlowerService;

    static private final Logger LOGGER = LoggerFactory.getLogger(SnowFlowerIDGenImpl.class);
    //18:et 16:st
    //1525278457256 定长时间  相减
    //1834516102567 最大时间
    //private final long twepoch = 1525278457256L;
    //8796093022208  定长时间  相加
    //35184372088831 最大时间

    private  long twepoch = -1L;
    @Value("${idgenerator.sf.workerIdBits}")
    private long workerIdBits = 5L;
    private final long maxWorkerId = -1L ^ (-1L << workerIdBits);//最大能够分配的workerid =31
    @Value("${idgenerator.sf.sequenceBits}")
    private long sequenceBits = 10L;
    private final long workerIdShift = sequenceBits;
    private final long timestampLeftShift = sequenceBits + workerIdBits;
    private final long sequenceMask = -1L ^ (-1L << sequenceBits);
    private long workerId;
    private long sequence = 0L;
    private long lastTimestamp = -1L;
    private static final Random RANDOM = new Random();

    Map<String,Long> isMap = new HashMap<String,Long>();
    public synchronized Long get(String preix,String key, String ip, String port){
        long id = -1L;
        if(bit!=null){
            if(bit.equals("et")){
                twepoch = 8796093022208L;
            }else if(bit.equals("st")){
                twepoch = 1525278457256L;
            }else{
                System.out.println("throw new NoBitException();");
            }
        }

        WorkerNodeEntity workerNode  = buildWorkerNode(ip,port);
        WorkerNodeEntity workerNodeEntity = null;
        if(isMap.containsKey(ip+port)){
            workerId = isMap.get(ip+port);
        }else{
            workerNodeEntity = snowFlowerService.getWorkerNodeByHostPort(workerNode);
            if(workerNodeEntity!=null){
                workerId = workerNodeEntity.getId();
                isMap.put(workerNodeEntity.getHostName()+workerNodeEntity.getPort(),workerId);
                LOGGER.info("START SUCCESS USE WORKERID-{}", workerId);
            }else{
                workerId = assignWorkerId(ip,port);
                LOGGER.info("START SUCCESS USE WORKERID-{}", workerId);
            }
        }
        //check workid
         //Preconditions.checkArgument(workerId >= 0 && workerId <= maxWorkerId, "workerID must gte 0 and lte 31");
        if(workerId > maxWorkerId){
            Timer timer=new Timer();//实例化Timer类
            timer.schedule(new TimerTask(){
                public void run(){
                    isMap.clear();
                    snowFlowerService.delNodes();
                    this.cancel();}},1);
        }
        long timestamp = timeGen();
        if (timestamp < lastTimestamp) {
            long refusedSeconds = (lastTimestamp - timestamp)/1000;
            throw new ClockMovedBackException("Clock moved backwards. Refusing for %d seconds", refusedSeconds);

        }

        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                //seq 为0的时候表示是下一毫秒时间开始对seq做随机
                sequence = RANDOM.nextInt(100);
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            //如果是新的ms开始
            sequence = RANDOM.nextInt(100);
        }
        lastTimestamp = timestamp;
        if(bit!=null){
            if(bit.equals("et")){
                id = ((timestamp + twepoch) << timestampLeftShift) | (workerId << workerIdShift) | sequence;
            }else if(bit.equals("st")){
                id = ((timestamp - twepoch) << timestampLeftShift) | (workerId << workerIdShift) | sequence;
            }else{
                System.out.println("throw new NoBitException()");
            }
        }
        return id;

    }

    protected long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    protected long timeGen() {
        return System.currentTimeMillis();
    }

    public long assignWorkerId(String ip,String port) {
        WorkerNodeEntity workerNodeEntity = buildWorkerNode(ip,port);
        //workerNodeEntity.setId(snowFlowerService.addWorkerNode(workerNodeEntity));
        snowFlowerService.addWorkerNode(workerNodeEntity);
        LOGGER.info("Add worker node:" + workerNodeEntity);
        return workerNodeEntity.getId();
    }

    private WorkerNodeEntity buildWorkerNode(String ip,String port) {
        WorkerNodeEntity workerNodeEntity = new WorkerNodeEntity();
        int maxid = snowFlowerService.getMaxWorkerIdByHostPort();
        workerNodeEntity.setHostName(ip);
        workerNodeEntity.setPort(port);
        workerNodeEntity.setId(Long.valueOf(maxid));
        return workerNodeEntity;
    }

}
