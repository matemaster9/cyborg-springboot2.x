package org.mastercs.cyborg.test;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.time.LocalDateTime;
import java.util.Date;

@Slf4j
public class QuartzSchedulerTests {

    @SneakyThrows
    public static void main(String[] args) {
        // 创建一个JobDetail实例，将该实例与PrintTimeJob类绑定
        JobDetail printPeriodicTimeJob = JobBuilder.newJob(PrintPeriodicTimeJob.class)
                .withIdentity("PrintPeriodicTimeJob")
                .build();

        // 创建一个Trigger实例，定义该Job立即执行，并且每5秒重复执行一次
        Date date = new Date(System.currentTimeMillis() + 3000L);
        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(5)
                .repeatForever();
        Trigger printPeriodicTimeTrigger = TriggerBuilder.newTrigger()
                .withIdentity("PrintPeriodicTimeTrigger")
                .startAt(date)
                .withSchedule(simpleScheduleBuilder)
                .build();
        // 创建Scheduler实例 将JobDetail和Trigger加入到调度器中
        Scheduler defaultScheduler = StdSchedulerFactory.getDefaultScheduler();
        defaultScheduler.start();
        defaultScheduler.scheduleJob(printPeriodicTimeJob, printPeriodicTimeTrigger);
    }

    public static class PrintPeriodicTimeJob implements Job {

        @Override
        public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
            log.info("当前系统时间：{}", LocalDateTime.now());
        }
    }
}
