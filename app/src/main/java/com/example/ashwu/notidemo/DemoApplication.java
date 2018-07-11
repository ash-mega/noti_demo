/*
 * noti_demo
 * com.example.ashwu.notidemo
 *
 * Created by Ash Wu on 12/07/18 9:12 AM.
 * Copyright (c) 2018 mega.nz
 */
package com.example.ashwu.notidemo;

import android.app.Application;
import android.os.Handler;

import com.example.ashwu.notidemo.util.Logger;
import com.example.ashwu.notidemo.util.Utils;

import java.util.Date;


public class DemoApplication extends Application {
    
    public static boolean activityVisible;
    
    private final static int INTERVAL = 2000;
    
//    private int backgroundStatus = -1;
    
    private Handler keepAliveHandler = new Handler();
    
    private Runnable keepAliveRunnable = new Runnable() {
        
        @Override
        public void run() {
            log("keep alive --->" + Utils.toString(new Date()) + " " + activityVisible);
//            keepAliveHandler.postAtTime(keepAliveRunnable,System.currentTimeMillis() + INTERVAL);
            keepAliveHandler.postDelayed(keepAliveRunnable,INTERVAL);
        }
    };
    
    @Override
    public void onCreate() {
        super.onCreate();
//        keepAliveHandler.postAtTime(keepAliveRunnable,System.currentTimeMillis() + INTERVAL);
//        if (Build.BRAND.equalsIgnoreCase("xiaomi")) {
//            Intent intent = new Intent();
//            intent.setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity"));
//            startActivity(intent);
//        }
        keepAliveHandler.postDelayed(keepAliveRunnable,INTERVAL);
    }
    
    private void log(Object any) {
        Logger.log(getClass().getSimpleName(),any,Logger.ERROR);
    }
}
