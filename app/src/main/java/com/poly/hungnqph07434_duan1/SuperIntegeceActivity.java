package com.poly.hungnqph07434_duan1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class SuperIntegeceActivity extends AppCompatActivity {
private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_super_integece);
        fragmentManager=getSupportFragmentManager();
        getSupportFragmentManager().beginTransaction().add(R.id.framesuper, new SuperIntegeceFragment()).commit();
    }
}
