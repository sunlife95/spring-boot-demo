package com.sunlife.springbootdemo;

import com.sunlife.springbootdemo.druid.DruidConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = "com.sunlife")
/*
扫描@WebFilter ， @WebListener，@WebServlet
 */
@ServletComponentScan(basePackages = "com.sulife")
@MapperScan(basePackages = "com.sunlife.springbootdemo.dao")
@RestController
@EnableConfigurationProperties(DruidConfig.class)
public class SpringBootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }
}
