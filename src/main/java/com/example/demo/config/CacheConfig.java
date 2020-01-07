package com.example.demo.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKey;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@EnableCaching
@Configuration(proxyBeanMethods = false)
public class CacheConfig {

    @Bean("generalCacheManager")
    @Primary
    public CacheManager generalCacheManager(){
        CaffeineCacheManager manager = new CaffeineCacheManager();
        Caffeine<Object, Object> caffeine = Caffeine.newBuilder()
                .expireAfterWrite(1, TimeUnit.MINUTES)
                .initialCapacity(100)
                .maximumSize(1000);
        manager.setAllowNullValues(false);
        manager.setCacheNames(Arrays.asList("generalCache"));
        manager.setCaffeine(caffeine);
        return manager;
    }


    @Bean("secondCacheManager")
    public CacheManager secondCacheManager(){
        CaffeineCacheManager manager = new CaffeineCacheManager();
        Caffeine<Object, Object> caffeine = Caffeine.newBuilder()
                .expireAfterWrite(2, TimeUnit.MINUTES)
                .initialCapacity(200)
                .maximumSize(2000);
        manager.setAllowNullValues(false);
        manager.setCacheNames(Arrays.asList("secondCache"));
        manager.setCaffeine(caffeine);
        return manager;
    }

    @Bean
    public KeyGenerator myKeyGenerator(){
        return new MyKey();
    }

    static class MyKey implements KeyGenerator{

        @Override
        public Object generate(Object target, Method method, Object... params) {
            return new SimpleKey(method.getName(), params);
        }
    }
}
