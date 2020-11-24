package com.renho.test.mybatisplus.common.core.idgenerator.service.impl;

import com.renho.test.mybatisplus.common.core.IdGen;
import com.renho.test.mybatisplus.common.core.idgenerator.utils.IdGenUtil;
import com.renho.test.mybatisplus.common.ext.idgenerator.dao.IDAllocMapper;
import com.renho.test.mybatisplus.common.ext.idgenerator.service.impl.SnowFlowerIDGenImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("IdGenImpl")
public class IdGenImpl implements IdGen {


    /*@Autowired
    private IDGenerator idGenerator;*/
    @Autowired
    private IdGenUtil idGenUtil;

    @Autowired
    private IDAllocMapper idAllocMapper;

    @Autowired
    private SnowFlowerIDGenImpl snowFlowerIDGen;

    /**
     * 初始化
     */
    @Override
    public boolean init(){
        return true;
    }

    /**
     * 获取下一个序列号
     * @param key
     * @return
     */
    @Override
    @Transactional
    public Long get(String prefix,String key,String ip,String port) {

        if (prefix.equals("pro")) {

            return idGenUtil.next(key);
        } else if (prefix.equals("sf")) {

            return snowFlowerIDGen.get(prefix,key,ip,port);
        } else if (prefix.equals("oracle")) {

            return idAllocMapper.getSequenceIdFromOracle(key);
        } else if (prefix.equals("mysql")) {

            return idAllocMapper.getSequenceIdFromMycat(key);
        } else {
            throw new UnsupportedOperationException(prefix + "  not supported!");
        }
    }
}
