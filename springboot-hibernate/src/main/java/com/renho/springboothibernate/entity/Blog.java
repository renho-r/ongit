package com.renho.springboothibernate.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author renho
 * @date 2020/12/9
 */
@Data
@Entity
public class Blog implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String address;
    @Column(name = "[desc]")
    private String desc;
    private Long createTime;

}
