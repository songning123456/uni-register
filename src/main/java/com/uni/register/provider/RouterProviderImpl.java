package com.uni.register.provider;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.uni.dubbo.service.RouterService;
import com.uni.register.entity.RoutersEntity;
import com.uni.register.repository.RoutersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author sonin
 */
@Service
@Component
public class RouterProviderImpl implements RouterService {

    @Autowired
    private RoutersRepository routersRepository;

    @Override
    public String getRoutersByUrl(String url) {
        List<RoutersEntity> src = routersRepository.findAllByUrl(url);
        return JSON.toJSONString(src);
    }
}
