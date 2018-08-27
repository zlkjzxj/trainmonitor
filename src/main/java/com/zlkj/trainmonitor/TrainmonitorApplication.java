package com.zlkj.trainmonitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class TrainmonitorApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(TrainmonitorApplication.class, args);
    }

    @Override
    //为了打包springboot项目
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }
}
