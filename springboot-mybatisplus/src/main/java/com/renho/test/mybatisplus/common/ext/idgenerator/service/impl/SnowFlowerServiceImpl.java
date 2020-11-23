package com.renho.test.mybatisplus.common.ext.idgenerator.service.impl;

import com.renho.test.mybatisplus.common.ext.idgenerator.dao.SnowFMapper;
import com.renho.test.mybatisplus.common.ext.idgenerator.dto.WorkerNodeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SnowFlowerServiceImpl{
    @Autowired
    private SnowFMapper idAllocDao;

    public WorkerNodeEntity getWorkerNodeByHostPort(WorkerNodeEntity workerNodeEntity){
          return idAllocDao.getWorkerNodeByHostPort(workerNodeEntity);
    }

    public void addWorkerNode(WorkerNodeEntity workerNodeEntity){
         idAllocDao.addWorkerNode(workerNodeEntity);
    }

}
