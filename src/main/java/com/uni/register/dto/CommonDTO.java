package com.uni.register.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @param <T>
 * @author sn
 */
@Data
public class CommonDTO<T> {

    private Map<String, Object> dataExt;

    private Integer status;

    private List<T> data;

    private String message;

    private String timeout;

    private Long total;
}
