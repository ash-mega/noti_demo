/*
 * NotiDemo
 * com.example.ashwu.notidemo
 *
 * Created by Ash Wu on 6/07/18 9:48 AM.
 * Copyright (c) 2018 mega.nz
 */
package com.example.ashwu.notidemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;


public class ChatActivity extends Activity {
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        TextView tv = (TextView)findViewById(R.id.chat_content);
        
        Intent intent = getIntent();
        String acion = intent.getAction();
        String content = intent.getStringExtra(Const.CONTENT);
        int count = intent.getIntExtra(Const.COUNT,-1);
        int flag = intent.getFlags();
        String type = intent.getType();
        
        Utils.log(intent);
        Utils.log("========================");
        Utils.log(new data(acion,content,flag,type));
        tv.setText(count + "/n" + content);
    }
    
    class data {
        
        String action;
        
        String content;
        
        int flag;
        
        String type;
        
        public data(String action,String content,int flag,String type) {
            this.action = action;
            this.content = content;
            this.flag = flag;
            this.type = type;
        }
        
        @Override
        public String toString() {
            return "intent {" +
                    "action='" + action + '\'' +
                    ", content='" + content + '\'' +
                    ", flag=" + flag +
                    ", type='" + type + '\'' +
                    '}';
        }
    }
}
