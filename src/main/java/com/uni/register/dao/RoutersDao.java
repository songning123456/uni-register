package com.uni.register.dao;

import com.uni.register.common.Constant;
import com.uni.register.dto.RoutersDTO;
import com.uni.register.entity.RoutersEntity;
import com.uni.register.repository.RoutersRepository;
import com.uni.register.util.ClassConvertUtil;
import com.uni.register.util.JsonUtil;
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
            if (map.containsKey(item.getUrl())) {
                List<RoutersEntity> values = map.get(item.getUrl());
                values.add(item);
                map.put(item.getUrl(), values);
            } else {
                List<RoutersEntity> values = new ArrayList<>();
                values.add(item);
                map.put(item.getUrl(), values);
            }
        }
        for (Map.Entry<String, List<RoutersEntity>> item : map.entrySet()) {
            redisDao.setValue(Constant.ROUTERS_CACHE + item.getKey(), JsonUtil.convertObject2String(item.getValue()));
        }
    }
}
