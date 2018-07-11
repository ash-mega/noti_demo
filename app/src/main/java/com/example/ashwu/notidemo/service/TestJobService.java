/*
 * noti_demo
 * com.example.ashwu.notidemo.service
 *
 * Created by Ash Wu on 11/07/18 2:33 PM.
 * Copyright (c) 2018 mega.nz
 */
package com.example.ashwu.notidemo.service;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;

import com.example.ashwu.notidemo.util.Logger;

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class TestJobService extends JobService {
    
    @Override
    public void onCreate() {
        super.onCreate();
        startJobSheduler();
    }
    
    public void startJobSheduler() {
        log("startJobSheduler");
        JobInfo.Builder builder = new JobInfo.Builder(1,new ComponentName(getApplicationContext(),TestJobService.class));
        builder.setPeriodic(5);
        builder.setPersisted(true);
        JobScheduler jobScheduler = (JobScheduler)getSystemService(Context.JOB_SCHEDULER_SERVICE);
        if (jobScheduler != null) {
            jobScheduler.schedule(builder.build());
        }
    }
    
    @Override
    public boolean onStartJob(JobParameters params) {
        log("test onStartJob");
        return false;
    }
    
    @Override
    public boolean onStopJob(JobParameters params) {
        log("test onStopJob");
        return false;
    }
    
    private void log(Object any) {
        Logger.log(getClass().getSimpleName(),any,Logger.ERROR);
    }
}
