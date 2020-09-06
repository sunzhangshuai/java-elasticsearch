package com.sunchen.restapi.impl;

import com.sunchen.restapi.HttpClientUtils;
import com.sunchen.restapi.interfaces.SearchInterface;
import org.springframework.beans.factory.annotation.Value;

/**
 * SearchImpl:
 *
 * @author sunchen
 * @date 2020/9/6 5:57 下午
 */
public class SearchImpl implements SearchInterface {

    @Value("${api.url}")
    private String apiUrl;

    @Override
    public String search() {
        String url = apiUrl + "/_search";
        return HttpClientUtils.doGet(url).getContent();
    }

    @Override
    public String indexSearch(String index) {
        String url = apiUrl + "/" + index + "/_search";
        return HttpClientUtils.doGet(url).getContent();
    }

    @Override
    public String indicesSearch(String[] indices) {
        String indexes = String.join(",", indices);
        String url = apiUrl + "/" + indexes + "/_search";
        return HttpClientUtils.doGet(url).getContent();
    }

    @Override
    public String indexPatternSearch(String indices) {
        String url = apiUrl + "/" + indices + "/_search";
        return HttpClientUtils.doGet(url).getContent();
    }
}
