package com.uni.register.controller;

import com.uni.register.annotation.AControllerAspect;
import com.uni.register.dto.CommonDTO;
import com.uni.register.dto.RoutersDTO;
import com.uni.register.service.RoutersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author songning
 * @date 2020/4/27
 * description
 */
@RestController
@RequestMapping(value = "/routers")
public class RoutersController {

    @Autowired
    private RoutersService routersService;

    @GetMapping("/findRouter")
    @AControllerAspect(description = "判断路由是否存在")
    public CommonDTO<RoutersDTO> findRouters(@RequestParam(value = "url") String url) {
        CommonDTO<RoutersDTO> commonDTO = routersService.findRouterByUrl(url);
        return commonDTO;
    }
}
