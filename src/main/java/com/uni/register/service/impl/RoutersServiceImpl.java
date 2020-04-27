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
            RoutersEntity routersEntity = routersRepository.findRoutersEntityByUrl(url);
            if (routersEntity != null) {
                RoutersDTO dto = new RoutersDTO();
                ClassConvertUtil.populate(routersEntity, dto);
                commonDTO.setData(dto);
            } else {
                commonDTO.setStatus(202);
                commonDTO.setMessage("~~~统一路由表里不存在此url~~~");
            }
        }
        return commonDTO;
    }
}
