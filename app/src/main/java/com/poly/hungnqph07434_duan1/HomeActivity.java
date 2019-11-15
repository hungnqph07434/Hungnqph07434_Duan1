package com.poly.hungnqph07434_duan1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    }

    public void fastPlay(View view) {


    }

    public void setting(View view) {
        AlertDialog.Builder builder= new AlertDialog.Builder(HomeActivity.this);

    }
}
