package com.sunchen.restapi.impl;

import com.sunchen.restapi.interfaces.TemplateInterface;
import org.springframework.beans.factory.annotation.Value;

/**
 * TemplateImpl:
 *
 * @author sunchen
 * @date 2020/9/7 12:47 上午
 */
public class TemplateImpl implements TemplateInterface {
    @Value("${api.url}")
    private String apiUrl;

    @Override
    public String indexTemplate() {
        return null;
    }

    @Override
    public String dynamicTemplate() {
        return null;
    }

    @Override
    public String copyTo() {
        return null;
    }
}
