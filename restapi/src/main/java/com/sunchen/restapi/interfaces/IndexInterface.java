package com.sunchen.restapi.interfaces;

import java.util.Map;

/**
 * @author sunchen
 */
public interface IndexInterface {

    /**
     * 创建索引
     *
     * @param index
     * @param paramMap
     * @return array
     */
    String create(String index, Map<String, Object> paramMap);

    /**
     * 查看索引列表
     *
     * @param title
     * @param columns
     * @param indexMatching 支持正则
     * @return string
     */
    String indices(boolean title, String[] columns, String indexMatching);

    /**
     * 查看状态为绿的索引
     *
     * @return array
     */
    String greenIndices();

    /**
     * 按照文档个数排序
     *
     * @return array
     */
    String sortIndicesByDocuments();

    /**
     * 查看每个索引使用的内存数
     *
     * @return array
     */
    String memoryForIndices();

    /**
     * 查看索引的相关信息
     *
     * @param index
     * @return array
     */
    String indexInfo(String index);

    /**
     * 查看索引的文档总数
     *
     * @param index
     * @return array
     */
    String documentCount(String index);

    /**
     * 通过获取前10条文档来查看文档格式
     *
     * @param index
     * @return array
     */
    String catDocumentFormat(String index);

    /**
     * 删除索引
     *
     * @param index
     * @return array
     */
    String delete(String index);
}
