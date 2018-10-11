package com.atguigu.gmall;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EnableDubbo
@MapperScan("com.atguigu.gmall.mapper")
@SpringBootApplication
public class GmallManagerserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmallManagerserviceApplication.class, args);
    }
}
