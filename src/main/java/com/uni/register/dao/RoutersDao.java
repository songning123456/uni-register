package com.uni.register.dao;

import com.alibaba.fastjson.JSON;
import com.uni.register.dto.RoutersDTO;
import com.uni.register.entity.RoutersEntity;
import com.uni.register.repository.RoutersRepository;
import com.uni.register.util.ClassConvertUtil;
import com.uni.register.zookeeper.ZKCuratorClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: songning
 * @date: 2020/4/28 22:52
 */
@Component
public class RoutersDao {

    @Autowired
    private RoutersRepository routersRepository;
    @Autowired
    private ZKCuratorClient zkCuratorClient;

    public void sendZkRouters() {
        List<RoutersEntity> src = routersRepository.findAll();
        List<RoutersDTO> target = new ArrayList<>();
        ClassConvertUtil.populateList(src, target, RoutersDTO.class);
        zkCuratorClient.sendOperator("routers", JSON.toJSONString(target));
    }
}
