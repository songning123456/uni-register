package com.uni.register.dao;

import com.uni.register.common.Constant;
import com.uni.register.entity.RoutersEntity;
import com.uni.register.repository.RoutersRepository;
import com.uni.register.tool.JsonTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author songning
 * @date 2020/4/29
 * description
 */
@Component
public class RoutersDao {

    @Autowired
    private RoutersRepository routersRepository;
    @Autowired
    private RedisDao redisDao;

    public void initRoutersToRedis() {
        List<RoutersEntity> src = routersRepository.findAll();
        Map<String, List<RoutersEntity>> map = new HashMap<>(2);
        for (RoutersEntity item : src) {
            if (map.containsKey(item.getRequestType() + ":" + item.getUrl())) {
                List<RoutersEntity> values = map.get(item.getUrl());
                values.add(item);
                map.put(item.getRequestType() + ":" + item.getUrl(), values);
            } else {
                List<RoutersEntity> values = new ArrayList<>();
                values.add(item);
                map.put(item.getRequestType() + ":" + item.getUrl(), values);
            }
        }
        redisDao.deleteValues(Constant.ROUTERS_CACHE);
        for (Map.Entry<String, List<RoutersEntity>> item : map.entrySet()) {
            redisDao.setValue(Constant.ROUTERS_CACHE + item.getKey(), JsonTools.convertObject2String(item.getValue()));
        }
    }

    public void updateRoutersToRedis(String requestType, String url) {
        List<RoutersEntity> src = routersRepository.findAllByRequestTypeAndUrl(requestType, url);
        redisDao.setValue(Constant.ROUTERS_CACHE + url, JsonTools.convertObject2String(src));
    }
}
