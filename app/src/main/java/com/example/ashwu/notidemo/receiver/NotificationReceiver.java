/*
 * NotiDemo
 * com.example.ashwu.notidemo
 *
 * Created by Ash Wu on 5/07/18 5:32 PM.
 * Copyright (c) 2018 mega.nz
 */
package com.example.ashwu.notidemo.receiver;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.ashwu.notidemo.Const;
import com.example.ashwu.notidemo.util.Logger;
import com.example.ashwu.notidemo.util.NotificationUtil;
import com.example.ashwu.notidemo.util.Utils;

public class NotificationReceiver extends BroadcastReceiver {
    
    @Override
    public void onReceive(Context context,Intent intent) {
        String content = Utils.currTimeString(System.currentTimeMillis());
        NotificationManager manager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        if(manager == null) {
            log("get manager failed");
            return;
        }
        
        String action = intent.getAction();
        Notification notification;
        switch (action) {
            case Const.ACTION:
                log("receive notification.");
                notification = NotificationUtil.getNotification(context,content);
                break;
            case Const.ACTION_V4:
                log("receive v4 notification.");
                notification = NotificationUtil.getV4Notification(context,content);
                break;
            default:
                notification = NotificationUtil.getNotification(context,content);
        }
//        manager.notify(NotificationUtil.noti_id_dynamic,notification);
    }
    
    private void log(Object any) {
        Logger.log(getClass().getSimpleName(),any,Logger.ERROR);
    }
}
