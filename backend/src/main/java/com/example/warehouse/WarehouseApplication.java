package com.example.warehouse;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 入口类：启动 Spring Boot 应用并扫描 MyBatis Mapper 接口
 */
@SpringBootApplication(excludeName = {
        "org.springframework.boot.autoconfigure.sql.init.SqlInitializationAutoConfiguration"
})
@MapperScan("com.example.warehouse.mapper")
public class WarehouseApplication {
    public static void main(String[] args) {
        SpringApplication.run(WarehouseApplication.class, args);
    }
}
