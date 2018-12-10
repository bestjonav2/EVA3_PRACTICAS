package com.bj.j622.eva3_12_mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    MediaPlayer player = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        player = MediaPlayer.create(this, R.raw.shine_on_you_crazy_diamond);

    }
    @Override
    protected void onStop() {
        super.onStop();
        if(player != null){
            player.stop();
            player.release();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(player != null){
            player.start();
        }
    }
}
