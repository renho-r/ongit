package com.renho.client.renho;

import com.alibaba.fastjson.JSON;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class Client {

    public static void main(String[] args) throws IOException {

        //标准报文header部分
        Map<String, String> header = new HashMap<String, String>();
        //使用方信息系统APPCODE
        header.put("appCode", "Sappcode001");
        //服务编码
        header.put("serviceCode", "APa1559027042326");
        //服务提供方所属区域
        header.put("serviceAreaCode", "430000");
        //请求流水
        header.put("serviceReqId", "Sappcode00120190528000000001");
        header.put("serviceReqTime", "20190528171010");
        header.put("signature", "");

        //标准报文body部分
        Map<String, String> body = new HashMap<String, String>();
        body.put("id", "testId");

        //合并header+body
        Map<String, Object> reqParams = new HashMap<String, Object>();
        reqParams.put("header", header);
        //body为json格式的字符串
        reqParams.put("body", JSON.toJSONString(body));

        //转换为内部协同平台要求报文体
        StringEntity reqEntity = new StringEntity(JSON.toJSONString(reqParams), "UTF-8");

        DefaultHttpClient httpclient = new DefaultHttpClient();
        //内部协同平台代理后服务地址
        HttpPost req = new HttpPost("http://192.168.1.10:8185/xtptproxyurl/e3966420000/Brenho/APa1559027042326/test/api/esbnode/list");
        req.setEntity(reqEntity);
        HttpResponse resp = httpclient.execute(req);

        //处理结果
        System.out.println(IOUtils.toString(resp.getEntity().getContent(), "UTF-8"));
    }

}
