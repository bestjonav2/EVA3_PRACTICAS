package com.bj.j622.eva3_7_banner_post;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Banner hilo;
    int t = 2000;
    int control = 1;
    Handler hand = new Handler();
    Runnable run = new Runnable() {
        @Override
        public void run() {
            switch(control){
                case 1:
                    imageView.setImageResource(R.drawable.cloudy);
                    control++;
                    break;
                case 2:
                    imageView.setImageResource(R.drawable.rainy);
                    control++;
                    break;
                case 3:
                    imageView.setImageResource(R.drawable.sunny);
                    control=1;
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        hilo = new Banner();
        hilo.start();
    }
    class Banner extends Thread{
        @Override
        public void run() {
            super.run();
            while(true){
                try {
                    Thread.sleep(1000);
                    hand.post(run);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        hilo.interrupt();
    }
}
