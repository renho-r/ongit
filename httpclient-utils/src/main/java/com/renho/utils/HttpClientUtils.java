package com.renho.utils;

import com.renho.utils.httputils.HttpAsyncClientUtils;
import com.renho.utils.httputils.HttpSyncClientUtils;
import com.renho.utils.httputils.exception.AppHttpException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

public class HttpClientUtils {

    public static String doGet(String reqUri) throws AppHttpException, IOException, URISyntaxException {
        return HttpSyncClientUtils.GET.request(reqUri);
    }

    public static String doGet(String reqUri, Map<String, String> reqData) throws AppHttpException, IOException, URISyntaxException {
        return HttpSyncClientUtils.GET.request(reqUri, reqData);
    }

    public static String doGetWithContext(String reqUri) throws AppHttpException, IOException, URISyntaxException {
        return HttpSyncClientUtils.GET.requestWithContext(reqUri);
    }

    public static String doGetWithContext(String reqUri, Map<String, String> reqData) throws AppHttpException, IOException, URISyntaxException {
        return HttpSyncClientUtils.GET.requestWithContext(reqUri, reqData);
    }

    public static String doPost(String reqUri, String bodyData) throws AppHttpException, IOException, URISyntaxException {
        return HttpSyncClientUtils.POST.request(reqUri, bodyData);
    }

    public static String doPost(String reqUri, Map<String, String> reqData) throws AppHttpException, IOException, URISyntaxException {
        return HttpSyncClientUtils.POST.request(reqUri, reqData);
    }

    public static String doPostWithContext(String reqUri, String bodyData) throws AppHttpException, IOException, URISyntaxException {
        return HttpSyncClientUtils.POST.requestWithContext(reqUri, bodyData);
    }

    public static String doPostWithContext(String reqUri, Map<String, String> reqData) throws AppHttpException, IOException, URISyntaxException {
        return HttpSyncClientUtils.POST.requestWithContext(reqUri, reqData);
    }

    public static String doPostAsync(String reqUri, Map<String, String> reqData) throws AppHttpException, IOException, URISyntaxException {
        return HttpAsyncClientUtils.POST.request(reqUri, reqData);
    }

}
