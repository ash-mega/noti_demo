/*
 * noti_demo
 * com.example.ashwu.notidemo
 *
 * Created by Ash Wu on 11/07/18 3:17 PM.
 * Copyright (c) 2018 mega.nz
 */
package com.example.ashwu.notidemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.example.ashwu.notidemo.util.ScreenManager;

public class OnePxActivity extends Activity {
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setWindow();
        ScreenManager.getInstance(this).setActivity(this);
    }
    
    private void setWindow() {
        Window window = getWindow();
        window.setGravity(Gravity.START | Gravity.TOP);
        WindowManager.LayoutParams attributes = window.getAttributes();
        //宽高设计为1个像素
        attributes.width = 1;
        attributes.height = 1;
        //起始坐标
        attributes.x = 0;
        attributes.y = 0;
        window.setAttributes(attributes);
    }
    
    public static void startOnePxActivity(Context context) {
        Intent intent = new Intent(context,OnePxActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
