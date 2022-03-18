package com.xyz.ecomm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(basePackages = { "com.xyz.ecomm.*" })
@PropertySource(value = { "classpath:application.properties" })
@EnableScheduling
@EnableCaching
@EnableJpaRepositories("com.xyz.ecomm.*")
@EntityScan("com.xyz.ecomm.*")
@EnableTransactionManagement
public class EcommApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommApplication.class, args);
	}
	
	@Bean
	LettuceConnectionFactory lettuceConnectionFactory() {
		LettuceConnectionFactory factory = new LettuceConnectionFactory();
		return factory;
	}

	@Bean
	public CacheManager cacheManager() {
		RedisCacheManager cacheManager = new RedisCacheManager(
				RedisCacheWriter.lockingRedisCacheWriter(lettuceConnectionFactory()),
				RedisCacheConfiguration.defaultCacheConfig());
		return cacheManager;
	}

}
