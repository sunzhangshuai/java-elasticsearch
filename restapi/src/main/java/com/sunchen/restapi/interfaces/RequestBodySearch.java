package com.sunchen.restapi.interfaces;

/**
 * @author sunchen
 */
 public interface RequestBodySearch {
    /**
     * 普通查询
     *
     * @param   query   查询内容
     * @param   df      查询字段
     * @param   sort    排序方法
     * @param   from
     * @param   size    分页
     * @param   timeout 超时时间
     * @param   profile 是否查看查询过程
     *
     * @return array
     */
     String search(String query, String df, String sort, String from, String size, String timeout, String profile);

    /**
     * 通过source查询
     *
     * @param  index
     * @param  course
     *
     * @return array
     */
    String source(String index, String[] course);

    /**
     * 脚本查询
     *
     * @return array
     */
    String scriptField();

    /**
     * 匹配查询
     *
     * @return array
     */
    String match();

    /**
     * 匹配查询指定关联方式
     *
     * @return array
     */
    String matchOperate();

    /**
     * 短语匹配
     *
     * @return array
     */
    String matchPhrase();

    /**
     * 短语匹配模糊匹配
     *
     * @return array
     */
    String matchPhraseSlop();

    /**
     * 字符串查询
     *
     * @return array
     */
    String queryString();

    /**
     * 简单字符串查询
     *
     * @return array
     */
    String simpleQueryString();
}
