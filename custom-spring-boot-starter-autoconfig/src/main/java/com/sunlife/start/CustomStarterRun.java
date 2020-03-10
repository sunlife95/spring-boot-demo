package com.sunlife.start;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sunlife
 * @date 2020/2/25 16:20
 */

@Configuration
@ConditionalOnClass(SunlifeTemplate.class)
@EnableConfigurationProperties(RedisConfig.class)
public class CustomStarterRun {
    @Autowired
    private RedisConfig redisConfig;

    @Bean
    public SunlifeTemplate sunlifeTemplate() {
        SunlifeTemplate sunlifeTemplate = new SunlifeTemplate(redisConfig);
        return sunlifeTemplate;
    }
}
