package com.poly.hungnqph07434_duan1.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.poly.hungnqph07434_duan1.R;

public class HomeActivity extends AppCompatActivity {
    private ImageView imgFastPlay;
    private ImageView imgTop;
    private ImageView imgSetting, imgsuperplay;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_home);
        imgFastPlay = (ImageView) findViewById(R.id.imgFastPlay);
        imgTop = (ImageView) findViewById(R.id.imgTop);
//        imgSetting = (ImageView) findViewById(R.id.imgSetting);
        imgsuperplay=findViewById(R.id.imgsuperplay);

        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.an_lefthome);
        animation1.setInterpolator(new LinearInterpolator());
        imgFastPlay.startAnimation(animation1);


        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.an_righthome);
        animation1.setInterpolator(new LinearInterpolator());
//        imgSetting.startAnimation(animation2);
        imgTop.startAnimation(animation2);
        imgsuperplay.startAnimation(animation1);







    }

    public void fastPlay(View view) {
        MediaPlayer mediaPlayer= MediaPlayer.create(HomeActivity.this, R.raw.nutan);
        mediaPlayer.start();
        startActivity(new Intent(HomeActivity.this, FastPlayActivity.class));

    }

    public void setting(View view) {
        MediaPlayer mediaPlayer= MediaPlayer.create(HomeActivity.this, R.raw.nutan);
        mediaPlayer.start();
        AlertDialog.Builder builder= new AlertDialog.Builder(HomeActivity.this);
        View dialog= LayoutInflater.from(HomeActivity.this).inflate(R.layout.dialog_setting, null, false);

        builder.setView(dialog);
        builder.create();
builder.show();

    }

    public void top10(View view) {
        MediaPlayer mediaPlayer= MediaPlayer.create(HomeActivity.this, R.raw.nutan);
        mediaPlayer.start();
        startActivity(new Intent(HomeActivity.this, TopActivity.class));
    }

    public void superPlay(View view) {
        MediaPlayer mediaPlayer= MediaPlayer.create(HomeActivity.this, R.raw.nutan);
        mediaPlayer.start();
        startActivity(new Intent(HomeActivity.this, SuperPlayActivity.class));

    }
}
