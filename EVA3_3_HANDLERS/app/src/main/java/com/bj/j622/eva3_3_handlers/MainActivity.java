package com.bj.j622.eva3_3_handlers;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    Thread hilo;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==1){
                int i = (int)msg.obj;
                txt.append(i+"-");
            }

        }
    };
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.txt);
        CustomThread ct = new CustomThread();
        hilo = new Thread(ct);
        hilo.start();
        //HANDLER
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        hilo.interrupt();
    }

    class CustomThread implements Runnable{
        @Override
        public void run() {
            int i = 0;
            while(true){
                i++;
                try {
                    Message msg = handler.obtainMessage(1,i);
                    handler.sendMessage(msg);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }
}
