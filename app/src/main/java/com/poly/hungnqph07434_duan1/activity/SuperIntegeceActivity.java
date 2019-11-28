package com.poly.hungnqph07434_duan1.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.poly.hungnqph07434_duan1.R;

public class SuperIntegeceActivity extends AppCompatActivity {
private FragmentManager fragmentManager;
    private ConstraintLayout time;
    private TextView textView;
    private TextView tvdiemfas;
    private TextView tvTimecout;
    private TextView tvQuetion;
    private LinearLayout lrlDaA;
    private TextView tvDaA;
    private TextView tvTlA;
    private LinearLayout lrlDaB;
    private TextView tvDaB;
    private TextView tvtlB;
    private LinearLayout lrlDaC;
    private TextView tvDaC;
    private TextView tvTlC;
    private LinearLayout lrlDaD;
    private TextView tvDaD;
    private TextView tvTlD;
    private Button btnNextQue;
    private ImageView settingFast;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_super_integece);
//        fragmentManager=getSupportFragmentManager();
//        getSupportFragmentManager().beginTransaction().add(R.id.framesuper, new SuperIntegeceFragment()).commit();

        time = (ConstraintLayout) findViewById(R.id.time);
        textView = (TextView) findViewById(R.id.textView);
        tvdiemfas = (TextView) findViewById(R.id.tvdiemfas);
        tvTimecout = (TextView) findViewById(R.id.tvTimecout);
        tvQuetion = (TextView) findViewById(R.id.tvQuetion);
        lrlDaA = (LinearLayout) findViewById(R.id.lrlDaA);
        tvDaA = (TextView) findViewById(R.id.tvDaA);
        tvTlA = (TextView) findViewById(R.id.tvTlA);
        lrlDaB = (LinearLayout) findViewById(R.id.lrlDaB);
        tvDaB = (TextView) findViewById(R.id.tvDaB);
        tvtlB = (TextView) findViewById(R.id.tvtlB);
        lrlDaC = (LinearLayout) findViewById(R.id.lrlDaC);
        tvDaC = (TextView) findViewById(R.id.tvDaC);
        tvTlC = (TextView) findViewById(R.id.tvTlC);
        lrlDaD = (LinearLayout) findViewById(R.id.lrlDaD);
        tvDaD = (TextView) findViewById(R.id.tvDaD);
        tvTlD = (TextView) findViewById(R.id.tvTlD);
        btnNextQue = (Button) findViewById(R.id.btnNextQue);
        settingFast = (ImageView) findViewById(R.id.setting_fast);



    }

    public void clickA(View view) {

    }

    public void clickB(View view) {
    }

    public void clickC(View view) {
    }

    public void clickD(View view) {
    }

    public void cauTiepTheo(View view) {
    }

    public void settingFast(View view) {
    }
}
