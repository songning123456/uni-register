package com.uni.register.controller;

import com.uni.register.annotation.AControllerAspect;
import com.uni.register.dto.CommonDTO;
import com.uni.register.dto.RoutersDTO;
import com.uni.register.service.RoutersService;
import com.uni.register.vo.RoutersVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: songning
 * @date: 2020/4/29 21:56
 */
@RestController
@RequestMapping(value = "/routers")
public class RoutersController {

    @Autowired
    private RoutersService routersService;

    @PostMapping("/saveRoutersList")
    @AControllerAspect(description = "添加更新某一项目路由列表")
    public CommonDTO<RoutersDTO> saveRoutersLists(@RequestBody List<RoutersVO> voList) {
        CommonDTO<RoutersDTO> commonDTO = routersService.saveRoutersList(voList);
        return commonDTO;
    }
}
