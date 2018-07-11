/*
 * noti_demo
 * com.example.ashwu.notidemo.job
 *
 * Created by Ash Wu on 11/07/18 10:31 AM.
 * Copyright (c) 2018 mega.nz
 */
package com.example.ashwu.notidemo.job;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;

import com.example.ashwu.notidemo.service.KeepAliveJobService;

public final class JobSchedulerManager {
    
    private static final int JOB_ID = 1;
    
    private final static int LOLLIPOP = Build.VERSION_CODES.LOLLIPOP;
    
    private static Context mContext;
    
    private static JobSchedulerManager mJobSchedulerManager;
    
    private JobScheduler mJobScheduler;
    
    @TargetApi(LOLLIPOP)
    private JobSchedulerManager(Context context) {
        mContext = context;
        mJobScheduler = (JobScheduler)context.getSystemService(Context.JOB_SCHEDULER_SERVICE);
    }
    
    public static JobSchedulerManager newInstance(Context context) {
        if (mJobSchedulerManager == null) {
            mJobSchedulerManager = new JobSchedulerManager(context);
        }
        return mJobSchedulerManager;
    }
    
    @TargetApi(LOLLIPOP)
    public void startJobScheduler() {
        if (KeepAliveJobService.isKeepAliveServiceAlive() || isBelowApi21()) {
            return;
        }
        JobInfo info = buildJob();
        mJobScheduler.schedule(info);
    }
    
    @TargetApi(LOLLIPOP)
    private JobInfo buildJob() {
        JobInfo.Builder builder = new JobInfo.Builder(JOB_ID,new ComponentName(mContext,KeepAliveJobService.class));
        // Every 3 seconds to execute the job.
        builder.setPeriodic(1 * 1000);
        // When device restarts, execute the job.
        builder.setPersisted(true);
        // When device is charging, execute the job.
        builder.setRequiresCharging(true);
        return builder.build();
    }
    
    public void stopJobScheduler() {
        if (isBelowApi21()) {
            return;
        }
        mJobScheduler.cancelAll();
    }
    
    
    private boolean isBelowApi21() {
        // API< 21
        return Build.VERSION.SDK_INT < LOLLIPOP;
    }
}
