package com.sunchen.restapi.impl;

import com.sunchen.restapi.HttpClientUtils;
import com.sunchen.restapi.interfaces.DocumentInterface;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;

/**
 * DocumentImpl:
 * @author sunchen
 * @date 2020/8/26 11:56 下午
 */
public class DocumentImpl implements DocumentInterface {

    @Value("${api.url}")
    private String apiUrl;

    @Override
    public String create(String index, String document) {
        String url = apiUrl + "/" + index + "_doc";
        return HttpClientUtils.jsonPost(url, document).getContent();
    }

    @Override
    public String createById(String index, String id, String document) {
        String url = apiUrl + "/" + index + "_doc/" + id;
        HashMap paramMaps = new HashMap(1);
        paramMaps.put("op_type", "create");
        return HttpClientUtils.doPut(url, paramMaps).getContent();
    }

    @Override
    public String createById2(String index, String id, String document) {
        String url = apiUrl + "/" + index + "_create/" + id;
        return HttpClientUtils.doPut(url).getContent();
    }

    @Override
    public String find(String index, String id) {
        String url = apiUrl + "/" + index + "_doc/" + id;
        return HttpClientUtils.doGet(url).getContent();
    }

    @Override
    public String index(String index, String id, String document) {
        String url = apiUrl + "/" + index + "_doc/" + id;
        return HttpClientUtils.jsonPost(url,document).getContent();
    }

    @Override
    public String update(String index, String id, String document) {
        String url = apiUrl + "/" + index + "_update/" + id;
        return HttpClientUtils.jsonPost(url,document).getContent();
    }

    @Override
    public String delete(String index, String id) {
        String url = apiUrl + "/" + index + "_doc/" + id;
        return HttpClientUtils.doDelete(url).getContent();
    }

    @Override
    public String bulk() {

        return null;
    }

    @Override
    public String mGet(String param) {
        return null;
    }

    @Override
    public String mGetByIndex(String index, String param) {
        return null;
    }

    @Override
    public String mSearch(String index, String param) {
        return null;
    }
}
