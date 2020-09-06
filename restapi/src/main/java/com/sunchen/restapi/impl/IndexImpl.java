package com.sunchen.restapi.impl;


import com.sunchen.restapi.HttpClientUtils;
import com.sunchen.restapi.interfaces.IndexInterface;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

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
    public String create(String index, Map<String, Object> paramMap) {
        String url = apiUrl + "/" + index;
        return HttpClientUtils.doPut(url).getContent();
    }

    @Override
    public String indices(boolean title, String[] columns, String indexMatching) {
        HashMap<String,Object>  paramMaps = new HashMap<>(2);
        if (title) {
            paramMaps.put("v","");
        }
        if (columns != null) {
            paramMaps.put("h", String.join(",", columns));
        }
        String url = apiUrl + "/_cat/indices/" + indexMatching;
        return HttpClientUtils.doGet(url, paramMaps).getContent();
    }

    @Override
    public String greenIndices() {
        HashMap<String,Object>  paramMaps = new HashMap<>(1);
        paramMaps.put("health","green");
        String url = apiUrl + "_cat/indices";
        return HttpClientUtils.doGet(url, paramMaps).getContent();
    }

    @Override
    public String sortIndicesByDocuments() {
        HashMap<String,Object>  paramMaps = new HashMap<>(1);
        paramMaps.put("s","docs.count:desc");
        String url = apiUrl + "_cat/indices";
        return HttpClientUtils.doGet(url, paramMaps).getContent();
    }

    @Override
    public String memoryForIndices() {
        HashMap<String,Object>  paramMaps = new HashMap<>(1);
        paramMaps.put("h","i,tm");
        String url = apiUrl + "_cat/indices";
        return HttpClientUtils.doGet(url, paramMaps).getContent();
    }

    @Override
    public String indexInfo(String index) {
        String url = apiUrl + "/" + index;
        return HttpClientUtils.doGet(url).getContent();
    }

    @Override
    public String documentCount(String index) {
        String url = apiUrl + "/" + index + "/_count";
        return HttpClientUtils.doGet(url).getContent();
    }

    @Override
    public String catDocumentFormat(String index) {
        String url = apiUrl + "/" + index + "/_search";
        return HttpClientUtils.doGet(url).getContent();
    }

    @Override
    public String delete(String index) {
        String url = apiUrl + "/delete" + index;
        return HttpClientUtils.doPost(url).getContent();
    }
}
