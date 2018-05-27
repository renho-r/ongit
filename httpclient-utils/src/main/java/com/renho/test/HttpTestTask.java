package com.renho.test;

import com.renho.utils.HttpClientUtils;
import com.renho.utils.httputils.HttpAsyncClientUtils;
import com.renho.utils.httputils.HttpSyncClientUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class HttpTestTask implements Callable<String> {

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");

    @Override
    public String call() throws Exception {
        try {
            Map<String, String> syncReqData = new HashMap<>();
            syncReqData.put("busiId", "sync:busiId-renho");

            Map<String, String> asyncReqData = new HashMap<>();
            asyncReqData.put("busiId", "async:busiId-renho");

            String respData;

            respData = HttpClientUtils.doPost("http://localhost:9091/api/http/auth/log", "sync:renho:" + simpleDateFormat.format(new Date()));
            System.out.println(respData);
//            respData = HttpClientUtils.doPost("http://localhost:9091/api/http/auth/log", "sync:renho");
//            System.out.println(respData);
//            respData = HttpClientUtils.doPostWithContext("http://localhost:9091/api/http/auth/log", "sync:renho");
//            System.out.println(respData);
//            respData = HttpClientUtils.doPostWithContext("http://localhost:9091/api/http/auth/log", "sync:renho");
//            System.out.println(respData);
//            respData = HttpClientUtils.doPost("http://localhost:9091/api/http/auth/log", syncReqData);
//            System.out.println(respData);
//            respData = HttpClientUtils.doPost("http://localhost:9091/api/http/auth/log", syncReqData);
//            System.out.println(respData);
//            respData = HttpClientUtils.doPostWithContext("http://localhost:9091/api/http/auth/log", syncReqData);
//            System.out.println(respData);
//            respData = HttpClientUtils.doPostWithContext("http://localhost:9091/api/http/auth/log", syncReqData);
//            System.out.println(respData);
//
//
//            respData = HttpClientUtils.doGet("http://localhost:9091/api/http/auth/logGet");
//            System.out.println(respData);
//            respData = HttpClientUtils.doGet("http://localhost:9091/api/http/auth/logGet");
//            System.out.println(respData);
//            respData = HttpClientUtils.doGetWithContext("http://localhost:9091/api/http/auth/logGet");
//            System.out.println(respData);
//            respData = HttpClientUtils.doGetWithContext("http://localhost:9091/api/http/auth/logGet");
//            System.out.println(respData);
//            respData = HttpClientUtils.doGet("http://localhost:9091/api/http/auth/logGetParam", syncReqData);
//            System.out.println(respData);
//            respData = HttpClientUtils.doGet("http://localhost:9091/api/http/auth/logGetParam", syncReqData);
//            System.out.println(respData);
//            respData = HttpClientUtils.doGetWithContext("http://localhost:9091/api/http/auth/logGetParam", syncReqData);
//            System.out.println(respData);
//            respData = HttpClientUtils.doGetWithContext("http://localhost:9091/api/http/auth/logGetParam", syncReqData);
//            System.out.println(respData);
//
//
//            HttpGet httpGet = new HttpGet();
//            httpGet.setURI(new URI("http://localhost:9091/api/http/auth/logGet"));
//            respData = HttpSyncClientUtils.doRequest(httpGet);
//            System.out.println(respData);
//
            HttpAsyncClientUtils.POST.request("http://localhost:9091/api/http/auth/log", "async:renho:" + simpleDateFormat.format(new Date()));
//            HttpAsyncClientUtils.POST.request("http://localhost:9091/api/http/auth/log", "async:renho", getFutureCallback());
//            HttpAsyncClientUtils.POST.request("http://localhost:9091/api/http/auth/log", asyncReqData);
//            HttpAsyncClientUtils.POST.request("http://localhost:9091/api/http/auth/log", asyncReqData, getFutureCallback());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private FutureCallback<HttpResponse> getFutureCallback() {
        return new FutureCallback<HttpResponse>() {

            @Override
            public void completed(final HttpResponse response) {
                try {
                    System.out.println(EntityUtils.toString(response.getEntity()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(final Exception ex) {
                ex.printStackTrace();
            }

            @Override
            public void cancelled() {
            }


        };
    }
}
