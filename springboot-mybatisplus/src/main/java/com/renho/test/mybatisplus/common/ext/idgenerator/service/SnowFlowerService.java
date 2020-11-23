package com.renho.test.mybatisplus.common.ext.idgenerator.service;

import com.renho.test.mybatisplus.common.ext.idgenerator.dao.SnowFMapper;
import com.renho.test.mybatisplus.common.ext.idgenerator.dto.WorkerNodeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SnowFlowerService {
    @Autowired
    private SnowFMapper snowFMapper;

    public WorkerNodeEntity getWorkerNodeByHostPort(WorkerNodeEntity workerNodeEntity){
        return snowFMapper.getWorkerNodeByHostPort(workerNodeEntity);
    }

    public void addWorkerNode(WorkerNodeEntity workerNodeEntity){
        snowFMapper.addWorkerNode(workerNodeEntity);
    }

    public int getMaxWorkerIdByHostPort(){
        return snowFMapper.getMaxWorkerIdByHostPort();
    }

    public void delNodes(){
        snowFMapper.delNodes();
    }

}
