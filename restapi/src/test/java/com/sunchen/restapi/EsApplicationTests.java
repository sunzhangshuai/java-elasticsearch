package com.sunchen.restapi;

import com.sunchen.restapi.impl.ClusterImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootTest
class EsApplicationTests {
    @Autowired
    private ClusterImpl cluster;

    @Test
    void contextLoads() {
    }

    @Test
    void testCluster() throws Exception {
        String content = cluster.nodes();
        System.out.println(content);
        content = cluster.nodesTable();
        System.out.println(content);
        String[] nodeNames = new String[2];
        nodeNames[0] = "slave01";
        nodeNames[1] = "master";
        content = cluster.searchNode(nodeNames);
        System.out.println(content);
    }

}
