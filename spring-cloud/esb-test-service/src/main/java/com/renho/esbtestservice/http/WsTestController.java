package com.renho.esbtestservice.http;

import com.renho.esbtestservice.utils.JsonUtil;
import com.renho.esbtestservice.ws.bean.RespBody;
import io.swagger.annotations.ApiOperation;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther: renho
 * @since: 1.0.0
 */

@RestController
@RequestMapping("api/test/ws")
public class WsTestController {

    @ApiOperation(value="webservice测试", notes="renho")
    @RequestMapping(value = "test", method = RequestMethod.POST)
    public String test(String wdlsUri, String methodName, String busiBody) {

        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient(wdlsUri);
        Object[] objects = new Object[0];
        try {
            // invoke("方法名",参数1,参数2,参数3....);
            objects = client.invoke(methodName, busiBody);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return JsonUtil.toJson(objects);
    }

}
