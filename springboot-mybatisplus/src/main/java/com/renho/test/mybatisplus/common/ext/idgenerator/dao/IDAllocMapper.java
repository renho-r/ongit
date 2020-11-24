package com.renho.test.mybatisplus.common.ext.idgenerator.dao;

import com.renho.test.mybatisplus.common.ext.idgenerator.dto.WorkerNodeEntity;
import org.apache.ibatis.annotations.*;

@Mapper
public interface  IDAllocMapper {

    @Select("SELECT ID,HOST_NAME, PORT, LAUNCH_DATE,MODIFIED,CREATED FROM WORKER_NODE WHERE HOST_NAME = #{workerNodeEntity.hostName}and PORT=#{workerNodeEntity.port} ")
    @Results(value = {
            @Result(column = "ID", property = "id"),
            @Result(column = "HOST_NAME", property = "hostName"),
            @Result(column = "PORT", property = "port"),
            @Result(column = "LAUNCH_DATE", property = "launchDate")
    })
    WorkerNodeEntity getWorkerNodeByHostPort(@Param("workerNodeEntity") WorkerNodeEntity workerNodeEntity);

    @Insert("insert into WORKER_NODE(ID,HOST_NAME,PORT)values(SEQ_WORKER_NODE.nextval,#{workerNodeEntity.hostName},#{workerNodeEntity.port}  )")
    @SelectKey(statement = "SELECT SEQ_WORKER_NODE.CURRVAL  as id from dual ", keyProperty = "id", resultType = Long.class, before = false)
    int addWorkerNode(@Param("workerNodeEntity") WorkerNodeEntity workerNodeEntity);

    @Select("SELECT ${sequenceName}.nextVal from dual")
    public long getSequenceIdFromOracle(@Param("sequenceName") String sequenceName);

    @Select("SELECT next value for ${sequenceName}")
    public long getSequenceIdFromMycat(@Param("sequenceName") String sequenceName);

}
