package com.bj.j622.eva3_11_broadcast_reciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Intent service;
    TextView txt;
    BroadcastReceiver bcast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.textET);
        service = new Intent(this, CustomService.class);

        bcast = new CustomBroadcast();
        IntentFilter ifMiFiltro = new IntentFilter("service");
        registerReceiver(bcast,ifMiFiltro);
    }
    public void startOnClick(View v){
        startService(service);
    }
    public void stopOnClick(View v){
        stopService(service);
    }

    class CustomBroadcast extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            txt.append(intent.getStringExtra("msg"));
        }
    }
}
