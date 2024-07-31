package com.example.transport.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "transport.jwt")
@Data
public class JwtProperties {

    /**
     * 货主端
     * jwt令牌相关配置
     */
    private String ownerSecretKey;
    private long ownerTtl;
    private String ownerTokenName;

    /**
     * 司机端
     * jwt令牌相关配置
     */
    private String driverSecretKey;
    private long driverTtl;
    private String driverTokenName;


    /**
     * 管理端
     * jwt令牌相关配置
     */
    private String adminSecretKey;
    private long adminTtl;
    private String adminTokenName;
}
