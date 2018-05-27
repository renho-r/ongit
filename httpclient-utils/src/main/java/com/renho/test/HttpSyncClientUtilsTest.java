package com.renho.test;

import com.renho.utils.httputils.HttpSyncClientUtils;
import com.renho.utils.httputils.exception.AppHttpException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class HttpSyncClientUtilsTest {

    public static void main(String[] args) throws URISyntaxException, AppHttpException, IOException {

        HttpClient httpClient = HttpSyncClientUtils.newHttpClient();
        HttpContext httpContext = HttpSyncClientUtils.newHttpContext();
        RequestConfig requestConfig = HttpSyncClientUtils.defaultRequestConfig();


        Map<String, String> reqData = new HashMap<>();
        reqData.put("busiId", "busiId-renho");

        String respData;

        respData = HttpSyncClientUtils.POST.request("http://localhost:9091/api/http/auth/log", "renho");
        System.out.println(respData);
        respData = HttpSyncClientUtils.POST.request("http://localhost:9091/api/http/auth/log", "renho");
        System.out.println(respData);
        respData = HttpSyncClientUtils.POST.requestWithContext("http://localhost:9091/api/http/auth/log", "renho");
        System.out.println(respData);
        respData = HttpSyncClientUtils.POST.requestWithContext("http://localhost:9091/api/http/auth/log", "renho");
        System.out.println(respData);
        respData = HttpSyncClientUtils.POST.request("http://localhost:9091/api/http/auth/log", reqData);
        System.out.println(respData);
        respData = HttpSyncClientUtils.POST.request("http://localhost:9091/api/http/auth/log", reqData);
        System.out.println(respData);
        respData = HttpSyncClientUtils.POST.requestWithContext("http://localhost:9091/api/http/auth/log", reqData);
        System.out.println(respData);
        respData = HttpSyncClientUtils.POST.requestWithContext("http://localhost:9091/api/http/auth/log", reqData);
        System.out.println(respData);


        respData = HttpSyncClientUtils.GET.request("http://localhost:9091/api/http/auth/logGet");
        System.out.println(respData);
        respData = HttpSyncClientUtils.GET.request("http://localhost:9091/api/http/auth/logGet");
        System.out.println(respData);
        respData = HttpSyncClientUtils.GET.requestWithContext("http://localhost:9091/api/http/auth/logGet");
        System.out.println(respData);
        respData = HttpSyncClientUtils.GET.requestWithContext("http://localhost:9091/api/http/auth/logGet");
        System.out.println(respData);
        respData = HttpSyncClientUtils.GET.request("http://localhost:9091/api/http/auth/logGetParam", reqData);
        System.out.println(respData);
        respData = HttpSyncClientUtils.GET.request("http://localhost:9091/api/http/auth/logGetParam", reqData);
        System.out.println(respData);
        respData = HttpSyncClientUtils.GET.requestWithContext("http://localhost:9091/api/http/auth/logGetParam", reqData);
        System.out.println(respData);
        respData = HttpSyncClientUtils.GET.requestWithContext("http://localhost:9091/api/http/auth/logGetParam", reqData);
        System.out.println(respData);


        HttpGet httpGet = new HttpGet();
        httpGet.setURI(new URI("http://localhost:9091/api/http/auth/logGet"));
        respData = HttpSyncClientUtils.doRequest(httpGet);
        System.out.println(respData);

    }
}