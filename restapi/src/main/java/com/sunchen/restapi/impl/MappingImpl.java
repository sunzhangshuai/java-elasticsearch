package com.sunchen.restapi.impl;

import com.sunchen.restapi.HttpClientUtils;
import com.sunchen.restapi.interfaces.MappingInterface;
import org.springframework.beans.factory.annotation.Value;
import java.util.HashMap;

/**
 * MappingImpl:
 *
 * @author sunchen
 * @date 2020/9/7 12:16 上午
 */
public class MappingImpl implements MappingInterface {

    @Value("${api.url}")
    private String apiUrl;

    @Override
    public String search(String index) {
        String url = apiUrl + "/" + index + "/_mapping";
        return HttpClientUtils.doGet(url).getContent();
    }

    @Override
    public String setIndexFalse(String index) {
        HashMap<String,Object> paramsMap = new HashMap<>(2);
        paramsMap.put("type","keyword");
        paramsMap.put("index", false);
        //打包字段
        HashMap<String, Object> map = new HashMap<>(1);
        map.put("name", paramsMap);
        //打包properties
        HashMap<String, Object> properties = new HashMap<>(1);
        properties.put("properties",map);
        //打包mappings
        HashMap<String, Object> mappings = new HashMap<>(1);
        mappings.put("mapping", properties);
        String url = apiUrl + "/" + index;
        return HttpClientUtils.doGet(url, mappings).getContent();
    }

    @Override
    public String setNullValue(String index) {
        HashMap<String,Object> paramsMap = new HashMap<>(2);
        paramsMap.put("type","keyword");
        paramsMap.put("null_value", "NULL");
        //打包字段
        HashMap<String, Object> map = new HashMap<>(1);
        map.put("name", paramsMap);
        //打包properties
        HashMap<String, Object> properties = new HashMap<>(1);
        properties.put("properties",map);
        //打包mappings
        HashMap<String, Object> mappings = new HashMap<>(1);
        mappings.put("mapping", properties);
        String url = apiUrl + "/" + index;
        return HttpClientUtils.doGet(url, mappings).getContent();
    }

    @Override
    public String setCopyTo(String index) {
        HashMap<String,Object> paramsMap = new HashMap<>(2);
        paramsMap.put("type","keyword");
        paramsMap.put("copy_to", "fullName");
        //打包字段
        HashMap<String, Object> map = new HashMap<>(1);
        map.put("name", paramsMap);
        //打包properties
        HashMap<String, Object> properties = new HashMap<>(1);
        properties.put("properties",map);
        //打包mappings
        HashMap<String, Object> mappings = new HashMap<>(1);
        mappings.put("mapping", properties);
        String url = apiUrl + "/" + index;
        return HttpClientUtils.doGet(url, mappings).getContent();
    }

    /**
     *
     * @param  index
     * @param  dynamic  1.true 2.false 3.strict 未定义的字段插入失败
     *
     * @return
     */
    @Override
    public String setDynamic(String index, String dynamic) {
        HashMap<String,Object> paramsMap = new HashMap<>(2);
        paramsMap.put("dynamic",dynamic);
        String url = apiUrl + "/" + index;
        return HttpClientUtils.doGet(url, paramsMap).getContent();
    }
}
