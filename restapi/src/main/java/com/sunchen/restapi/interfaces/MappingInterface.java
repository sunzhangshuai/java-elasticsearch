package com.sunchen.restapi.interfaces;

/**
 * @author sunchen
 */
public interface MappingInterface {

    String search(String index);

    /**
     * 设置字段不被索引
     * @return array
     */
    String setIndexFalse(String index);

    /**
     * 设置空值查询
     *
     * @param  index
     *
     * @return array
     */
    String setNullValue(String index);

    /**
     * 设置copy to
     *
     * @param  index
     *
     * @return array
     */
    String setCopyTo(String index);

    /**
     * 设置dynamic
     *
     * @param  index
     * @param  dynamic
     *
     * @return array
     */
    String setDynamic(String index, String dynamic);
}
