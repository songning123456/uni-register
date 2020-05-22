package com.uni.register.service;

import com.uni.register.dto.CommonDTO;
import com.uni.register.dto.RoutersDTO;
import com.uni.register.vo.RoutersVO;

import java.util.List;

/**
 * @author: songning
 * @date: 2020/4/29 21:57
 */
public interface RoutersService {

    CommonDTO<RoutersDTO> saveRoutersList(List<RoutersVO> voList);
}
