package com.bj.j622.eva3_10_services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class CustomService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.wtf("Service","OnCreate");
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.wtf("Service","OnStart");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.wtf("Service","OnDestroy");
    }
}
