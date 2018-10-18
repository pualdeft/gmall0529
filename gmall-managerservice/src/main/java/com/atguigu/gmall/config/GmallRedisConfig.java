package com.atguigu.gmall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
@Configuration
public class GmallRedisConfig {

@Bean
   public JedisPool jedisPoolConfig (JedisConnectionFactory factory){
    JedisPoolConfig config =factory.getPoolConfig();
    JedisPool jedisPool=new JedisPool(config,factory.getHostName(),factory.getPort(),factory.getTimeout());
return jedisPool;
}
}
