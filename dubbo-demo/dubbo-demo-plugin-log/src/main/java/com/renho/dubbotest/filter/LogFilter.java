package com.renho.dubbotest.filter;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */

import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.rpc.*;
import com.renho.dubbotest.service.ILogService;
import org.springframework.beans.factory.annotation.Autowired;

public class LogFilter implements Filter {

    @Reference
    private ILogService logService;

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {

        RpcContext rpcContext = RpcContext.getContext();

//        ReferenceConfig<ILogService> reference = new ReferenceConfig<ILogService>(); // 此实例很重，封装了与注册中心的连接以及与提供者的连接，请自行缓存，否则可能造成内存和连接泄漏
//        reference.setApplication(application);
//        reference.setRegistry(registry); // 多个注册中心可以用setRegistries()
//        reference.setInterface(XxxService.class);
//        reference.setVersion("1.0.0");



        System.out.println("renho before");
        logService.log("log info --> test");
        // before filter ...
        Result result = invoker.invoke(invocation);
        // after filter ...
        return result;
    }
}
