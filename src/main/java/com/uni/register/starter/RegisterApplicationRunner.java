package com.uni.register.starter;

import com.uni.register.dao.RoutersDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

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
            routersDao.initRoutersToRedis();
        } catch (Exception e) {
            e.printStackTrace();
            log.info("发送Zookeeper Routers fail: {}", e.getMessage());
        }
    }
}
