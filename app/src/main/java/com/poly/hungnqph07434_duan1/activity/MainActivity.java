package com.poly.hungnqph07434_duan1.activity;

import android.media.MediaPlayer;
import android.os.Bundle;

import com.poly.hungnqph07434_duan1.BaseActivity;
import com.poly.hungnqph07434_duan1.R;
import com.poly.hungnqph07434_duan1.datasql.SqlOpenHelper;

public class MainActivity extends BaseActivity {
    private SqlOpenHelper sqlOpenHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sqlOpenHelper= new SqlOpenHelper(MainActivity.this);
        sqlOpenHelper.createDataBase();

        //jnJsdnahkjsda
        // them text
startActivityAnimation(this,2000, HelloActivity.class);


    }


}
