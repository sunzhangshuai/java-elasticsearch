package com.sunchen.restapi.impl;

import com.sunchen.restapi.interfaces.DocumentInterface;

/**
 * DocumentImpl:
 *
 * @author sunchen
 * @date 2020/8/26 11:56 下午
 */
public class DocumentImpl implements DocumentInterface {
    @Override
    public String create(String index, String document) {
        return null;
    }

    @Override
    public String createById(String index, String id, String document) {
        return null;
    }

    @Override
    public String createById2(String index, String id, String document) {
        return null;
    }

    @Override
    public String find(String index, String id) {
        return null;
    }

    @Override
    public String index(String index, String id, String document) {
        return null;
    }

    @Override
    public String update(String index, String id, String document) {
        return null;
    }

    @Override
    public String delete(String index, String id) {
        return null;
    }

    @Override
    public String bulk() {
        return null;
    }

    @Override
    public String mget(String param) {
        return null;
    }

    @Override
    public String mgetByIndex(String index, String param) {
        return null;
    }

    @Override
    public String msearch(String index, String param) {
        return null;
    }
}
