package com.bj.j622.eva3_13_mediaplayer_service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class CustomService extends Service {

    MediaPlayer player;
    public CustomService() {
        player = MediaPlayer.create(this,R.raw.shine_on_you_crazy_diamond);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        player = MediaPlayer.create(this,R.raw.shine_on_you_crazy_diamond);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Toast.makeText(this, "?", Toast.LENGTH_SHORT).show();
        if(player != null){
            player.start();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(player != null){
            player.stop();
            player.release();
        }
    }

}
