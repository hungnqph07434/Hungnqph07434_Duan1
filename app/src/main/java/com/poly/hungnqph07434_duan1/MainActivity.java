package com.poly.hungnqph07434_duan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //jnJsdnahkjsda
        // them text
    }

    public void playNow(View view) {
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
    }
}
