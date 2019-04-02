package com.springboot.jap_demo.config;

import com.springboot.jap_demo.service.SchedulingTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleService {

    @Autowired
    private ScheduleConfig scheduleConfig;

    @Autowired
    private SchedulingTestService schedulingService;

    @Scheduled(cron = "${schedule.jobs.testSchedule.cron}")
    public void testPrint() {

        if (!scheduleConfig.isTestScheduleEnable()) {
            return;
        } else {
            schedulingService.TestPrint();
        }
    }
}
