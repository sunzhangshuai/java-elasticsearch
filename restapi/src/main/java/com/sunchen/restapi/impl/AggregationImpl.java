package com.sunchen.restapi.impl;

import com.alibaba.fastjson.JSON;
import com.sunchen.restapi.HttpClientUtils;
import com.sunchen.restapi.interfaces.AggregationInterface;
import org.springframework.beans.factory.annotation.Value;
import java.util.HashMap;

/**
 * AggregationImpl:
 *
 * @author sunchen
 * @date 2020/9/7 12:49 上午
 */
public class AggregationImpl implements AggregationInterface {

    @Value("${api.url}")
    private String apiUrl;

    @Override
    public String buckets() {
        HashMap<String, Object> trems = new HashMap<>(1);
        trems.put("field","year");
        HashMap<String, Object> count = new HashMap<>(1);
        count.put("terms", trems);

        HashMap<String, Object> aggs = new HashMap<>(1);
        aggs.put("count", count);

        HashMap<String, Object> params = new HashMap<>(1);
        params.put("aggs", aggs);
        params.put("size",0);
        return  HttpClientUtils.doGet(apiUrl + "/movies/_search", params).getContent();
    }

    @Override
    public String bucketsAndStats() {
        String json = "{\n" +
                "    \"aggs\":{\n" +
                "        \"bucket\":{\n" +
                "            \"terms\":{\n" +
                "                \"field\":\"year\"\n" +
                "            },\n" +
                "            \"aggs\":{\n" +
                "                \"detail\":{\n" +
                "                    \"stats\":{\n" +
                "                        \"field\":\"year\"\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "    },\n" +
                "    \"size\":0\n" +
                "}";
        HashMap hashMap = JSON.parseObject(json, HashMap.class);
        return  HttpClientUtils.doGet(apiUrl + "/movies/_search", hashMap).getContent();
    }

    @Override
    public String pipelineBuckets() {
        String json = "{\n" +
                "    \"aggs\":{\n" +
                "        \"bucket\":{\n" +
                "            \"terms\":{\n" +
                "                \"field\":\"DestCountry\"\n" +
                "            },\n" +
                "            \"aggs\":{\n" +
                "                \"detail\":{\n" +
                "                    \"terms\":{\n" +
                "                        \"field\":\"OriginWeather\"\n" +
                "                    }\n" +
                "                },\n" +
                "                 \"info\":{\n" +
                "                    \"terms\":{\n" +
                "                        \"field\":\"AvgTicketPrice\"\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "    },\n" +
                "    \"size\":0\n" +
                "}";
        HashMap hashMap = JSON.parseObject(json, HashMap.class);
        return  HttpClientUtils.doGet(apiUrl + "/kibana_sample_data_flights/_search", hashMap).getContent();
    }
}
