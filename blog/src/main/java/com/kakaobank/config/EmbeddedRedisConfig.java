package com.kakaobank.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import redis.embedded.RedisServer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Configuration
@Slf4j
public class EmbeddedRedisConfig {
    private RedisServer redisServer;

    public EmbeddedRedisConfig(@Value("${spring.redis.port}") int port) {
        this.redisServer = RedisServer.builder()
                .port(port)
                .setting("maxmemory 128M")
                .build();
    }

    @PostConstruct
    public void startRedis() {
        try {
            this.redisServer.start();
        } catch (Exception e) {
            log.error("startRedis Error", e);
        }
    }

    @PreDestroy
    public void stopRedis() {
        this.redisServer.stop();
    }
}
