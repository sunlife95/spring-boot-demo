package com.sunlife.start;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author sunlife
 * @date 2020/2/25 16:15
 */
@Data
@ConfigurationProperties(prefix = "sunlife.redis")
public class RedisConfig {
    private String host;

    private Integer port;
}
