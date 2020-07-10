package com.renho.dependence;

import org.springframework.context.annotation.Scope;

/**
 * @author renho
 * @since: 2020/6/12
 */
@Scope("singleton")
public class SingleTwoBean {

    public SingleTwoBean() {}

    public SingleTwoBean(SingleOneBean singleOneBean) {

    }

}
