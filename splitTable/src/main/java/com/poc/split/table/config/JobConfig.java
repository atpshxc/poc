package com.poc.split.table.config;

import com.poc.split.table.job.CustomerJob;
import com.poc.split.table.job.OrderJob;
import com.poc.split.table.job.PaymentJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
@EnableAsync
public class JobConfig {
    @Autowired
    private CustomerJob customerJob;
    @Autowired
    private OrderJob orderJob;
    @Autowired
    private PaymentJob paymentJob;

    @Scheduled(fixedDelay = 100L, initialDelay = 100)
//    @Async
    public void createCustomer() {
        customerJob.run();
    }

    @Scheduled(fixedDelay = 10L)
//    @Async
    public void createOrder() {
        orderJob.run();
    }

    @Scheduled(fixedDelay = 10L)
//    @Async
    public void createPayment() {
        paymentJob.run();
    }
}
