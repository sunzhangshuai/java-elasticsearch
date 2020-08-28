package com.sunchen.restapi.interfaces;

/**
 * @author sunchen
 */
public interface ClusterInterface {
    /**
     * 获取所有节点，不含表头
     *
     * @return string
    
     */
     String nodes() throws Exception;

    /**
     * 获取所有节点，含表头
     *
     * @return 
    
     */
     String nodesTable() throws Exception;

    /**
     * 通过节点名称获取节点详情
     *
     * @param   nodeNames
     *
     * @return 
    
     */
     String searchNode(String[] nodeNames) throws Exception;

    /**
     * 指定列获取所有节点信息
     *
     * @param  columns
     *
     * @return 
    
     */
     String searchColumn(String columns);

    /**
     * 集群健康检测
     *
     * @return 
    
     */
     String health();

    /**
     * 分片级别健康检测
     *
     * @return 
    
     */
     String shardsHealth();

    /**
     * 指定索引健康检测
     *
     * @param   indices
     *
     * @return 
    
     */
     String indicesHealth(String indices);

    /**
     * 指定索引的分片级别健康检测
     *
     * @param   indices
     *
     * @return 
    
     */
     String indicesShardsHealth(String indices);

    /**
     * 集群的详细信息
     *
     * @return 
    
     */
     String cluster();

    /**
     * 获取集群的设置
     *
     * @return 
    
     */
     String clusterSettings();

    /**
     * 获取集群的设置，包含默认设置
     *
     * @return 
    
     */
     String clusterSettingsDefault();

    /**
     * 获取分片信息，可指定是否获取表头，和要获取的列
     *
     * @param    title
     * @param   columns
     *
     * @return mixed
    
     */
     String shards(String title, String columns);
}
