package com.linjingc.springbootandredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableCaching
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 3600)
public class SpringbootandredisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootandredisApplication.class, args);
	}
}
