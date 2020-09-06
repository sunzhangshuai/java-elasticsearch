package com.sunchen.restapi.impl;

import com.alibaba.fastjson.JSON;
import com.sunchen.restapi.HttpClientUtils;
import com.sunchen.restapi.interfaces.RequestBodySearch;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;

/**
 * @author sunchen
 */
public class RequestBodySearchImpl implements RequestBodySearch {

    @Value("${api.url}")
    private String apiUrl;

    @Override
    public String search(String query, String df, String sort, String from, String size, String timeout, String profile) {
        return null;
    }

    @Override
    public String source(String index, String[] source) {
        String url = apiUrl + "/" + index + "_search/";
        HashMap paramMaps = new HashMap(1);
        paramMaps.put("_source", source);
        return HttpClientUtils.doPut(url, paramMaps).getContent();
    }

    @Override
    public String scriptField() {
        String json = "{\n" +
                "    \"script_fields\": {\n" +
                "    \"new_field\": {\n" +
                "      \"script\": {\n" +
                "        \"lang\": \"painless\",\n" +
                "        \"source\": \"doc['year'].value+'hello'\"\n" +
                "      }\n" +
                "    }\n" +
                "  }\n" +
                "}";
        HashMap hashMap = JSON.parseObject(json, HashMap.class);
        return  HttpClientUtils.doGet(apiUrl + "/movies/_search", hashMap).getContent();
    }

    @Override
    public String match() {
        String json = "{\n" +
                "    \"query\":{\n" +
                "        \"match\": {\n" +
                "            \"title\":\"Ryan\"\n" +
                "        }\n" +
                "    } \n" +
                "}";
        HashMap hashMap = JSON.parseObject(json, HashMap.class);
        return  HttpClientUtils.doGet(apiUrl + "/movies/_search", hashMap).getContent();
    }

    @Override
    public String matchOperate() {
        String json = "{\n" +
                "    \"query\":{\n" +
                "        \"match\": {\n" +
                "            \"title\":{\n" +
                "                \"query\":\"Ryan White\",\n" +
                "                \"operator\":\"And\"\n" +
                "            }\n" +
                "        }\n" +
                "    } \n" +
                "}";
        HashMap hashMap = JSON.parseObject(json, HashMap.class);
        return  HttpClientUtils.doGet(apiUrl + "/movies/_search", hashMap).getContent();
    }

    @Override
    public String matchPhrase() {
        String json = "{\n" +
                "    \"query\":{\n" +
                "        \"match_phrase\": {\n" +
                "            \"title\":\"Ryan White\"\n" +
                "        }\n" +
                "    } \n" +
                "}";
        HashMap hashMap = JSON.parseObject(json, HashMap.class);
        return  HttpClientUtils.doGet(apiUrl + "/movies/_search", hashMap).getContent();
    }

    @Override
    public String matchPhraseSlop() {
        String json = "{\n" +
                "    \"query\":{\n" +
                "        \"match_phrase\": {\n" +
                "            \"title\":{\n" +
                "                \"query\":\"Ryan Story\",\n" +
                "                \"slop\":2\n" +
                "            }\n" +
                "        }\n" +
                "    } \n" +
                "}";
        HashMap hashMap = JSON.parseObject(json, HashMap.class);
        return  HttpClientUtils.doGet(apiUrl + "/movies/_search", hashMap).getContent();
    }

    @Override
    public String queryString() {
        String json = "{\n" +
                "    \"query\":{\n" +
                "        \"query_string\": {\n" +
                "            \"query\":\"story and white\",\n" +
                "            \"default_field\":\"title\"\n" +
                "        }\n" +
                "    } \n" +
                "}";
        HashMap hashMap = JSON.parseObject(json, HashMap.class);
        return  HttpClientUtils.doGet(apiUrl + "/movies/_search", hashMap).getContent();
    }

    @Override
    public String simpleQueryString() {
        String json = "{\n" +
                "    \"query\":{\n" +
                "        \"simple_query_string\": {\n" +
                "            \"query\":\"story  Japanese\",\n" +
                "            \"fields\":[\"title\"],\n" +
                "            \"default_operator\":\"and\"\n" +
                "        }\n" +
                "    } \n" +
                "}";
        HashMap hashMap = JSON.parseObject(json, HashMap.class);
        return  HttpClientUtils.doGet(apiUrl + "/movies/_search", hashMap).getContent();
    }
}
