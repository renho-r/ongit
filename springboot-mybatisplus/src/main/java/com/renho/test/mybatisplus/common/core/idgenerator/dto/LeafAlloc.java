package com.renho.test.mybatisplus.common.core.idgenerator.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("LEAF_SEQUENCE")
public class LeafAlloc {
    @TableId
    private String bizTag;
    private long maxId;
    private int step;
    private int startIndex;
    private String updateTime;
}
