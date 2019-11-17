package com.poly.hungnqph07434_duan1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.FrameLayout;

public class FastPlayActivity extends AppCompatActivity {
private FrameLayout frameLayout;
private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fast_play);

fragmentManager=getSupportFragmentManager();
        getSupportFragmentManager().beginTransaction().add(R.id.frame, new FastPlayFragment()).commit();


    }
}
