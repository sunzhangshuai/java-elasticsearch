package com.sunchen.restapi.interfaces;

/**
 * @author sunchen
 */
 public interface TemplateInterface {
    /**
     * 模板设置，静态模板
     *
     * @return arrayi
     */
     String indexTemplate();

    /**
     * 动态模板、设置index的动态转换。
     *
     * @return array
     */
     String dynamicTemplate();

    /**
     * @return array
     */
     String copyTo();
}
