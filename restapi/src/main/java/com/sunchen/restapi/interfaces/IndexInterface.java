package com.sunchen.restapi.interfaces;

import java.util.HashMap;

/**
 * @author sunchen
 */
 public interface IndexInterface {

    /**
     * 创建索引
     * @param  index
     * @param  param
     * @return array
     */
     String create(String index, String json) throws Exception;

    /**
     * 查看索引列表
     * @param  title
     * @param  columns
     * @param  indexMatching 支持正则
     * @return string
     */
     String indices(boolean title, String[] columns, String indexMatching) throws Exception;

    /**
     * 查看状态为绿的索引
     * @return array
     */
     String greenIndices() throws Exception;

    /**
     * 按照文档个数排序
     * @return array
     */
     String sortIndicesByDocuments() throws Exception;

    /**
     * 查看每个索引使用的内存数
     * @return array
     */
     String memoryForIndices() throws Exception;

    /**
     * 查看索引的相关信息
     * @param  index
     *
     * @return array
    
     */
     String indexInfo(String index) throws Exception;

    /**
     * 查看索引的文档总数
     *
     * @param  index
     *
     * @return array
    
     */
     String documentCount(String index) throws Exception;

    /**
     * 通过获取前10条文档来查看文档格式
     *
     * @param  index
     *
     * @return array
    
     */
     String catDocumentFormat(String index) throws Exception;

    /**
     * 删除索引
     *
     * @param  index
     *
     * @return array
    
     */
     String delete(String index) throws Exception;
}
