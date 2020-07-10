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

        //��׼����header����
        Map<String, String> header = new HashMap<String, String>();
        //ʹ�÷���ϢϵͳAPPCODE
        header.put("appCode", "Sappcode001");
        //�������
        header.put("serviceCode", "APa1559027042326");
        //�����ṩ����������
        header.put("serviceAreaCode", "430000");
        //������ˮ
        header.put("serviceReqId", "Sappcode00120190528000000001");
        header.put("serviceReqTime", "20190528171010");
        header.put("signature", "");

        //��׼����body����
        Map<String, String> body = new HashMap<String, String>();
        body.put("id", "testId");

        //�ϲ�header+body
        Map<String, Object> reqParams = new HashMap<String, Object>();
        reqParams.put("header", header);
        //bodyΪjson��ʽ���ַ���
        reqParams.put("body", JSON.toJSONString(body));

        //ת��Ϊ�ڲ�Эͬƽ̨Ҫ������
        StringEntity reqEntity = new StringEntity(JSON.toJSONString(reqParams), "UTF-8");

        DefaultHttpClient httpclient = new DefaultHttpClient();
        //�ڲ�Эͬƽ̨���������ַ
        HttpPost req = new HttpPost("http://192.168.1.10:8185/xtptproxyurl/e3966420000/Brenho/APa1559027042326/test/api/esbnode/list");
        req.setEntity(reqEntity);
        HttpResponse resp = httpclient.execute(req);

        //������
        System.out.println(IOUtils.toString(resp.getEntity().getContent(), "UTF-8"));
    }

}
