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
    /**
     * 额外数据集
     */
    private Map<String, Object> dataMap;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 数据集
     */
    private List<T> dataList;

    /**
     * 结果
     */
    private T data;
    /**
     * 错误码
     */
    private Integer errCode;
    /**
     * 错误信息
     */
    private String message;
    /**
     * timeout
     */
    private String timeout;
    /**
     * (分页)总数
     */
    private Long total;
}
