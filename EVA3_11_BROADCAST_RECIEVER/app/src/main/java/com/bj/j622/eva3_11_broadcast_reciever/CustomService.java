package com.bj.j622.eva3_11_broadcast_reciever;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class CustomService extends Service {

    Thread hilo;
    Intent dataIntent;

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        dataIntent = new Intent("service");
        dataIntent.putExtra("msg","start");
        sendBroadcast(dataIntent);
        Runnable run346 = new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(1000);
                        Log.wtf("aaaaa??","test");
                        dataIntent = new Intent("service");
                        dataIntent.putExtra("msg","test");
                        sendBroadcast(dataIntent);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        };
        hilo = new Thread(run346);
        hilo.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        hilo.interrupt();
        dataIntent = new Intent("service");
        dataIntent.putExtra("msg","destroy");
        sendBroadcast(dataIntent);
    }

}
