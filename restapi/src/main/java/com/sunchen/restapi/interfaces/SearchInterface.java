package com.sunchen.restapi.interfaces;

/**
 * SearchInterface:
 * @author sunchen
 * @date 2020/9/6 12:13 下午
 */
 public interface SearchInterface {
    /**
     * 集群上的所有索引查询文档
     */
     String search();

    /**
     * 指定索引查询文档
     * @param index 索引
     */
    String indexSearch(String index);

    /**
     * 指定多个索引查询文档
     * @param indices 索引
     */
    String indicesSearch(String[] indices);

    /**
     * 索引通配符方式查询
     * @param indices 索引
     */
    String indexPatternSearch(String indices);
}
