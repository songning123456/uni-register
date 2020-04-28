package com.uni.register.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @author songning
 * @date 2020/4/27
 * description
 */
@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    @GetMapping("/say")
    public String sayHello(@RequestParam(value = "params") String params) {
        return "say: " + params;
    }

    @PostMapping("/say")
    public Map<String, Object> sayHello(@RequestBody Map<String, Object> params) {
        params.put("ok", 1213);
        return params;
    }

//    @PostMapping("/say")
//    public Map<String, Object> sayHello(@RequestParam MultipartFile[] file,@RequestParam MultipartFile[] file2, String text) {
//        Map<String, Object> map = new HashMap<>(2);
//        map.put("text", text);
//        return map;
//    }
}
