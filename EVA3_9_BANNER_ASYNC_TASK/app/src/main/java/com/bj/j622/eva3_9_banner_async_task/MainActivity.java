package com.bj.j622.eva3_9_banner_async_task;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    BannerAsync banner;
    ImageView img;
    int control = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = findViewById(R.id.imageView);

        banner = new BannerAsync();
        banner.execute();
    }
    class BannerAsync extends AsyncTask<Integer,Integer,Integer>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            switch(control){
                case 1:
                    img.setImageResource(R.drawable.cloudy);
                    break;
                case 2:
                    img.setImageResource(R.drawable.rainy);
                    break;
                case 3:
                    img.setImageResource(R.drawable.sunny);
                    control=1;
                    break;
            }
        }

        @Override
        protected Integer doInBackground(Integer... integers) {
            while(true){
                try {
                    Thread.sleep(1000);
                    publishProgress(control++);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        banner.cancel(true);
    }
}
