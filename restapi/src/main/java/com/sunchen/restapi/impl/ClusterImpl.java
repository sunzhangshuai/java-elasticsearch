package com.sunchen.restapi.impl;

import com.sunchen.restapi.HttpClientResult;
import com.sunchen.restapi.HttpClientUtils;
import com.sunchen.restapi.interfaces.ClusterInterface;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author sunchen
 */
@Service
public class ClusterImpl implements ClusterInterface {

    @Value("${api.url}")
    private String apiUrl;

    @Override
    public String nodes() throws Exception {
        HttpClientResult httpClientResult = HttpClientUtils.doGet(apiUrl + "/_cat/nodes");
        return httpClientResult.getContent();
    }

    @Override
    public String nodesTable() throws Exception {
        Map<String,String> paramMap = new HashMap<>(1);
        paramMap.put("v","");
        HttpClientResult httpClientResult = HttpClientUtils.doGet(apiUrl + "/_cat/nodes", paramMap);
        return httpClientResult.getContent();
    }

    @Override
    public String searchNode(String[] nodeNames) throws Exception {
        HttpClientResult httpClientResult = HttpClientUtils.doGet(apiUrl + "/_nodes/"+String.join(",", nodeNames));
        return httpClientResult.getContent();
    }

    @Override
    public String searchColumn(String columns) {
        return null;
    }

    @Override
    public String health() {
        return null;
    }

    @Override
    public String shardsHealth() {
        return null;
    }

    @Override
    public String indicesHealth(String indices) {
        return null;
    }

    @Override
    public String indicesShardsHealth(String indices) {
        return null;
    }

    @Override
    public String cluster() {
        return null;
    }

    @Override
    public String clusterSettings() {
        return null;
    }

    @Override
    public String clusterSettingsDefault() {
        return null;
    }

    @Override
    public String shards(String title, String columns) {
        return null;
    }
}
