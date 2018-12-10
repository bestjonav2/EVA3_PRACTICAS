package com.bj.j622.eva3_13_mediaplayer_service;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Intent serviceIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        serviceIntent = new Intent(this, CustomService.class);

    }
    public void startOnClick(View v){
        startService(serviceIntent);
    }
    public void stopOnClick(View v){
        stopService(serviceIntent);
    }
}

