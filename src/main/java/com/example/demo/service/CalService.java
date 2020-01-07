package com.example.demo.service;

import com.example.demo.config.GeneralCache;
import com.example.demo.config.SencondCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CalService {

    @GeneralCache
    public Integer add(int a1, int a2){
        log.info("start cal {} + {}", a1, a2);
        return a1 + a2;
    }

    @SencondCache
    public Integer add2(int a1, int a2){
        log.info("start cal {} + {}", a1, a2);
        return a1 + a2;
    }

    @GeneralCache
    public Integer add3(int a1, int a2){
        log.info("start cal {} + {}", a1, a2);
        return a1 + a2;
    }

    /**
     * 固定key测试
     * @param a1
     * @param a2
     * @return
     */
    @GeneralCache(key = "111", keyGenerator = "")
    public Integer add4(int a1, int a2){
        log.info("start cal {} + {}", a1, a2);
        return a1 + a2;
    }

}
