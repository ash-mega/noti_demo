/*
 * noti_demo
 * com.example.ashwu.notidemo.receiver
 *
 * Created by Ash Wu on 11/07/18 3:45 PM.
 * Copyright (c) 2018 mega.nz
 */
package com.example.ashwu.notidemo.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.ashwu.notidemo.util.Logger;
import com.example.ashwu.notidemo.util.Utils;

public class ScreenBroadcastReceiver extends BroadcastReceiver {
    
    
    @Override
    public void onReceive(Context context,Intent intent) {
        String action = intent.getAction();
        if (Utils.isEmpty(action)) {
            return;
        }
        switch (action) {
            case Intent.ACTION_SCREEN_ON:
                
                break;
            case Intent.ACTION_SCREEN_OFF:
                
                break;
            default:
                log(action);
        }
    }
    
    private void log(Object any) {
        Logger.log(getClass().getSimpleName(),any,Logger.ERROR);
    }
}
