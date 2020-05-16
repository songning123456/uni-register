package com.uni.register.provider;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.uni.dubbo.service.RouterService;
import com.uni.register.common.Constant;
import com.uni.register.dao.RedisDao;
import com.uni.register.entity.RoutersEntity;
import com.uni.register.repository.RoutersRepository;
import com.uni.register.tool.JsonTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author sonin
 */
@Service
@Component
public class RouterProviderImpl implements RouterService {

    @Autowired
    private RedisDao redisDao;
    @Autowired
    private RoutersRepository routersRepository;

    @Override
    public String getRoutersByUrl(String url) {
        List<RoutersEntity> src = routersRepository.findAllByUrl(url);
        return JSON.toJSONString(src);
    }

    @Override
    public String getRoutersByTypeAndUrl(String requestType, String url) {
        String str = redisDao.getValue(Constant.ROUTERS_CACHE + requestType + Constant.COLON + url);
        if (StringUtils.isEmpty(str)) {
            List<RoutersEntity> src = routersRepository.findAllByRequestTypeAndUrl(requestType, url);
            redisDao.setValue(Constant.ROUTERS_CACHE + requestType + ":" + url, JsonTools.convertObject2String(src));
            return JSON.toJSONString(src);
        } else {
            return str;
        }
    }
}
