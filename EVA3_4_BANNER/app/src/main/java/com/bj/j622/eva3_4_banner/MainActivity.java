package com.bj.j622.eva3_4_banner;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    SeekBar seekbar;
    Banner ban;
    int t = 2000;
    int control = 1;
    Handler hand = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int var1 = 2000;
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
            int var = seekbar.getProgress();
            if(var == 0) {
                var = 1;
            }
            t = var1/var;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imgView);
        seekbar = findViewById(R.id.timeBar);
        ban = new Banner();
        ban.start();
    }
    class Banner extends Thread{
        @Override
        public void run() {
            super.run();
            while(true){
                try {
                    Thread.sleep(t);
                    Message msg = hand.obtainMessage();
                    hand.sendMessage(msg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        ban.interrupt();
    }
}