package com.sunchen.restapi.impl;

import com.sunchen.restapi.interfaces.IndexInterface;

/**
 * IndexImpl:
 *
 * @author sunchen
 * @date 2020/8/26 11:56 下午
 */
public class IndexImpl implements IndexInterface {
    @Override
    public String create(String index, String param) {
        return null;
    }

    @Override
    public String indices(String title, String columns, String index_matching) {
        return null;
    }

    @Override
    public String greenIndices() {
        return null;
    }

    @Override
    public String sortIndicesByDocuments() {
        return null;
    }

    @Override
    public String memoryForIndices() {
        return null;
    }

    @Override
    public String indexInfo(String index) {
        return null;
    }

    @Override
    public String documentCount(String index) {
        return null;
    }

    @Override
    public String catDocumentFormat(String index) {
        return null;
    }

    @Override
    public String delete(String index) {
        return null;
    }
}
