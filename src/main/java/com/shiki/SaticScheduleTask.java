package com.shiki;

import com.shiki.domain.dto.SText;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentSkipListSet;

public class SaticScheduleTask {

    public static final ConcurrentSkipListSet<SText> CONCURRENT_SKIP_LIST_SET = new ConcurrentSkipListSet();
    //3.添加定时任务
    @Scheduled(cron = "0 5 * * * ?")
    //或直接指定时间间隔，例如：5秒
    //@Scheduled(fixedRate=5000)
    private void configureTasks() {
        System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
    }

}