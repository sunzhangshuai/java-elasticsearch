package com.sunchen.restapi.interfaces;

import java.util.Map;

/**
 * DocumentInterface:
 *
 * @author sunchen
 * @date 2020/8/26 11:24 下午
 */
 public interface DocumentInterface {
    /**
     * 创建不指定id的文档
     *
     * @param  index
     * @param  json
     *
     * @return array
    
     */
     String create(String index, String json);

    /**
     * 创建指定id的文档
     *
     * @param     index
     * @param        id
     * @param      json
     *
     * @return array
    
     */
     String  createById(String index, String id, String json);

    /**
     * 创建指定id的文档，第二种写法
     *
     * @param   index
     * @param   id
     * @param   document
     *
     * @return array
    
     */
     String  createById2(String index, String id, String document);

    /**
     * 指定id获取文档
     *
     * @param   index
     * @param   id
     *
     * @return array
    
     */
     String  find(String index, String id);

    /**
     * 对原文档先删除，再写入（覆盖操作）
     *
     * @param   index
     * @param   id
     * @param   document
     *
     * @return array
    
     */
     String  index(String index, String id, String document);

    /**
     * 在原文档的基础上修改，可增加字段
     *
     * @param   index
     * @param   id
     * @param   document
     *
     * @return array
    
     */
     String  update(String index, String id, String document);

    /**
     * 删除文档
     *
     * @param   index
     * @param   id
     *
     * @return array
    
     */
     String  delete(String index, String id);

    /**
     * 多条指令批量操作
     *
     * @return array
    
     */
     String  bulk();

    /**
     * 批量获取
     *
     * @param   param
     *
     * @return array
    
     */
     String mGet(String param);

    /**
     * 指定索引批量获取
     *
     * @param   index
     * @param   param
     *
     * @return array
    
     */
     String mGetByIndex(String index, String param);

    /**
     * 指定索引批量查询
     *
     * @param   index
     * @param  param
     *
     * @return mixed
    
     */
     String mSearch(String index, String param);
}
