package com.example.demo.config;

import org.springframework.cache.annotation.Cacheable;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Cacheable(
        cacheManager = "secondCacheManager",
        cacheNames = {"secondCache"},
        keyGenerator = "myKeyGenerator"
)
public @interface SencondCache {
}
