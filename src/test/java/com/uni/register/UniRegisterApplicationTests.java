package com.uni.register;

import com.uni.register.entity.RoutersEntity;
import com.uni.register.repository.RoutersRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UniRegisterApplicationTests {

    @Autowired
    private RoutersRepository routersRepository;

    @Test
    public void contextLoads() {
        RoutersEntity entity = new RoutersEntity();
        entity.setName("测试2");
        entity.setAuthority(false);
        entity.setCreateTime(new Date());
        entity.setDescription("测试路由2");
        entity.setUrl("/uni-register/hello/say");
        entity.setIpPort("127.0.0.2:7082");
        routersRepository.save(entity);
    }
}
