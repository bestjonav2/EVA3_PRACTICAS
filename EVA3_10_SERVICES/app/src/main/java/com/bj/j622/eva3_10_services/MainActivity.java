package com.bj.j622.eva3_10_services;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Intent service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        service = new Intent(this,CustomService.class);
    }
    public void startOnClick(View v){
        startService(service);
    }
    public void stopOnClick(View v){
        stopService(service);
    }
}
