package com.poly.hungnqph07434_duan1.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;

import com.poly.hungnqph07434_duan1.R;

public class SuperPlayActivity extends AppCompatActivity {
    private LinearLayout lnlToan;
    private LinearLayout lnlVatLy;
    private LinearLayout lnlHoa;
    private LinearLayout lnlSinhhoc;
    private LinearLayout lnlSuhoc;
    private LinearLayout lnlDialy;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_super_play);

        lnlToan = (LinearLayout) findViewById(R.id.lnlToan);
        lnlVatLy = (LinearLayout) findViewById(R.id.lnlVatLy);
        lnlHoa = (LinearLayout) findViewById(R.id.lnlHoa);
        lnlSinhhoc = (LinearLayout) findViewById(R.id.lnlSinhhoc);
        lnlSuhoc = (LinearLayout) findViewById(R.id.lnlSuhoc);
        lnlDialy = (LinearLayout) findViewById(R.id.lnlDialy);

        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.an_lefthome);
        animation1.setInterpolator(new LinearInterpolator());
        lnlVatLy.startAnimation(animation1);
        lnlSinhhoc.startAnimation(animation1);
        lnlDialy.startAnimation(animation1);

        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.an_righthome);
        animation1.setInterpolator(new LinearInterpolator());
        lnlToan.startAnimation(animation2);
        lnlHoa.startAnimation(animation2);
        lnlSuhoc.startAnimation(animation2);



    }

    public void toan(View view) {
        startActivity(new Intent(SuperPlayActivity.this,ToanActivity.class));
    }

    public void vatLy(View view) {
        startActivity(new Intent(SuperPlayActivity.this,VatlyActivity.class));
    }

    public void sinhHoc(View view) {
        startActivity(new Intent(SuperPlayActivity.this,SinhActivity.class));
    }

    public void hoaHoc(View view) {
        startActivity(new Intent(SuperPlayActivity.this,HoaActivity.class));
    }

    public void lichSu(View view) {
        startActivity(new Intent(SuperPlayActivity.this,SuActivity.class));
    }

    public void diaLy(View view) {
        startActivity(new Intent(SuperPlayActivity.this,DiaActivity.class));
    }
}
