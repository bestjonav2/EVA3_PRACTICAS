package com.bj.j622.eva3_6_handler_post;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    int val;
    Thread hilo;
    Handler hand = new Handler();

    Runnable backgroundThread = new Runnable() {
        @Override
        public void run() {
            while(true) {
                hand.post(runnableUI);
                val++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    Runnable runnableUI = new Runnable() {
        @Override
        public void run() {
            txt.append(val +" - ");
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.txt);

        hilo = new Thread(backgroundThread);
        hilo.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        hilo.interrupt();
    }
}
