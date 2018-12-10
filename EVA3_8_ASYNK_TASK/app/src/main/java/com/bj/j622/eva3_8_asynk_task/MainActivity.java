package com.bj.j622.eva3_8_asynk_task;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView data;
    AsynClass async;
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data = findViewById(R.id.txt);
        async = new AsynClass();
        async.execute("Hola","Mundo");
    }

    class AsynClass extends AsyncTask<String,Integer,Void> {
        String txt;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            data.setText(txt);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            data.append(i + " - ");
        }

        @Override
        protected Void doInBackground(String... strings) {
            txt = strings[0] + " " + strings[1];
            while(true){
                try{
                    Thread.sleep(1000);
                    publishProgress(i++);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        async.cancel(true);
    }
}
