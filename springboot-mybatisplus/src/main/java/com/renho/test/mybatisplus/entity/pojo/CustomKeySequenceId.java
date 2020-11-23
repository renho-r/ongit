package com.renho.test.mybatisplus.entity.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author renho
 * @date 2020/10/23
 */
@Data
@KeySequence(value = "SEQ_CUSTOM_STRING_KEY")
public class CustomKeySequenceId {

    @TableId(type = IdType.INPUT)
    private String id;
    private String name;
    private String cTime;
}
