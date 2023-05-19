package org.mastercs.cyborg.test;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

@Slf4j
public class PeriodicTimeLoggerTests {

    public static void main(String[] args) {
        int core = 10;
        ThreadFactory factory = new ThreadFactoryBuilder().setNameFormat("Scheduler-%s").build();
        ScheduledExecutorService scheduler = new ScheduledThreadPoolExecutor(core, factory);
        scheduler.scheduleAtFixedRate(() -> {
            log.info("当前系统时间为：{}", LocalDateTime.now());
        }, 0L, 3, TimeUnit.SECONDS);
    }
}
