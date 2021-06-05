package com.study.cache.config;

import com.study.cache.pojo.UserEntity;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.time.Duration;

/**
 * @author zbsilent
 * @date 2021年06月05日 11:04 上午
 */
@Configuration
public class MyRedisConfig {

//    @Bean
//    public RedisTemplate<Object, UserEntity> userRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
//        RedisTemplate<Object, UserEntity> template = new RedisTemplate<Object, UserEntity>();
//        template.setDefaultSerializer(new Jackson2JsonRedisSerializer<UserEntity>(UserEntity.class));
//        template.setConnectionFactory(redisConnectionFactory);
//        return template;
//    }

    @Bean
    public RedisCacheManager userCacheManager(RedisConnectionFactory connectionFactory) {
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig().
                entryTtl(Duration.ofDays(1)).disableCachingNullValues().serializeValuesWith(RedisSerializationContext
                        .SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
        return RedisCacheManager.builder(connectionFactory).cacheDefaults(redisCacheConfiguration).build();
    }
}
