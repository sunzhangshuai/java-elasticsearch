package com.sunchen.restapi;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sunchen.restapi.impl.AnalyzerImpl;
import com.sunchen.restapi.impl.ClusterImpl;
import com.sunchen.restapi.impl.IndexImpl;
import com.sunchen.restapi.interfaces.AnalyzerInterface;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@Configuration
@SpringBootTest
class EsApplicationTests {

    @Autowired
    private ClusterImpl cluster;

    @Autowired
    private IndexImpl index;

    @Autowired
    private AnalyzerImpl analyzer;

    @Test
    void contextLoads() {
    }

    @Test
    void testCluster() {
        String content;
        content = cluster.nodes();
        System.out.println(content);
        content = cluster.nodesTable();
        System.out.println(content);
        String[] nodeNames = new String[2];
        nodeNames[0] = "slave01";
        nodeNames[1] = "master";
        content = cluster.searchNode(nodeNames);
        System.out.println(content);
        String[] columns = {"id", "name", "ip", "port", "v", "m"};
        content = cluster.searchColumn(columns);
        System.out.println(content);
        content = cluster.health();
        System.out.println(content);
        content = cluster.shardsHealth();
        System.out.println(content);
        String[] indices = {"movies", "course"};
        content = cluster.indicesHealth(indices);
        System.out.println(content);
        System.out.println("--------------------------------------------------------------------------");
        content = cluster.indicesShardsHealth(indices);
        System.out.println(content);
        System.out.println("--------------------------------------------------------------------------");
        content = cluster.cluster();
        System.out.println(content);
        System.out.println("--------------------------------------------------------------------------");
        content = cluster.clusterSettings();
        System.out.println(content);
        System.out.println("--------------------------------------------------------------------------");
        content = cluster.clusterSettingsDefault();
        System.out.println(content);
        System.out.println("--------------------------------------------------------------------------");
        content = cluster.shards(true, new String[]{"id", "name", "ip", "port", "v", "m"});
        System.out.println(content);
        System.out.println("--------------------------------------------------------------------------");
    }

    @Test
    void testIndex() throws Exception {
//        JSONObject param = new JSONObject();
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("number_of_shards", "2");
//        jsonObject.put("number_of_replicas", "1");
//        param.put("settings", jsonObject);
//        String content = index.create("testtest",null);
//        System.out.println(content);
//        content = index.indices(true, new String[]{
//                        "health", // 健康状态
//                        "status", // 是否开启
//                        "index",  // 索引名
//                        "uuid",   // 索引的唯一id
//                        "pri",
//                        "rep",
//                        "docs.count", // 文档数量
//                },
//                "mov*");
//        System.out.println(content);
//        content = index.greenIndices();
//        System.out.println(content);
//        content = index.sortIndicesByDocuments();
//        System.out.println(content);
//        content = index.memoryForIndices();
//        System.out.println(content);
//        content = index.indexInfo("movies");
//        System.out.println(content);
//        content = index.documentCount("movies");
//        System.out.println(content);
//        content = index.catDocumentFormat("movies");
//        System.out.println(content);
//        content = index.delete("movies");
//        System.out.println(content);
        analyzer.mappingDefinitionAnalyzer();
    }

}
