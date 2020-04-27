package com.uni.register.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * @author songning
 * @date 2020/4/27
 * description
 */
@Data
@Entity
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@Table(name = "Routers", uniqueConstraints = {@UniqueConstraint(columnNames = {"ipPort", "url"})})
public class RoutersEntity {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 64)
    private String id;

    @Column(name = "name", columnDefinition = "VARCHAR(128) NOT NULL COMMENT '项目名称'")
    private String name;

    @Column(name = "description", columnDefinition = "VARCHAR(128) COMMENT '路由简介'")
    private String description;

    @Column(name = "ipPort", columnDefinition = "VARCHAR(128) NOT NULL COMMENT 'ip+port地址'")
    private String ipPort;

    @Column(name = "weight", columnDefinition = "INT(10) NOT NULL DEFAULT 1 COMMENT '权重'")
    private Integer weight = 1;

    @Column(name = "url", columnDefinition = "VARCHAR(128) NOT NULL COMMENT 'url'")
    private String url;

    @Column(name = "createTime", columnDefinition = "DATETIME NOT NULL COMMENT '创建时间'")
    private Date createTime;

    @Column(name = "authority", columnDefinition = "tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否需要权限'")
    private Boolean authority;
}
