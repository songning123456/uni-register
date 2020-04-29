package com.uni.register.service.impl;

import com.uni.register.dto.CommonDTO;
import com.uni.register.dto.RoutersDTO;
import com.uni.register.entity.RoutersEntity;
import com.uni.register.repository.RoutersRepository;
import com.uni.register.service.RoutersService;
import com.uni.register.vo.RoutersVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author: songning
 * @date: 2020/4/29 21:57
 */
@Service
public class RoutersServiceImpl implements RoutersService {

    @Autowired
    private RoutersRepository routersRepository;

    @Override
    public CommonDTO<RoutersDTO> saveRoutersList(List<RoutersVO> voList) {
        for (RoutersVO item : voList) {
            RoutersEntity routersEntity = new RoutersEntity();
            routersEntity.setIpPort(item.getIpPort());
            routersEntity.setCreateTime(new Date());
            routersEntity.setUrl(item.getUrl());
            routersEntity.setRequestType(item.getRequestType());
            routersEntity.setWeight(1);
            routersEntity.setName(item.getName());
            routersRepository.save(routersEntity);
        }
        return new CommonDTO<>();
    }
}
