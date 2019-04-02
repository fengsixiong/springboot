package com.springboot.jap_demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executors;

@Configuration
public class ScheduleConfig implements SchedulingConfigurer {

    @Value("${schedule.threadPoolSize}")
    private int threadPoolSize;

    @Value("${schedule.jobs.testSchedule.data-size}")
    private int testScheduleDataSize;

    @Value("${schedule.jobs.testSchedule.enable}")
    private boolean testScheduleEnable;

    public int getThreadPoolSize() {
        return threadPoolSize;
    }

    public void setThreadPoolSize(int threadPoolSize) {
        this.threadPoolSize = threadPoolSize;
    }

    public int getTestScheduleDataSize() {
        return testScheduleDataSize;
    }

    public void setTestScheduleDataSize(int testScheduleDataSize) {
        this.testScheduleDataSize = testScheduleDataSize;
    }

    public boolean isTestScheduleEnable() {
        return testScheduleEnable;
    }

    public void setTestScheduleEnable(boolean testScheduleEnable) {
        this.testScheduleEnable = testScheduleEnable;
    }

    //设置定时任务线程池大小
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.setScheduler(Executors.newScheduledThreadPool(10));
    }
}
