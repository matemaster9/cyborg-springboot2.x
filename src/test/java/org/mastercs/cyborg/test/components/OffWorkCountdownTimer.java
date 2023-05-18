package org.mastercs.cyborg.test.components;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * Author: cyborg
 * Create: 2023/5/18 18:22
 */
@Slf4j
public class OffWorkCountdownTimer {

    private static final ScheduledExecutorService SCHEDULED_EXECUTOR_SERVICE;

    public static void main(String[] args) {
        remindOffWork();
    }

    public static void remindOffWork() {
        LocalTime offWorkTime = LocalTime.of(19, 30);
        Runnable remindTask = () -> {
            LocalTime now = LocalTime.now();
            if (now.isBefore(offWorkTime)) {
                Duration duration = Duration.between(now, offWorkTime);
                log.info("还有{}秒就可以下班啦", duration.toMillis() / 1000);
            } else {
                Duration duration = Duration.between(offWorkTime, now);
                log.info("已经下班{}秒", duration.toMillis() / 1000);
            }

        };
        SCHEDULED_EXECUTOR_SERVICE.scheduleAtFixedRate(remindTask, 1, 3, TimeUnit.SECONDS);
    }

    static {
        ThreadFactory factory = new ThreadFactoryBuilder()
                .setNameFormat("scheduledService-%s")
                .build();
        int core = 10;
        SCHEDULED_EXECUTOR_SERVICE = new ScheduledThreadPoolExecutor(core, factory);
    }
}
