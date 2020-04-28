package com.uni.register.starter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.uni.register.dto.RoutersDTO;
import com.uni.register.entity.RoutersEntity;
import com.uni.register.repository.RoutersRepository;
import com.uni.register.util.ClassConvertUtil;
import com.uni.register.zookeeper.ZKCuratorClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author songning
 * @date 2020/4/24
 * description
 */
@Component
public class RegisterApplicationRunner implements ApplicationRunner {

    @Autowired
    private RoutersRepository routersRepository;
    @Autowired
    private ZKCuratorClient zkCuratorClient;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        this.sendZkRouters();
    }

    private void sendZkRouters() {
        List<RoutersEntity> src = routersRepository.findAll();
        List<RoutersDTO> target = new ArrayList<>();
        ClassConvertUtil.populateList(src, target, RoutersDTO.class);
        zkCuratorClient.sendOperator("uni-register", JSON.toJSONString(target));
    }
}
