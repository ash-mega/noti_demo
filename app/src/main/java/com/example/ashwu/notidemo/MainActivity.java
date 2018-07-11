package com.example.ashwu.notidemo;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Bundle;

import com.example.ashwu.notidemo.util.Logger;

public class MainActivity extends Activity {
    
    @Override
    @TargetApi(21)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    
    @Override
    protected void onPause() {
        super.onPause();
        DemoApplication.activityVisible = false;
        log("onPause");
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        DemoApplication.activityVisible = true;
        log("onResume");
    }
    
    private void log(Object any) {
        Logger.log(getClass().getSimpleName(),any,Logger.ERROR);
    }
}
