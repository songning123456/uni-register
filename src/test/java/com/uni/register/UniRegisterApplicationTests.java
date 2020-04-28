package com.uni.register;

import com.alibaba.fastjson.JSON;
import com.uni.register.dao.RoutersDao;
import com.uni.register.dto.RoutersDTO;
import com.uni.register.entity.RoutersEntity;
import com.uni.register.repository.RoutersRepository;
import com.uni.register.util.ClassConvertUtil;
import com.uni.register.zookeeper.ZKCuratorClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UniRegisterApplicationTests {

    @Autowired
    private RoutersRepository routersRepository;
    @Autowired
    private RoutersDao routersDao;

    @Test
    public void contextLoads() {
        RoutersEntity entity = new RoutersEntity();
        entity.setName("测试");
        entity.setAuthority(false);
        entity.setCreateTime(new Date());
        entity.setDescription("测试路由");
        entity.setUrl("/uni-register/hello/say");
        entity.setIpPort("127.0.0.1:7082");
        routersRepository.save(entity);
        routersDao.sendZkRouters();
    }
}
