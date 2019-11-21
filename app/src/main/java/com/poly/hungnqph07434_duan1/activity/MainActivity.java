package com.poly.hungnqph07434_duan1.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import com.poly.hungnqph07434_duan1.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MediaPlayer mediaPlayer= MediaPlayer.create(MainActivity.this, R.raw.nhacnen);

        mediaPlayer.start();
        //jnJsdnahkjsda
        // them text
    }

    public void playNow(View view) {
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
    }
}
