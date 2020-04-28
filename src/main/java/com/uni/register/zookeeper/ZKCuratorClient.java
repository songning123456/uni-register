package com.uni.register.zookeeper;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author songning
 * @date 2020/4/24
 * description
 */
@Component
@Slf4j
public class ZKCuratorClient {
    /**
     * zk客户端
     */
    private CuratorFramework curatorFramework = null;

    @Value("${zookeeper.url}")
    private String zkUrl;
    @Value("${zookeeper.namespace}")
    private String zkNamespace;
    @Value("${zookeeper.node}")
    private String zkNode;

    public void init() {
        if (curatorFramework != null) {
            return;
        }
        // 重试策略
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 5);
        // 创建zk客户端
        curatorFramework = CuratorFrameworkFactory.builder().connectString(zkUrl).sessionTimeoutMs(10000).retryPolicy(retryPolicy).namespace(zkNamespace).build();
        // 启动客户端
        curatorFramework.start();
        try {
            if (curatorFramework.checkExists().forPath(zkNode) == null) {
                curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).withACL(ZooDefs.Ids.OPEN_ACL_UNSAFE).forPath(zkNode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendOperator(String childNode, String strParams) {
        try {
            if (curatorFramework.checkExists().forPath(zkNode + "/" + childNode) == null) {
                log.info("~~~当前zk {}节点不存在,准备创建~~~", zkNode + "/" + childNode);
                curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).withACL(ZooDefs.Ids.OPEN_ACL_UNSAFE).forPath(zkNode + "/" + childNode, "".getBytes());
            }
            if (curatorFramework.checkExists().forPath(zkNode + "/" + childNode) != null) {
                log.info("~~~当前zk {}节点已经存在,准备发送数据~~~", zkNode + "/" + childNode);
                curatorFramework.setData().forPath(zkNode + "/" + childNode, strParams.getBytes());
                log.info("发送zk消息成功: node: {}, strParams: {}", zkNode + "/" + childNode, strParams);
            } else {
                throw new Exception("~~~zookeeper创建子节点失败,请重试~~~");
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("发送zk消息失败: {}", e.getMessage());
        }
    }
}
