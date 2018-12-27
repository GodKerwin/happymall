package com.xul.happymall.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableRedisHttpSession
@SpringBootApplication
public class HappymallBaseApplication {

    private static final Logger log = LoggerFactory.getLogger(HappymallBaseApplication.class);

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(HappymallBaseApplication.class, args);
        String[] activeProfiles = ctx.getEnvironment().getActiveProfiles();
        for (String profile : activeProfiles) {
            log.info("Spring Boot 使用profile为:{}", profile);
        }
    }
}