package com.sunchen.restapi.interfaces;

/**
 * @author sunchen
 */
public interface UriSearchInterface {
    /**
     * 普通查询
     * @param   query   查询内容
     * @param   df      查询字段
     * @param  sort    排序方法
     * @param  from
     * @param  size    分页
     * @param  timeout 超时时间
     * @param  profile 是否查看查询过程
     *
     * @return array
     */
    void search(String query, String df, String sort, String from, String size, String timeout, String profile);

    /**
     * 范查询
     *
     * @param
     *
     * @return array
     */
    void  genericsSearch(String value);

    /**
     * 第二种范查询
     *
     * @param
     *
     * @return array
     */
    void  mindGenericsSearch(String value);

    /**
     * 指定字段查询
     *
     * @param  field
     * @param  value
     *
     * @return array
     */
    void  fieldSearch(String field, String value);

    /**
     * 短语查询，且，并且前后顺序一致
     *
     * @param  array
     *
     * @return array
     */
    void  phraseSearch(String array);

    /**
     * 分组查询
     *
     * @param  array
     *
     * @return array
     */
    void  groupSearch(String array);

    /**
     * 且查询
     *
     * @param  array
     *
     * @return array
     */
    void  andSearch(String array);

    /**
     * 或查询
     *
     * @param  array
     *
     * @return array
     */
    void  orSearch(String array);

    /**
     * 非查询
     *
     * @param  array
     *
     * @return array
     */
    void  notSearch(String array);

    /**
     * 带符号的查询
     *
     * @param  array
     *
     * @return array
     */
    void  symbolSearch(String array);

    /**
     * 范围查询
     *
     * @param  array
     *
     * @return array
     */
    void  rangeSearch(String array);

    /**
     * 通配符查询
     *
     * @param  string
     *
     * @return array
     */
    void  patternSearch(String string);

    /**
     * 模糊查询
     *
     * @param  string
     *
     * @return array
     */
    void  fuzzySearch(String string);

    /**
     * 近似度查询
     *
     * @param  string
     *
     * @return array
     */
    void approximationQuery(String string);
}
