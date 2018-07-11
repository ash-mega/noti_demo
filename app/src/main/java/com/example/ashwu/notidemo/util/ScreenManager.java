/*
 * noti_demo
 * com.example.ashwu.notidemo.util
 *
 * Created by Ash Wu on 11/07/18 3:21 PM.
 * Copyright (c) 2018 mega.nz
 */
package com.example.ashwu.notidemo.util;

import android.app.Activity;
import android.content.Context;

import com.example.ashwu.notidemo.OnePxActivity;

import java.lang.ref.WeakReference;

public class ScreenManager {
    
    private Context context;
    
    private static ScreenManager mScreenManager;
    
    private WeakReference<Activity> mActivity;
    
    private ScreenManager(Context context) {
        this.context = context;
    }
    
    public static ScreenManager getInstance(Context context) {
        if (mScreenManager == null) {
            mScreenManager = new ScreenManager(context.getApplicationContext());
        }
        return mScreenManager;
    }
    
    public void setActivity(Activity activity) {
        this.mActivity = new WeakReference<>(activity);
    }
    
    public void startOnePx() {
        OnePxActivity.startOnePxActivity(context);
    }
    
    public void finishOnePx() {
        if (mActivity != null) {
            Activity activity = mActivity.get();
            if (activity != null) {
                activity.finish();
            }
        }
    }
}
