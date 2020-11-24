package com.renho.test.mybatisplus.entity.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author renho
 * @date 2020/10/23
 */
@Data
public class NoneId {

    @TableId(type = IdType.NONE)
    private Long id;
    private String name;
    private String cTime;
}
