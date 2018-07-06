package com.example.ashwu.notidemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;

public class MainActivity extends Activity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        if (event.getAction() == MotionEvent.ACTION_DOWN) {
//            Intent intent = new Intent(Const.ACTION);
//            sendBroadcast(intent);
//            return true;
//        }
        return super.onTouchEvent(event);
    }
}
