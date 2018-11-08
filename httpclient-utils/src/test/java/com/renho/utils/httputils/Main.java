package com.renho.utils.httputils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class Main {

    public HttpClient httpclient;

    @Before
    public void init() {
        httpclient = new DefaultHttpClient();
    }

    @Test
    public void sync() {
        String url = "http://192.168.100.77:8085/monitor/restAPI/servicedir/addService";
        HttpPost httppost = new HttpPost(url);
        //		httppost.setHeader("Content-Type", "multipart/form-data");
        HttpEntity responseEntity = null;
        try {
            MultipartEntity reqEntity = new MultipartEntity();
            reqEntity.addPart("serviceName", new StringBody("testproject", Charset.forName("utf-8")));
            reqEntity.addPart("majorVersion", new StringBody("1", Charset.forName("utf-8")));
            reqEntity.addPart("minorVersion", new StringBody("0", Charset.forName("utf-8")));
            reqEntity.addPart("barfile", new FileBody(new File("C:/Users/renho/Desktop/buLogResourceRenhoBuLogNew.bar")));
//	        reqEntity.addPart("serviceCatalog", new StringBody("0", Charset.forName("utf-8")));
//	        reqEntity.addPart("serviceDec", new StringBody("0", Charset.forName("utf-8")));
//	        reqEntity.addPart("attachment", new StringBody("0", Charset.forName("utf-8")));
//	        reqEntity.addPart("developer", new StringBody("0", Charset.forName("utf-8")));
//	        reqEntity.addPart("esbserverName", new StringBody("esb", Charset.forName("utf-8")));//
//	        reqEntity.addPart("esbserverIp", new StringBody("127.0.0.1", Charset.forName("utf-8")));//
//	        reqEntity.addPart("esbserverPort", new StringBody("10099", Charset.forName("utf-8")));//

            httppost.setEntity(reqEntity);
            HttpResponse response = this.httpclient.execute(httppost);
            responseEntity = response.getEntity();
            if (responseEntity != null) {
                long len = responseEntity.getContentLength();
            }
            System.out.println(EntityUtils.toString(responseEntity));
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                EntityUtils.consume(responseEntity);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
