package com.learning.stall.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class StallCleanUp {

    private static Logger logger = LoggerFactory.getLogger(StallCleanUp.class);

    @Scheduled(fixedRate = 5000)
    public void invokeCleanupProc(){
        logger.info("Cleanup of old stalls at {}", new Date());
    }
}
