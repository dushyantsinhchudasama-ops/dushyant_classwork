package com.tss.security_demo.security;

import com.tss.security_demo.exception.RateLimitException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;
import java.time.Duration;

@Component
public class RateLimitFilter extends OncePerRequestFilter {

    private static final String LOGIN_ENDPOINT = "/auth/login";

    private static final int MAX_LOGIN_REQUESTS = 2;

    private static final Duration LOGIN_WINDOW =
            Duration.ofMinutes(1);

    private final RateLimitService rateLimitService;
    private final HandlerExceptionResolver handlerExceptionResolver;

    public RateLimitFilter(
            RateLimitService rateLimitService,
            @Qualifier("handlerExceptionResolver")
            HandlerExceptionResolver handlerExceptionResolver
    ) {
        this.rateLimitService = rateLimitService;
        this.handlerExceptionResolver = handlerExceptionResolver;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        if (!LOGIN_ENDPOINT.equals(request.getRequestURI())
                || !"POST".equalsIgnoreCase(request.getMethod())) {

            filterChain.doFilter(request, response);
            return;
        }

        String clientIp = request.getRemoteAddr();

        String redisKey =
                "rate_limit:login:ip:" + clientIp;

        boolean allowed = rateLimitService.isAllowed(
                redisKey,
                MAX_LOGIN_REQUESTS,
                LOGIN_WINDOW
        );

        if (!allowed) {

            handlerExceptionResolver.resolveException(
                    request,
                    response,
                    null,
                    new RateLimitException(
                            "Too many login requests. Please try again later."
                    )
            );

            return;
        }

        filterChain.doFilter(request, response);
    }
}
