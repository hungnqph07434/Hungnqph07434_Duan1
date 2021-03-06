package com.poly.hungnqph07434_duan1;

import android.content.Context;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    public void startActivityAnimation(final Context context, final long mili, final Class mhChuyen){
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(mili);
                    overridePendingTransition(0, 0);
                    context.startActivity(new Intent(context ,mhChuyen));
                    overridePendingTransition(0, 0);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                super.run();
            }
        };
        thread.start();
    }
}
