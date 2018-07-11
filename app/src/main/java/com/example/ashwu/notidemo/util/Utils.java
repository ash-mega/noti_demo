/**
 * sms org.ashtray.mobile.sms
 * <p>
 * Created by Ash Wu on 1/04/2018 1:23 PM.
 * Copyright (c) 2018 ashtray.org
 */
package com.example.ashwu.notidemo.util;

import android.app.ActivityManager;
import android.content.Context;
import android.widget.Toast;

import com.example.ashwu.notidemo.Const;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Utils {
    
    private static DateFormat df = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss",Locale.getDefault());
    
    public static boolean isAppAlive(Context context,String packageName) {
        boolean isAppRunning = false;
        ActivityManager activityManager = (ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> appProcessInfoList = activityManager.getRunningAppProcesses();
        for (ActivityManager.RunningAppProcessInfo appInfo : appProcessInfoList) {
            if (packageName.equals(appInfo.processName)) {
                isAppRunning = true;
                break;
            }
        }
        return isAppRunning;
    }
    
    public static String toString(Object obj) {
        if (obj == null) {
            return Const.NULL_STR;
        }
        if (obj instanceof Date) {
            return df.format(obj);
        }
        return obj.toString();
    }
    
    public static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
    
    public static String currTimeString(long currMillis) {
        return df.format(new Date(currMillis));
    }
    
    public static void toast(Context context,Object any) {
        Toast.makeText(context,toString(any),Toast.LENGTH_SHORT).show();
    }
}
