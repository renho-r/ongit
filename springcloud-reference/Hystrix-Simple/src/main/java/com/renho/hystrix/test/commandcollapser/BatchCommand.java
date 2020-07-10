package com.renho.hystrix.test.commandcollapser;

import com.netflix.hystrix.HystrixCollapser;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class BatchCommand extends HystrixCommand<List<String>> {
    private final Collection<HystrixCollapser.CollapsedRequest<String, Integer>> requests;

    public BatchCommand(Collection<HystrixCollapser.CollapsedRequest<String, Integer>> requests) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("GetValueForKey")));
        this.requests = requests;
    }

    @Override
    protected List<String> run() {
        System.out.println("BatchCommand run  " + requests.size());
        ArrayList<String> response = new ArrayList<String>();
        for (HystrixCollapser.CollapsedRequest<String, Integer> request : requests) {
            // artificial response for each argument received in the batch
            response.add("ValueForKey: " + request.getArgument());
        }
        return response;
    }
}
