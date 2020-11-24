package com.renho.test.mybatisplus.common.ext.idgenerator.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class WorkerNodeEntity {

    //去掉后selectById失效
    @TableId
    private Long id;
    private String hostName;
    private String port;
    private Date launchDate = new Date();
    private Date created;
    private Date modified;

}
