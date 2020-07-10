package com.renho.dependence;

import org.springframework.context.annotation.Scope;

/**
 * @author renho
 * @since: 2020/6/12
 */
@Scope("prototype")
public class PrototypeOneBean {

    public PrototypeOneBean() { }

    public PrototypeOneBean(PrototypeTwoBean prototypeTwoBean) {

    }
}
