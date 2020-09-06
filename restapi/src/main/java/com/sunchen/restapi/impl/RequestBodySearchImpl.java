package com.sunchen.restapi.impl;

import com.sunchen.restapi.interfaces.RequestBodySearch;

/**
 * @author sunchen
 */
public class RequestBodySearchImpl implements RequestBodySearch {

    @Override
    public String search(String query, String df, String sort, String from, String size, String timeout, String profile) {
        return null;
    }

    @Override
    public String source(String index, String course) {
        return null;
    }

    @Override
    public String scriptField() {
        return null;
    }

    @Override
    public String match() {
        return null;
    }

    @Override
    public String matchOperate() {
        return null;
    }

    @Override
    public String matchPhrase() {
        return null;
    }

    @Override
    public String matchPhraseSlop() {
        return null;
    }

    @Override
    public String queryString() {
        return null;
    }

    @Override
    public String simpleQueryString() {
        return null;
    }
}
