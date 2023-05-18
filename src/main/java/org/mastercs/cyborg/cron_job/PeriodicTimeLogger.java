package org.mastercs.cyborg.cron_job;


import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@Slf4j
public class PeriodicTimeLogger {


    @Scheduled(cron = "0 * * * * ?")
    public void print() {
        // scheduled task ......
        log.info("正在执行定义任务：打印当前系统日期时间 {}", LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
    }
}
