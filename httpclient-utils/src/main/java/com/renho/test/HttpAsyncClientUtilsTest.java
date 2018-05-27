package com.renho.test;

import com.renho.utils.httputils.HttpAsyncClientUtils;
import com.renho.utils.httputils.exception.AppHttpException;
import org.apache.http.HttpResponse;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class HttpAsyncClientUtilsTest {

    public static void main(String[] args) throws URISyntaxException, AppHttpException, IOException {

        Map<String, String> reqData = new HashMap<>();
        reqData.put("busiId", "busiId-renho");

        for (int i = 0; i < 1; i++) {

            HttpAsyncClientUtils.POST.request("http://localhost:9091/api/http/auth/log", "renho");
            HttpAsyncClientUtils.POST.request("http://localhost:9091/api/http/auth/log", "renho", getFutureCallback());

            HttpAsyncClientUtils.POST.request("http://localhost:9091/api/http/auth/log", reqData);
            HttpAsyncClientUtils.POST.request("http://localhost:9091/api/http/auth/log", reqData, getFutureCallback());

            HttpAsyncClientUtils.GET.request("http://localhost:9091/api/http/auth/logGet");
            HttpAsyncClientUtils.GET.request("http://localhost:9091/api/http/auth/logGet", getFutureCallback());
        }

        System.out.println("--------------->done<-----------------");
    }

    public static FutureCallback<HttpResponse> getFutureCallback() {
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