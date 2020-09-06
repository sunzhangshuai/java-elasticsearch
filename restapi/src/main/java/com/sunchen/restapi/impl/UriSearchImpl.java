package com.sunchen.restapi.impl;

import com.sunchen.restapi.interfaces.UriSearchInterface;
import org.springframework.beans.factory.annotation.Value;

/**
 * UriSearchImpl:
 *
 * @author sunchen
 * @date 2020/9/7 12:48 上午
 */
public class UriSearchImpl implements UriSearchInterface {
    @Value("${api.url}")
    private String apiUrl;

    @Override
    public String search(String query, String df, String sort, String from, String size, String timeout, String profile) {
        return null;
    }

    @Override
    public String genericsSearch(String value) {
        return null;
    }

    @Override
    public String mindGenericsSearch(String value) {
        return null;
    }

    @Override
    public String fieldSearch(String field, String value) {
        return null;
    }

    @Override
    public String phraseSearch(String array) {
        return null;
    }

    @Override
    public String groupSearch(String array) {
        return null;
    }

    @Override
    public String andSearch(String array) {
        return null;
    }

    @Override
    public String orSearch(String array) {
        return null;
    }

    @Override
    public String notSearch(String array) {
        return null;
    }

    @Override
    public String symbolSearch(String array) {
        return null;
    }

    @Override
    public String rangeSearch(String array) {
        return null;
    }

    @Override
    public String patternSearch(String string) {
        return null;
    }

    @Override
    public String fuzzySearch(String string) {
        return null;
    }

    @Override
    public String approximationQuery(String string) {
        return null;
    }
}
