package com.uni.register.service.impl;

import com.uni.register.dto.CommonDTO;
import com.uni.register.dto.RoutersDTO;
import com.uni.register.entity.RoutersEntity;
import com.uni.register.repository.RoutersRepository;
import com.uni.register.service.RoutersService;
import com.uni.register.util.ClassConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author songning
 * @date 2020/4/27
 * description
 */
@Service
public class RoutersServiceImpl implements RoutersService {

    @Autowired
    private RoutersRepository routersRepository;

    @Override
    public CommonDTO<RoutersDTO> findRouterByUrl(String url) {
        CommonDTO<RoutersDTO> commonDTO = new CommonDTO<>();
        if (StringUtils.isEmpty(url)) {
            commonDTO.setStatus(202);
            commonDTO.setMessage("~~~当前url为空~~~");
        } else {
            List<RoutersEntity> src = routersRepository.findAllByUrl(url);
            if (src != null && !src.isEmpty()) {
                List<RoutersDTO> target = new ArrayList<>();
                ClassConvertUtil.populateList(src, target, RoutersDTO.class);
                commonDTO.setDataList(target);
            } else {
                commonDTO.setStatus(202);
                commonDTO.setMessage("~~~统一路由表里不存在此url~~~");
            }
        }
        return commonDTO;
    }
}
