package com.sunchen.restapi.impl;

import com.sunchen.restapi.HttpClientResult;
import com.sunchen.restapi.HttpClientUtils;
import com.sunchen.restapi.interfaces.IndexInterface;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.HashMap;

/**
 * IndexImpl:
 *
 * @author sunchen
 * @date 2020/8/26 11:56 下午
 */
@Component
public class IndexImpl implements IndexInterface {
    @Value("${api.url}")
    private String apiUrl;

    @Override
    public String create(String index, String json) throws Exception {
        String uri = apiUrl + "/" + index;
        HttpClientResult httpClientResult = HttpClientUtils.jsonPut(uri, json);
        return httpClientResult.getContent();
    }

    @Override
    public String indices(boolean title, String[] columns, String indexMatching) throws Exception {
        String uri = apiUrl + "/_cat/indices";
        HashMap<String, String> paramMap = new HashMap<>(2);
        if (!StringUtils.isEmpty(indexMatching)) {
            uri += '/' + indexMatching;
        }
        if (title) {
            paramMap.put("v", "");
        }
        if (columns != null) {
            paramMap.put("h", String.join(",", columns));
        }
        HttpClientResult httpClientResult = HttpClientUtils.doGet(uri, paramMap);
        return httpClientResult.getContent();
    }

    @Override
    public String greenIndices() throws Exception {
        String uri = apiUrl + "/_cat/indices";
        HashMap<String, String> paramMap = new HashMap<>(1);
        paramMap.put("health", "green");

        HttpClientResult httpClientResult = HttpClientUtils.doGet(uri, paramMap);
        return httpClientResult.getContent();
    }

    @Override
    public String sortIndicesByDocuments() throws Exception {
        String uri = apiUrl + "/_cat/indices";
        HashMap<String, String> paramMap = new HashMap<>(1);
        paramMap.put("s", "docs.count:desc");

        HttpClientResult httpClientResult = HttpClientUtils.doGet(uri, paramMap);
        return httpClientResult.getContent();
    }

    @Override
    public String memoryForIndices() throws Exception {
        String uri = apiUrl + "/_cat/indices";
        HashMap<String, String> paramMap = new HashMap<>(1);
        paramMap.put("s", "tm:desc");
        paramMap.put("v", "");
        paramMap.put("h", "i, tm");
        HttpClientResult httpClientResult = HttpClientUtils.doGet(uri, paramMap);
        return httpClientResult.getContent();
    }

    @Override
    public String indexInfo(String index) throws Exception {
        String uri = apiUrl + "/" + index;
        HttpClientResult httpClientResult = HttpClientUtils.doGet(uri);
        return httpClientResult.getContent();
    }

    @Override
    public String documentCount(String index) throws Exception {
        String uri = apiUrl + "/" + index + "/_count";
        HttpClientResult httpClientResult = HttpClientUtils.doGet(uri);
        return httpClientResult.getContent();
    }

    @Override
    public String catDocumentFormat(String index) throws Exception {
        String uri = apiUrl + "/" + index + "/_search";
        HttpClientResult httpClientResult = HttpClientUtils.doGet(uri);
        return httpClientResult.getContent();
    }

    @Override
    public String delete(String index) throws Exception {
        String uri = apiUrl + "/" + index;
        HttpClientResult httpClientResult = HttpClientUtils.doDelete(uri);
        return httpClientResult.getContent();
    }
}
