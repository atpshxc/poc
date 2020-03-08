package com.poc.split.table.util;

import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class SequenceUtil {
    private volatile long mills = 0L;
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public String next(String prefix) {
        long currentTimeMillis = System.currentTimeMillis();
        while (mills == currentTimeMillis && atomicInteger.get() >= 1000) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        mills = currentTimeMillis;
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        sb.append(currentTimeMillis).append(atomicInteger.getAndAdd(1));
        if (atomicInteger.get() >= 1000) {
            atomicInteger.set(0);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Executor executor = Executors.newFixedThreadPool(10);
        int i = Integer.MAX_VALUE;
        SequenceUtil sequenceUtil = new SequenceUtil();

        while (i-- > 0) {
            executor.execute(() -> System.out.println(sequenceUtil.next("CT")));
        }
    }
}
