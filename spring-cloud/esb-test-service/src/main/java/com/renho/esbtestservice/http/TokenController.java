package com.renho.esbtestservice.http;

import com.renho.esbtestservice.http.model.TokenParamInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
@RestController
@RequestMapping("/api")
public class TokenController {

    @RequestMapping("/auth/jwt/accessToken")
    public String getToken(TokenParamInfo tokenParamInfo) {
        System.out.println(tokenParamInfo);
        return "{\"code\":\"00\",\"message\":\"token每天只能获取2000次，有效期2小时，请定时获取\",\"bizSuccess\":true,\"data\":{\"token\":\"test-eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ5bHppbmZvIiwidXNlcklkIjoiNjMiLCJuYW1lIjoi5piT6IGU5LyXIiwiZXhwIjoxNTM4OTcwMzAzfQ.v0ak1Xh-oP8OYERsh9bOyVrzKXgVPHMY76Yk5mifQx4e-Nimwc3fop0wO0H7t4UyDxcQTFGQTT4u8ZHb1ltZxC-TODdvsjPEAW33nYTaKwMC7MQDeejGUaV1NrtCAwmfT66KNdKbXENXqA9xZos34YftHgvW3CrxOdiY9glD8N0\"}}";
    }

}
