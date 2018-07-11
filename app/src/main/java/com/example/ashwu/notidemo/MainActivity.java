package com.example.ashwu.notidemo;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.ashwu.notidemo.service.TestJobService;

public class MainActivity extends Activity {
    
    @Override
    @TargetApi(21)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startService(new Intent(this,TestJobService.class));
    }
}
