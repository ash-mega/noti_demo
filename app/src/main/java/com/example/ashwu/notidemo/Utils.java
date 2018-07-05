/**
 * sms org.ashtray.mobile.sms
 * <p>
 * Created by Ash Wu on 1/04/2018 1:23 PM.
 * Copyright (c) 2018 ashtray.org
 */
package com.example.ashwu.notidemo;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Utils {
    
    private static DateFormat df = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss",Locale.getDefault());
    
    public static String toString(Object obj) {
        if (obj == null) {
            return Const.NULL_STR;
        }
        if (obj instanceof Date) {
            return df.format(obj);
        }
        return obj.toString();
    }
    
    public static void log(Object content) {
        Log.d(Const.TAG,toString(content));
    }
    
    public static String currTimeString(long currMillis) {
        return df.format(new Date(currMillis));
    }
    
    public static void toast(Context context,Object obj) {
        String content = toString(obj);
        Toast.makeText(context,content,Toast.LENGTH_SHORT).show();
    }
}
