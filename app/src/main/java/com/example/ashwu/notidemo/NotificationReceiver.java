/*
 * NotiDemo
 * com.example.ashwu.notidemo
 *
 * Created by Ash Wu on 5/07/18 5:32 PM.
 * Copyright (c) 2018 mega.nz
 */
package com.example.ashwu.notidemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v4.app.NotificationCompat;

public class NotificationReceiver extends BroadcastReceiver {
    
    static int i;

//    static final int NOTIFICATION_ID = 0;
    
    @Override
    public void onReceive(Context context,Intent intent) {
        //Count
        i++;
        String content = Utils.currTimeString(System.currentTimeMillis());
        NotificationManager manager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        
        String action = intent.getAction();
        Notification notification;
        switch (action) {
            case Const.ACTION:
                notification = getNotification(context,content);
                break;
            case Const.ACTION_V4:
                Utils.log("receive v4");
                notification = getV4Notification(context,content);
                break;
            default:
                notification = getNotification(context,content);
        }
        if (manager != null) {
            manager.notify(i,notification);
        } else {
            Utils.log("get manager failed");
        }
    }
    
    private Notification getV4Notification(Context context,String content) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        builder.setContentTitle("This is notification " + i + "!");
        builder.setContentText(content);
        
        builder.setDefaults(Notification.DEFAULT_SOUND);
        builder.setSound(Uri.withAppendedPath(MediaStore.Audio.Media.INTERNAL_CONTENT_URI,"2"));
        
        builder.setVibrate(new long[] {0,500});
        builder.setPriority(Notification.PRIORITY_MAX);
        builder.setAutoCancel(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            builder.setShowWhen(true);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder.setColor(Color.BLUE);
        }
        builder.setContentIntent(getIntent(context,content,i));
        return builder.build();
    }
    
    private Notification getNotification(Context context,String content) {
        Notification.Builder builder = new Notification.Builder(context);
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        builder.setContentTitle("This is notification " + i + "!");
        builder.setContentText(content);
        
        builder.setVibrate(new long[] {0,500});
        builder.setPriority(Notification.PRIORITY_MAX);
        builder.setAutoCancel(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            builder.setShowWhen(true);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder.setColor(Color.BLUE);
        }
        builder.setContentIntent(getIntent(context,content,i));
        return builder.build();
    }
    
    private PendingIntent getIntent(Context context,String content,int count) {
        Intent intent = new Intent(context,ChatActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra(Const.CONTENT,content);
        intent.putExtra(Const.COUNT,count);
        
        return PendingIntent.getActivity(context,i,intent,PendingIntent.FLAG_ONE_SHOT);
    }
}
