package com.poly.hungnqph07434_duan1.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import com.poly.hungnqph07434_duan1.R;

public class HelloActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);

        MediaPlayer mediaPlayer= MediaPlayer.create(HelloActivity.this, R.raw.nhacnen);

        mediaPlayer.start();

    }

    public void playNow(View view) {
        MediaPlayer mediaPlayer= MediaPlayer.create(HelloActivity.this, R.raw.nutan);
        mediaPlayer.start();
        startActivity(new Intent(HelloActivity.this, HomeActivity.class));
    }

    public void signIn(View view) {
        MediaPlayer mediaPlayer= MediaPlayer.create(HelloActivity.this, R.raw.nutan);
        mediaPlayer.start();
        startActivity(new Intent(HelloActivity.this, LoginActivity.class));
    }
}
