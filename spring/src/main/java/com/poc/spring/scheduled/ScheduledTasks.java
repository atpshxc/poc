package com.poc.spring.scheduled;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTasks {
    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 10000)
    public void reportCurrentTime() {
        logger.info(dateFormat.format(new Date()));
    }

    @Scheduled(fixedDelay = 50000)
    public void reportCurrentTime1() {
        logger.info(dateFormat.format(new Date()));
    }

    @Scheduled(cron = "0/2 * * * * ?")
    public void reportCurrentTime2() {
        logger.info(dateFormat.format(new Date()));
    }
}
