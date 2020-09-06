package com.sunchen.restapi.impl;

import com.sunchen.restapi.HttpClientResult;
import com.sunchen.restapi.HttpClientUtils;
import com.sunchen.restapi.interfaces.ClusterInterface;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.HashMap;


/**
 * @author sunchen
 */
@Service
public class ClusterImpl implements ClusterInterface {

    @Value("${api.url}")
    private String apiUrl;

    @Override
    public String nodes() {
        HttpClientResult httpClientResult = HttpClientUtils.doGet(apiUrl + "/_cat/nodes");
        return httpClientResult.getContent();
    }

    @Override
    public String nodesTable() {
        HashMap<String,Object>  paramMap = new HashMap<>(1);
        paramMap.put("v", "");
        HttpClientResult httpClientResult = HttpClientUtils.doGet(apiUrl + "/_cat/nodes", paramMap);
        return httpClientResult.getContent();
    }

    @Override
    public String searchNode(String[] nodeNames) {
        String uri = apiUrl + "/_nodes/" + String.join(",", nodeNames);

        HttpClientResult httpClientResult = HttpClientUtils.doGet(uri);
        return httpClientResult.getContent();
    }

    @Override
    public String searchColumn(String[] columns) {
        String uri = apiUrl + "/_cat/nodes";

        HashMap<String,Object>  paramMap = new HashMap<>(2);
        paramMap.put("v", "");
        paramMap.put("h", String.join(",", columns));

        HttpClientResult httpClientResult = HttpClientUtils.doGet(uri, paramMap);
        return httpClientResult.getContent();
    }

    @Override
    public String health() {
        String uri = apiUrl + "/_cluster/health";
        HttpClientResult httpClientResult = HttpClientUtils.doGet(uri);
        return httpClientResult.getContent();
    }

    @Override
    public String shardsHealth() {
        String uri = apiUrl + "/_cluster/health";
        HashMap<String,Object>  paramMap = new HashMap<>(1);
        paramMap.put("level", "shards");
        HttpClientResult httpClientResult = HttpClientUtils.doGet(uri, paramMap);
        return httpClientResult.getContent();
    }

    @Override
    public String indicesHealth(String[] indices) {
        String uri = apiUrl + "/_cluster/health/" + String.join(",", indices);
        System.out.println(uri);
        HttpClientResult httpClientResult = HttpClientUtils.doGet(uri);
        return httpClientResult.getContent();
    }

    @Override
    public String indicesShardsHealth(String[] indices) {
        String uri = apiUrl + "/_cluster/health/" + String.join(",", indices);
        HashMap<String,Object>  paramMap = new HashMap<>(1);
        paramMap.put("level", "shards");
        HttpClientResult httpClientResult = HttpClientUtils.doGet(uri, paramMap);
        return httpClientResult.getContent();
    }

    @Override
    public String cluster() {
        String uri = apiUrl + "/_cluster/state";

        HttpClientResult httpClientResult = HttpClientUtils.doGet(uri);
        return httpClientResult.getContent();
    }

    @Override
    public String clusterSettings() {
        String uri = apiUrl + "/_cluster/settings";

        HttpClientResult httpClientResult = HttpClientUtils.doGet(uri);
        return httpClientResult.getContent();
    }

    @Override
    public String clusterSettingsDefault() {
        String uri = apiUrl + "/_cluster/settings";
        HashMap<String,Object>  paramMap = new HashMap<>(1);
        paramMap.put("include_defaults", "true");
        HttpClientResult httpClientResult = HttpClientUtils.doGet(uri, paramMap);
        return httpClientResult.getContent();
    }

    @Override
    public String shards(boolean title, String[] columns) {
        String uri = apiUrl + "/_cat/shards";
        HashMap<String,Object>  paramMap = new HashMap<>(2);
        if (title) {
            paramMap.put("v", "");
        }
        if (columns != null) {
            paramMap.put("h", String.join(",", columns));
        }

        HttpClientResult httpClientResult = HttpClientUtils.doGet(uri, paramMap);
        return httpClientResult.getContent();
    }
}
