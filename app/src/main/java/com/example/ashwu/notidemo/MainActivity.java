package com.example.ashwu.notidemo;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Bundle;

import com.example.ashwu.notidemo.util.Logger;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public class MainActivity extends Activity {
    
    @Override
    @TargetApi(21)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GoogleApiAvailability tester = GoogleApiAvailability.getInstance();
        int result = tester.isGooglePlayServicesAvailable(this);
//        tester.makeGooglePlayServicesAvailable(this);
        log(result == ConnectionResult.SUCCESS);
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
