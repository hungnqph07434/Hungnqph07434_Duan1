package com.poly.hungnqph07434_duan1.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.poly.hungnqph07434_duan1.R;
import com.poly.hungnqph07434_duan1.datasql.SqlOpenHelper;

public class HomeActivity extends AppCompatActivity {
    private ImageView imgFastPlay;
    private ImageView imgTop;
    private ImageView imgSetting;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        imgFastPlay = (ImageView) findViewById(R.id.imgFastPlay);
        imgTop = (ImageView) findViewById(R.id.imgTop);
        imgSetting = (ImageView) findViewById(R.id.imgSetting);

        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.an_lefthome);
        animation1.setInterpolator(new LinearInterpolator());
        imgFastPlay.startAnimation(animation1);

        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.an_righthome);
        animation1.setInterpolator(new LinearInterpolator());
        imgSetting.startAnimation(animation2);

        imgTop.startAnimation(animation1);







    }

    public void fastPlay(View view) {
        startActivity(new Intent(HomeActivity.this, FastPlayActivity.class));

    }

    public void setting(View view) {
        AlertDialog.Builder builder= new AlertDialog.Builder(HomeActivity.this);
        View dialog= LayoutInflater.from(HomeActivity.this).inflate(R.layout.dialog_setting, null, false);

        builder.setView(dialog);
        builder.create();
builder.show();

    }

    public void top10(View view) {
        startActivity(new Intent(HomeActivity.this, TopActivity.class));
    }
}
