package com.renho.utils.httputils;

import com.renho.utils.httputils.httpasyncclient.HttpAsyncClientPool;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public enum HttpAsyncClientUtils {

    GET {

        public String request(String reqUri, Map<String, String> reqData, FutureCallback<HttpResponse> futureCallback, HttpContext httpContext, CloseableHttpAsyncClient httpAsyncClient) throws URISyntaxException {
            URI uri = getUri(reqUri, reqData);
            final HttpGet httpGet = new HttpGet(uri);
            if(!httpAsyncClient.isRunning()) {
                httpAsyncClient.start();
            }
            httpAsyncClient.execute(httpGet, httpContext, futureCallback);
            return null;
        }

        public String request(String reqUri) throws URISyntaxException {
            return this.request(reqUri, (Map<String, String>)null, defaultFutureCallback, null, HTTP_CLIENT);
        }

        public String request(String reqUri, FutureCallback<HttpResponse> futureCallback) throws URISyntaxException {
            return this.request(reqUri, (Map<String, String>)null, futureCallback, null, HTTP_CLIENT);
        }

        public String request(String reqUri, Map<String, String> reqData) throws URISyntaxException {
            return this.request(reqUri, reqData, defaultFutureCallback, null, HTTP_CLIENT);
        }

        public String request(String reqUri, Map<String, String> reqData, FutureCallback<HttpResponse> futureCallback) throws URISyntaxException {
            return this.request(reqUri, reqData, futureCallback, null, HTTP_CLIENT);
        }

    },
    POST {

        public String request(String reqUri, String bodyData) throws URISyntaxException, UnsupportedEncodingException {
            return this.request(reqUri, bodyData, defaultFutureCallback, null, HTTP_CLIENT);
        }

        public String request(String reqUri, String bodyData, FutureCallback<HttpResponse> futureCallback) throws URISyntaxException, UnsupportedEncodingException {
            return this.request(reqUri, bodyData, futureCallback, null, HTTP_CLIENT);
        }

        public String request(String reqUri, String bodyData, FutureCallback<HttpResponse> futureCallback, HttpContext httpContext, CloseableHttpAsyncClient httpAsyncClient) throws URISyntaxException, UnsupportedEncodingException {
            URI uri = getUri(reqUri, null);
            final HttpPost httpPost = new HttpPost(uri);
            StringEntity stringEntity = new StringEntity(bodyData);
            httpPost.setEntity(stringEntity);
            if(!httpAsyncClient.isRunning()) {
                httpAsyncClient.start();
            }
            httpAsyncClient.execute(httpPost, httpContext, futureCallback);
            return null;
        }

        public String request(String reqUri, Map<String, String> reqData) throws URISyntaxException, UnsupportedEncodingException {
            return this.request(reqUri, reqData, defaultFutureCallback, null, HTTP_CLIENT);
        }

        public String request(String reqUri, Map<String, String> reqData, FutureCallback<HttpResponse> futureCallback) throws URISyntaxException, UnsupportedEncodingException {
            return this.request(reqUri, reqData, futureCallback, null, HTTP_CLIENT);
        }

        public String request(String reqUri, Map<String, String> reqData, FutureCallback<HttpResponse> futureCallback, HttpContext httpContext, CloseableHttpAsyncClient httpAsyncClient) throws URISyntaxException, UnsupportedEncodingException {
            URI uri = getUri(reqUri, null);
            List<NameValuePair> paramList = new ArrayList<>();
            for (String key : reqData.keySet()) {
                paramList.add(new BasicNameValuePair(key, reqData.get(key)));
            }
            // 模拟表单
            UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(paramList, "utf-8");
            final HttpPost httpPost = new HttpPost(uri);
            httpPost.setEntity(urlEncodedFormEntity);
            if(!httpAsyncClient.isRunning()) {
                httpAsyncClient.start();
            }
            httpAsyncClient.execute(httpPost, httpContext, futureCallback);
            return null;
        }
    };

























    public String request(String reqUri) throws URISyntaxException {
        throw new AbstractMethodError();
    }

    public String request(String reqUri, FutureCallback<HttpResponse> futureCallback) throws URISyntaxException {
        throw new AbstractMethodError();
    }
    public String request(String reqUri, String bodyData) throws URISyntaxException, UnsupportedEncodingException {
        throw new AbstractMethodError();
    }

    public String request(String reqUri, String bodyData, FutureCallback<HttpResponse> futureCallback) throws URISyntaxException, UnsupportedEncodingException {
        throw new AbstractMethodError();
    }

    public String request(String reqUri, String bodyData, FutureCallback<HttpResponse> futureCallback, HttpContext httpContext, CloseableHttpAsyncClient httpAsyncClient) throws URISyntaxException, UnsupportedEncodingException {
        throw new AbstractMethodError();
    }
    public String request(String reqUri, Map<String, String> reqData) throws URISyntaxException, UnsupportedEncodingException {
        throw new AbstractMethodError();
    }

    public String request(String reqUri, Map<String, String> reqData, FutureCallback<HttpResponse> futureCallback) throws URISyntaxException, UnsupportedEncodingException {
        throw new AbstractMethodError();
    }










































    private static final CloseableHttpAsyncClient HTTP_CLIENT = HttpAsyncClientPool.getHttpClient();
    public static AtomicInteger count = new AtomicInteger(0);
    //public static AtomicInteger reqCount = new AtomicInteger(0);
    private static FutureCallback<HttpResponse> defaultFutureCallback = getIgnorRespFutureCallback();

    public static CloseableHttpAsyncClient getHttpClient() {
        return HttpAsyncClientPool.getHttpClient();
    }

    public static FutureCallback<HttpResponse> getIgnorRespFutureCallback() {
        return new FutureCallback<HttpResponse>() {

            @Override
            public void completed(final HttpResponse response) {
                //System.out.println("count:" + count.incrementAndGet());
            }

            @Override
            public void failed(final Exception ex) {
                //System.out.println("count:" + count.incrementAndGet());
                ex.printStackTrace();
            }

            @Override
            public void cancelled() {
                //System.out.println("count:" + count.incrementAndGet());
            }


        };
    }

    private static URI getUri(String reqUri, Map<String, String> reqData) throws URISyntaxException {
        URIBuilder uriBuilder = new URIBuilder(reqUri);
        if (null != reqData) {
            for (String key : reqData.keySet()) {
                uriBuilder.addParameter(key, reqData.get(key));
            }
        }
        return uriBuilder.build();
    }
}
