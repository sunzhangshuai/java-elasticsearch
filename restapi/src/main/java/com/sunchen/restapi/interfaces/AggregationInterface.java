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
     String buckets();

    /**
     * 按照目的地进行分桶统计、并增加统计信息
     *
     * @return array
     */
     String bucketsAndStats();

    /**
     * 按照目的地统计天气信息和价格
     *
     * @return array
     */
     String pipelineBuckets();
}
