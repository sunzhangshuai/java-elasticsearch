package com.sunchen.restapi.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sunchen.restapi.HttpClientUtils;
import com.sunchen.restapi.interfaces.AnalyzerInterface;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * AnalyzerImpl:
 *
 * @author sunchen
 * @date 2020/9/6 5:59 下午
 */
@Service
public class AnalyzerImpl implements AnalyzerInterface {

    @Value("${api.url}")
    private String apiUrl;

    @Override
    public String testByAnalyzer(String analyzer, String text) {
        HashMap<String, Object> paramMap = new HashMap<>(2);
        paramMap.put("analyzer", analyzer);
        paramMap.put("text", text);
        String url = apiUrl + "/_analyze";
        return HttpClientUtils.doGet(url, paramMap).getContent();
    }

    @Override
    public String testByField(String index, String field, String text) {
        HashMap<String, Object> paramMap = new HashMap<>(2);
        paramMap.put("filed", field);
        paramMap.put("text", text);
        String url = apiUrl + "/" + index + "/_analyze";
        return HttpClientUtils.doGet(url, paramMap).getContent();
    }

    @Override
    public String testByCustom(String tokenizer, String[] charFilter, String[] filter, String text) {
        HashMap<String, Object> paramMap = new HashMap<>(2);
        paramMap.put("filter", filter);
        paramMap.put("char_filter", charFilter);
        paramMap.put("text", text);
        paramMap.put("tokenizer", tokenizer);
        String url = apiUrl + "/_analyze";
        return HttpClientUtils.doGet(url, paramMap).getContent();
    }

    /**
     * 切割非字母
     *
     * @param text
     * @return
     */
    @Override
    public String standardAnalyzer(String text) {
        HashMap<String, Object> paramMap = new HashMap<>(2);
        paramMap.put("analyzer", "standard");
        paramMap.put("text", text);
        String url = apiUrl + "/_analyze";
        return HttpClientUtils.doGet(url, paramMap).getContent();
    }

    @Override
    public String simpleAnalyzer(String text) {
        HashMap<String, Object> paramMap = new HashMap<>(2);
        paramMap.put("analyzer", "simple");
        paramMap.put("text", text);
        String url = apiUrl + "/_analyze";
        return HttpClientUtils.doGet(url, paramMap).getContent();
    }

    @Override
    public String whitespaceAnalyzer(String text) {
        HashMap<String, Object> paramMap = new HashMap<>(2);
        paramMap.put("analyzer", "whitespace");
        paramMap.put("text", text);
        String url = apiUrl + "/_analyze";
        return HttpClientUtils.doGet(url, paramMap).getContent();
    }

    @Override
    public String stopAnalyzer(String text) {
        HashMap<String, Object> paramMap = new HashMap<>(2);
        paramMap.put("analyzer", "stop");
        paramMap.put("text", text);
        String url = apiUrl + "/_analyze";
        return HttpClientUtils.doGet(url, paramMap).getContent();
    }

    @Override
    public String keywordAnalyzer(String text) {
        HashMap<String, Object> paramMap = new HashMap<>(2);
        paramMap.put("analyzer", "keyword");
        paramMap.put("text", text);
        String url = apiUrl + "/_analyze";
        return HttpClientUtils.doGet(url, paramMap).getContent();
    }

    @Override
    public String patternAnalyzer(String text) {
        HashMap<String, Object> paramMap = new HashMap<>(2);
        paramMap.put("analyzer", "pattern");
        paramMap.put("text", text);
        String url = apiUrl + "/_analyze";
        return HttpClientUtils.doGet(url, paramMap).getContent();
    }

    @Override
    public String englishAnalyzer(String text) {
        HashMap<String, Object> paramMap = new HashMap<>(2);
        paramMap.put("analyzer", "english");
        paramMap.put("text", text);
        String url = apiUrl + "/_analyze";
        return HttpClientUtils.doGet(url, paramMap).getContent();
    }

    @Override
    public String icuanalyzer(String text) {
        HashMap<String, Object> paramMap = new HashMap<>(2);
        paramMap.put("analyzer", "icu");
        paramMap.put("text", text);
        String url = apiUrl + "/_analyze";
        return HttpClientUtils.doGet(url, paramMap).getContent();
    }

    @Override
    public String ikanalyzer(String text) {
        HashMap<String, Object> paramMap = new HashMap<>(2);
        paramMap.put("analyzer", "ik");
        paramMap.put("text", text);
        String url = apiUrl + "/_analyze";
        return HttpClientUtils.doGet(url, paramMap).getContent();
    }

    @Override
    public String mappingDefinitionAnalyzer() {
        List<String> charFilterNames = new ArrayList<>();
        charFilterNames.add("sunchen");
        List<String> filter = new ArrayList<>();
        filter.add("maomap1");
        filter.add("maomap2");

        // 定义分词器myCustomAnalyzer
        HashMap<String, Object> myCustomAnalyzer = new HashMap<>();
        myCustomAnalyzer.put("type", "custom");
        myCustomAnalyzer.put("char_filter", charFilterNames);
        myCustomAnalyzer.put("tokenizer", "zhangshuai");
        myCustomAnalyzer.put("filter", filter);

        // 打包分词器
        HashMap<String, Object> analyzerMap = new HashMap<>();
        analyzerMap.put("my_custom_analyzer", myCustomAnalyzer);

        // 定义整体过滤器sunchen
        HashMap<String, Object> sunchen = new HashMap<>();
        List<String> mappings = new ArrayList<>();
        mappings.add("laogong => 比心");
        mappings.add("laopo => 真懒");
        sunchen.put("type", "mapping");
        sunchen.put("mappings", mappings);

        // 打包整体过滤器
        HashMap<String, Object> charFilter = new HashMap<>();
        charFilter.put("sunchen", sunchen);

        // 定义分词token   zhangshuai
        HashMap<String, Object> zhangshuai = new HashMap<>();
        zhangshuai.put("type","standard");
        //打包tokenizer
        HashMap<String,Object> tokenizer = new HashMap<>();
        tokenizer.put("zhangshuai", zhangshuai);

        //定义filter
        HashMap<String, Object> maomap1 = new HashMap<>();
        maomap1.put("type","stop");
        maomap1.put("stopword","mao");
        HashMap<String, Object> maomap2 = new HashMap<>();
        maomap2.put("type","stop");
        maomap2.put("stopword","mao2");
        //打包filter
        HashMap<String,Object> filters = new HashMap<>();
        filters.put("maomap1",maomap1);
        filters.put("maomap2",maomap2);
        // 打包分词
        HashMap<String, Object> analysis = new HashMap<>();
        analysis.put("analyzer", analyzerMap);
        analysis.put("char_filter", charFilter);
        analysis.put("tokenizer", tokenizer);
        analysis.put("filter", filters);

        //打包setting
        Map<String, Object> settings = new HashMap<>();

        settings.put("analysis", analysis);
        settings.put("number_of_shards",2);

        //打包参数
        Map<String, Object> maps = new HashMap<>();
        maps.put("settings", settings);

        String str = JSON.toJSONString(maps);
        System.out.println(str);
        String url = apiUrl + "/test";
        //return HttpClientUtils.doGet(url, maps).getContent();
        return null;
    }
}
