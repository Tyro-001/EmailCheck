package com.Jin;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
public class EmailCheckApplication  {
//      extends SpringBootServletInitializer
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(EmailCheckApplication.class);
//    }

    public static void main(String[] args) {
        SpringApplication.run(EmailCheckApplication.class, args);
    }


}
