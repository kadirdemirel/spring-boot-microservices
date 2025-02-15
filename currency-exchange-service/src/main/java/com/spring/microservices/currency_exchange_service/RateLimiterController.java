package com.spring.microservices.currency_exchange_service;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rate-limiter")
public class RateLimiterController {
    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample-api")
    @RateLimiter(name = "sample-api",fallbackMethod = "hardcodedResponse")
    public String sampleApi() {
        logger.info("Sample api call received");
        return "sample-api";
    }
    public String hardcodedResponse(Exception ex) {
        return "RateLimiter 'sample-api' does not permit further calls.Please try again later.";
    }
}
