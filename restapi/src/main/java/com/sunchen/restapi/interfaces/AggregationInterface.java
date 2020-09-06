package com.sunchen.restapi.interfaces;

/**
 * @author sunchen
 */
 public interface AggregationInterface {
    /**
     * 按照目的地进行分桶统计
     *
     * @return array
     */
     void buckets();

    /**
     * 按照目的地进行分桶统计、并增加统计信息
     *
     * @return array
     */
     void bucketsAndStats();

    /**
     * 按照目的地统计天气信息和价格
     *
     * @return array
     */
     void pipelineBuckets();
}
