package com.tss.security_demo.security;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class RateLimitService {


    private final StringRedisTemplate redisTemplate;

    public boolean isAllowed(String key, int maxRequests, Duration window)
    {
        Long count = redisTemplate
                .opsForValue()
                .increment(key);

        if(count == null) return false;

        if(count == 1) {
            redisTemplate.expire(key, window);
        }

        return count <= maxRequests;
    }

}
