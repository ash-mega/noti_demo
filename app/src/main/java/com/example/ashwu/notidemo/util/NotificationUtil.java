/*
 * noti_demo
 * com.example.ashwu.notidemo.util
 *
 * Created by Ash Wu on 11/07/18 9:31 AM.
 * Copyright (c) 2018 mega.nz
 */
package com.example.ashwu.notidemo.util;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v4.app.NotificationCompat;

import com.example.ashwu.notidemo.ChatActivity;
import com.example.ashwu.notidemo.Const;
import com.example.ashwu.notidemo.R;

public class NotificationUtil {
    
//        public static int noti_id_static = 0;
    public static int noti_id_dynamic = 0;
    
    public static Notification getV4Notification(Context context,String content) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        builder.setContentTitle("This is notification " + noti_id_dynamic++ + "!");
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
        builder.setContentIntent(getIntent(context,content,noti_id_dynamic));
        return builder.build();
    }
    
    public static Notification getNotification(Context context,String content) {
        Notification.Builder builder = new Notification.Builder(context);
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        builder.setContentTitle("This is notification " + noti_id_dynamic++ + "!");
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
        builder.setContentIntent(getIntent(context,content,noti_id_dynamic));
        return builder.build();
    }
    
    private static PendingIntent getIntent(Context context,String content,int count) {
        Intent intent = new Intent(context,ChatActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra(Const.CONTENT,content);
        intent.putExtra(Const.COUNT,count);
        return PendingIntent.getActivity(context,noti_id_dynamic,intent,PendingIntent.FLAG_ONE_SHOT);
    }
}
