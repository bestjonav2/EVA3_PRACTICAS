package com.bj.j622.eva3_2_threads2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.text11);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        text.setText("?????");
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        
        Thread hilo = new Thread(runnable);
        hilo.start();
        CustomThread ct = new CustomThread();
        ct.start();
    }
}
