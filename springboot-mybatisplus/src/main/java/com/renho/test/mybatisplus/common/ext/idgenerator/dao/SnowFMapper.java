package com.renho.test.mybatisplus.common.ext.idgenerator.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.renho.test.mybatisplus.common.ext.idgenerator.dto.WorkerNodeEntity;
import org.apache.ibatis.annotations.*;

@Mapper
public interface SnowFMapper extends BaseMapper<WorkerNodeEntity> {


   /* WorkerNodeEntity getWorkerNodeByHostPort(WorkerNodeEntity workerNodeEntity);

    int addWorkerNode(WorkerNodeEntity workerNodeEntity);*/

    @Select("SELECT ID,HOST_NAME, PORT,CREATED FROM WORKER_NODE WHERE HOST_NAME = #{workerNodeEntity.hostName}and PORT=#{workerNodeEntity.port} ")
    @Results(value = {
            @Result(column = "ID", property = "id"),
            @Result(column = "HOST_NAME", property = "hostName"),
            @Result(column = "PORT", property = "port"),
            @Result(column = "LAUNCH_DATE", property = "launchDate")
    })
    WorkerNodeEntity getWorkerNodeByHostPort(@Param("workerNodeEntity") WorkerNodeEntity workerNodeEntity);

    @Insert("insert into WORKER_NODE(ID,HOST_NAME,PORT)values(#{workerNodeEntity.id},#{workerNodeEntity.hostName},#{workerNodeEntity.port}  )")
   /* @SelectKey(statement = "SELECT SEQ_WORKER_NODE.CURRVAL  as id from dual ", keyProperty = "id", resultType = Long.class, before = false)*/
    void addWorkerNode(@Param("workerNodeEntity") WorkerNodeEntity workerNodeEntity);

    @Select("SELECT count(*) as id FROM WORKER_NODE")
    @Results(value = {
            @Result(column = "ID", property = "id")
    })
    int getMaxWorkerIdByHostPort();


    @Delete("DELETE FROM WORKER_NODE")
    void delNodes();

}
