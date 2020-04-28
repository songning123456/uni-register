package com.uni.register.starter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.uni.register.dao.RoutersDao;
import com.uni.register.dto.RoutersDTO;
import com.uni.register.entity.RoutersEntity;
import com.uni.register.repository.RoutersRepository;
import com.uni.register.util.ClassConvertUtil;
import com.uni.register.zookeeper.ZKCuratorClient;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class RegisterApplicationRunner implements ApplicationRunner {

    @Autowired
    private RoutersDao routersDao;

    @Override
    public void run(ApplicationArguments args) {
        try {
            routersDao.sendZkRouters();
        } catch (Exception e) {
            e.printStackTrace();
            log.info("发送Zookeeper Routers fail: {}", e.getMessage());
        }
    }
}
