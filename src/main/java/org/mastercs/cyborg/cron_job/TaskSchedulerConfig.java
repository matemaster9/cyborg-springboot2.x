package org.mastercs.cyborg.cron_job;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

@Configuration
public class TaskSchedulerConfig {

    @Bean
    public TaskScheduler currentScheduler() {
        int core = 10;
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("ConcurrentTaskScheduler-%s").build();
        ScheduledExecutorService ses = new ScheduledThreadPoolExecutor(core, threadFactory);
        return new ConcurrentTaskScheduler(ses);
    }
}
