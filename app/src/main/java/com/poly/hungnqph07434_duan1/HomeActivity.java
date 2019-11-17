package com.poly.hungnqph07434_duan1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    }

    public void fastPlay(View view) {
        startActivity(new Intent(HomeActivity.this,FastPlayActivity.class));

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
