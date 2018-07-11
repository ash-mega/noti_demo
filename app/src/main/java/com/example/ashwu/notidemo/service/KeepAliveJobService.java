/*
 * noti_demo
 * com.example.ashwu.notidemo.service
 *
 * Created by Ash Wu on 11/07/18 9:58 AM.
 * Copyright (c) 2018 mega.nz
 */
package com.example.ashwu.notidemo.service;

import android.annotation.TargetApi;
import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;

import com.example.ashwu.notidemo.MainActivity;
import com.example.ashwu.notidemo.util.Logger;
import com.example.ashwu.notidemo.util.Utils;

/**
 * @author Ash Wu
 * @version 1.0
 */
@TargetApi(21)
public class KeepAliveJobService extends JobService {
    
    private static final int MESSAGE_ID_TASK = 1;
    
    private static Service mKeepAliveJobService;
    
    private Handler mHandler = new Handler(new Handler.Callback() {
        
        @Override
        public boolean handleMessage(Message msg) {
            Context context = getApplicationContext();
            if (Utils.isAppAlive(context,context.getPackageName())) {
                Utils.toast(context,"App is alive!");
            } else {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                Utils.toast(context,"App is killed, restart!");
            }
            //Notify the task is over.
            jobFinished((JobParameters)msg.obj,false);
            return true;
        }
    });
    
    public static boolean isKeepAliveServiceAlive() {
        return mKeepAliveJobService != null;
    }
    
    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        log("KeepAliveJobService is starting!");
        mKeepAliveJobService = this;
        Message msg = Message.obtain(mHandler,MESSAGE_ID_TASK,jobParameters);
        mHandler.sendMessage(msg);
        return true;
    }
    
    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        log("KeepAliveJobService is stopping!");
        mHandler.removeMessages(MESSAGE_ID_TASK);
        return false;
    }
    
    private void log(Object any) {
        Logger.log(KeepAliveJobService.class.getSimpleName(),any,Logger.ERROR);
    }
}
