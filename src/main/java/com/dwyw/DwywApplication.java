package com.dwyw;

import com.dwyw.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(AppConfig.class)
@SpringBootApplication
public class DwywApplication {

    public static void main(String[] args) {
        SpringApplication.run(DwywApplication.class, args);
    }

}
