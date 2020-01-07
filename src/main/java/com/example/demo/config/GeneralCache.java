package com.example.demo.config;

import org.springframework.cache.annotation.Cacheable;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Cacheable
public @interface GeneralCache {

    String[] cacheNames() default {"generalCache"};

    String key() default "";

    String keyGenerator() default "myKeyGenerator";

    String cacheManager() default "generalCacheManager";

    String cacheResolver() default "";

    String condition() default "";

    String unless() default "";

    boolean sync() default false;
}
