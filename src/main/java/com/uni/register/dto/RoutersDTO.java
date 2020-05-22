package com.uni.register.dto;

import lombok.Data;

/**
 * @author songning
 * @date 2020/4/27
 * description
 */
@Data
public class RoutersDTO {

    private String ipPort;

    private String url;

    private Integer weight;

    private String roles;
}
