package com.bj.a622.eva3_1_threads;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                Log.wtf("Runnable", i + "");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread hilo1 = new Thread(runnable);
        hilo1.start();
        CustomThread hilo2 = new CustomThread();
        hilo2.start();
    }

    class CustomThread extends Thread {
        @Override
        public void run() {
            super.run();
            for (int i = 0; i < 20; i++) {
                Log.wtf("Thread", i + "");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
