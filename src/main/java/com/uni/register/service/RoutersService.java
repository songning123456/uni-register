package com.uni.register.service;

import com.uni.register.dto.CommonDTO;
import com.uni.register.dto.RoutersDTO;

/**
 * @author songning
 * @date 2020/4/27
 * description
 */
public interface RoutersService {

    CommonDTO<RoutersDTO> findRouterByUrl(String url);
}
