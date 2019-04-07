package com.renho.feign.server.simple.service;

import com.renho.vo.UserVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author: renho
 * @since: 1.0.0
 */
@FeignClient(value = "USER-SERVICE")
public interface IFeignUserService {

    @RequestMapping(value = "/user/info/{name}",method = RequestMethod.GET)
    UserVo userInfoFromClientOne(@PathVariable(value = "name") String name);

}
