/*
 * noti_demo
 * com.example.ashwu.notidemo.util
 *
 * Created by Ash Wu on 11/07/18 9:36 AM.
 * Copyright (c) 2018 mega.nz
 */
package com.example.ashwu.notidemo.util;

import android.util.Log;

import com.example.ashwu.notidemo.Const;

public class Logger {
    
    public static final int ERROR = 6;
    
    private static final int DEBUG = 3;
    private static final int INFO = 4;
    private static final int VERBOSE = 2;
    private static final int WARN = 5;
    
    public static void log(Object content) {
        log(Const.TAG,Utils.toString(content),DEBUG);
    }
    
    public static void log(String tag,Object any,int level) {
        String content = Utils.toString(any);
        switch (level) {
            case DEBUG:
                Log.d(tag,content);
                break;
            case ERROR:
                Log.e(tag,content);
                break;
            case WARN:
                Log.w(tag,content);
                break;
            case INFO:
                Log.i(tag,content);
                break;
            case VERBOSE:
                Log.v(tag,content);
                break;
            default:
                Log.d(tag,content);
        }
    }
}
