package com.renho.utils.httputils;

import com.renho.utils.httputils.exception.AppHttpException;
import com.renho.utils.httputils.httpsyncclient.HttpSyncClientPool;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public enum HttpSyncClientUtils {

    GET {
        public String request(String reqUri, Map<String, String> reqData, HttpContext httpContext, RequestConfig requestConfig, CloseableHttpClient httpClient) throws URISyntaxException, IOException, AppHttpException {
            URI uri = getUri(reqUri, reqData);
            HttpGet httpGet = new HttpGet();
            httpGet.setConfig(requestConfig);
            httpGet.setURI(uri);
            return doRequest(httpClient, httpContext, httpGet);
        }

        public String request(String reqUri, Map<String, String> reqData, HttpContext httpContext, RequestConfig requestConfig) throws AppHttpException, IOException, URISyntaxException {
            return this.request(reqUri, reqData, httpContext, requestConfig, HTTP_CLIENT);
        }

        public String request(String reqUri, Map<String, String> reqData, HttpContext httpContext) throws AppHttpException, IOException, URISyntaxException {
            return this.request(reqUri, reqData, httpContext, REQUEST_CONFIG, HTTP_CLIENT);
        }

        public String request(String reqUri, Map<String, String> reqData, RequestConfig requestConfig) throws AppHttpException, IOException, URISyntaxException {
            return this.request(reqUri, reqData, null, requestConfig, HTTP_CLIENT);
        }

        public String request(String reqUri, Map<String, String> reqData, CloseableHttpClient httpClient) throws AppHttpException, IOException, URISyntaxException {
            return this.request(reqUri, reqData, null, REQUEST_CONFIG, httpClient);
        }

        public String request(String reqUri, Map<String, String> reqData) throws AppHttpException, IOException, URISyntaxException {
            return this.request(reqUri, reqData, null, REQUEST_CONFIG, HTTP_CLIENT);
        }

        public String request(String reqUri) throws AppHttpException, IOException, URISyntaxException {
            return this.request(reqUri, (Map<String, String>) null);
        }

        public String requestWithContext(String reqUri, Map<String, String> reqData) throws AppHttpException, IOException, URISyntaxException {
            return this.request(reqUri, reqData, HTTP_CONTEXT, REQUEST_CONFIG, HTTP_CLIENT);
        }

        public String requestWithContext(String reqUri) throws AppHttpException, IOException, URISyntaxException {
            return this.requestWithContext(reqUri, (Map<String, String>) null);
        }
    },
    POST {
        public String request(String reqUri, String bodyData, HttpContext httpContext, RequestConfig requestConfig, CloseableHttpClient httpClient) throws URISyntaxException, IOException, AppHttpException {
            URI uri = new URI(reqUri);
            HttpPost httpPost = new HttpPost();
            httpPost.setConfig(requestConfig);
            httpPost.setURI(uri);
            StringEntity reqEntity = new StringEntity(bodyData, "utf-8");
            reqEntity.setContentEncoding("UTF-8");
            reqEntity.setContentType("application/json");
            httpPost.setEntity(reqEntity);
            return doRequest(httpClient, httpContext, httpPost);
        }

        public String request(String reqUri, String bodyData, HttpContext httpContext, RequestConfig requestConfig) throws AppHttpException, IOException, URISyntaxException {
            return this.request(reqUri, bodyData, httpContext, requestConfig, HTTP_CLIENT);
        }

        public String requestBody(String reqUri, String bodyData, HttpContext httpContext) throws AppHttpException, IOException, URISyntaxException {
            return this.request(reqUri, bodyData, httpContext, REQUEST_CONFIG, HTTP_CLIENT);
        }

        public String request(String reqUri, String bodyData, RequestConfig requestConfig) throws AppHttpException, IOException, URISyntaxException {
            return request(reqUri, bodyData, null, requestConfig, HTTP_CLIENT);
        }

        public String request(String reqUri, String bodyData, CloseableHttpClient httpClient) throws AppHttpException, IOException, URISyntaxException {
            return request(reqUri, bodyData, null, REQUEST_CONFIG, httpClient);
        }

        public String request(String reqUri, String bodyData) throws AppHttpException, IOException, URISyntaxException {
            return request(reqUri, bodyData, null, REQUEST_CONFIG, HTTP_CLIENT);
        }

        public String requestWithContext(String reqUri, String bodyData) throws AppHttpException, IOException, URISyntaxException {
            return request(reqUri, bodyData, HTTP_CONTEXT, REQUEST_CONFIG, HTTP_CLIENT);
        }

        public String request(String reqUri, Map<String, String> reqData, HttpContext httpContext, RequestConfig requestConfig, CloseableHttpClient httpClient) throws URISyntaxException, IOException, AppHttpException {
            List<NameValuePair> paramList = new ArrayList<>();
            for (String key : reqData.keySet()) {
                paramList.add(new BasicNameValuePair(key, reqData.get(key)));
            }
            // 模拟表单
            UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(paramList, "utf-8");
            URI uri = new URI(reqUri);
            HttpPost httpPost = new HttpPost();
            httpPost.setConfig(requestConfig);
            httpPost.setURI(uri);
            urlEncodedFormEntity.setContentEncoding("UTF-8");
            urlEncodedFormEntity.setContentType("application/json");
            httpPost.setEntity(urlEncodedFormEntity);
            return doRequest(httpClient, httpContext, httpPost);
        }

        public String request(String reqUri, Map<String, String> reqData, HttpContext httpContext, RequestConfig requestConfig) throws AppHttpException, IOException, URISyntaxException {
            return this.request(reqUri, reqData, httpContext, requestConfig, HTTP_CLIENT);
        }

        public String request(String reqUri, Map<String, String> reqData, HttpContext httpContext) throws AppHttpException, IOException, URISyntaxException {
            return this.request(reqUri, reqData, httpContext, REQUEST_CONFIG, HTTP_CLIENT);
        }

        public String request(String reqUri, Map<String, String> reqData, RequestConfig requestConfig) throws AppHttpException, IOException, URISyntaxException {
            return request(reqUri, reqData, null, requestConfig, HTTP_CLIENT);
        }

        public String request(String reqUri, Map<String, String> reqData, CloseableHttpClient httpClient) throws AppHttpException, IOException, URISyntaxException {
            return request(reqUri, reqData, null, REQUEST_CONFIG, httpClient);
        }

        public String request(String reqUri, Map<String, String> reqData) throws AppHttpException, IOException, URISyntaxException {
            return request(reqUri, reqData, null, REQUEST_CONFIG, HTTP_CLIENT);
        }

        public String requestWithContext(String reqUri, Map<String, String> reqData) throws AppHttpException, IOException, URISyntaxException {
            return request(reqUri, reqData, HTTP_CONTEXT, REQUEST_CONFIG, HTTP_CLIENT);
        }
    };

    //公共

    public String request(String reqUri) throws AppHttpException, IOException, URISyntaxException {
        throw new AbstractMethodError();
    }

    public String request(String reqUri, String bodyData) throws AppHttpException, IOException, URISyntaxException {
        throw new AbstractMethodError();
    }

    public String request(String reqUri, Map<String, String> reqData) throws AppHttpException, IOException, URISyntaxException {
        throw new AbstractMethodError();
    }

    public String requestWithContext(String reqUri) throws AppHttpException, IOException, URISyntaxException {
        throw new AbstractMethodError();
    }

    public String requestWithContext(String reqUri, String bodyData) throws AppHttpException, IOException, URISyntaxException {
        throw new AbstractMethodError();
    }

    public String requestWithContext(String reqUri, Map<String, String> reqData) throws AppHttpException, IOException, URISyntaxException {
        throw new AbstractMethodError();
    }

    private static final CloseableHttpClient HTTP_CLIENT = HttpSyncClientPool.getHttpClient();
    private static final HttpContext HTTP_CONTEXT = HttpClientContext.create();
    private static final RequestConfig REQUEST_CONFIG = HttpSyncClientPool.getGlobalConfig();

    public static HttpClient newHttpClient() {
        return HttpSyncClientPool.getHttpClient();
    }

    public static HttpContext newHttpContext() {
        return HttpClientContext.create();
    }

    public static RequestConfig defaultRequestConfig() {
        return REQUEST_CONFIG;
    }

    public static String doRequest(CloseableHttpClient httpClient, HttpContext httpContext, HttpRequestBase httpRequestBase) throws AppHttpException, IOException {
        String respData = null;
        CloseableHttpResponse response = httpClient.execute(httpRequestBase, httpContext);
        try {
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            if (HttpStatus.SC_OK != statusLine.getStatusCode()) {
                throw new AppHttpException(String.valueOf(statusCode), null, statusLine);
            } else {
                HttpEntity respEntity = response.getEntity();
                respData = EntityUtils.toString(respEntity);

            }
        } finally {
            response.close();
        }
        return respData;
    }

    public static String doRequest(HttpRequestBase httpRequestBase) throws AppHttpException, IOException {
        return doRequest(HTTP_CLIENT, HTTP_CONTEXT, httpRequestBase);
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
