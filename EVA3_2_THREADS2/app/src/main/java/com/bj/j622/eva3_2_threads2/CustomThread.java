package com.bj.j622.eva3_2_threads2;

import android.util.Log;

public class CustomThread extends Thread {

    @Override
    public void run() {
        super.run();
        while (true) {
            Log.wtf("Thread","????");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
