package com.renho.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * @author: renho
 * @since: 1.0.0
 */
public class GetStockServiceCommand extends HystrixCommand<String> {

    protected GetStockServiceCommand(HystrixCommandGroupKey group) {
        super(group);
    }

    @Override
    protected String run() throws Exception {
        return null;
    }

}
