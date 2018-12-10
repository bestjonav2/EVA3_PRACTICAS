package com.bj.j622.eva_5_chars;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText charET;
    CharCount hilo;
    TextView numTV;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String chars = charET.getText().toString();
            int n = chars.length();
            numTV.setText("Hay: "+n+" caracteres.");
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        charET = findViewById(R.id.editTxtCarac);
        numTV = findViewById(R.id.txtNumero);

        hilo = new CharCount();
        hilo.start();
    }
    class CharCount extends Thread
    {
        @Override
        public void run() {
            super.run();
            while(true){
                Message msg = handler.obtainMessage();
                handler.sendMessage(msg);
                try {
                    Thread.sleep(50);
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
