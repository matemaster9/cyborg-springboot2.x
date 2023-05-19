package org.mastercs.cyborg.cron_job;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Component
@Slf4j
@RequiredArgsConstructor
public class PeriodicTimeLogger {

    private final TaskScheduler currentScheduler;

    @Scheduled(cron = "0 * * * * ?")
    public void print() {
        // scheduled task ......
        log.info("正在执行定义任务：打印当前系统日期时间 {}", LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
    }

    @PostConstruct
    public void exec() {
        Runnable printSystemTimeTask = () -> {
            log.info("正在执行定义任务：打印当前系统日期时间 {}", LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        };
        Date start = new Date(System.currentTimeMillis() + 5000);
        currentScheduler.scheduleAtFixedRate(printSystemTimeTask, start, 5000);
    }
}
