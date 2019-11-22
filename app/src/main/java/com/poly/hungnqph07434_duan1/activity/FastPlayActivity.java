package com.poly.hungnqph07434_duan1.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.poly.hungnqph07434_duan1.model.CauHoi;
import com.poly.hungnqph07434_duan1.R;
import com.poly.hungnqph07434_duan1.datasql.SqlOpenHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FastPlayActivity extends AppCompatActivity {
private FrameLayout frameLayout;
private FragmentManager fragmentManager;
    private ConstraintLayout constraintLayout;
    private TextView textView;
    private TextView tvdiemfas;
    private TextView tvTimecout;
    private TextView tvQuetion;
    private LinearLayout lrlDaA;
    private TextView tvTlA;
    private int giayClock;
    private CountDownTimer countDownTimer;
    private LinearLayout lrlDaB;
    private TextView tvtlB;
    private LinearLayout lrlDaC;
    private TextView tvTlC;
    private TextView tvDaA;
    private TextView tvDaB;
    private TextView tvDaC;
    private TextView tvDaD;
    private int Scores;
    private Button btnNextQue;
    private AlertDialog.Builder builder;


    private TextView tvDiemend;
    private Button btnChoiLai;
    private Button btnCancleHome;

    private TextView tvDiemthang;
    private Button btnChoiTiep;
    private Button btnCancleHomeVictory;





    private LinearLayout lrlDaD;
    private TextView tvTlD;
    private ImageView imgsettingFast;
    private SqlOpenHelper sqlOpenHelper;
    private List<CauHoi> cauHoiList;

    private int position;

private Random random;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fast_play);

        //Ánh xạ các thành phần
        constraintLayout = (ConstraintLayout) findViewById(R.id.time);
        textView = (TextView) findViewById(R.id.textView);
        tvdiemfas = (TextView) findViewById(R.id.tvdiemfas);
        tvTimecout = (TextView) findViewById(R.id.tvTimecout);
        tvQuetion = (TextView) findViewById(R.id.tvQuetion);
        lrlDaA = (LinearLayout) findViewById(R.id.lrlDaA);
        tvTlA = (TextView) findViewById(R.id.tvTlA);
        lrlDaB = (LinearLayout) findViewById(R.id.lrlDaB);
        tvtlB = (TextView) findViewById(R.id.tvtlB);
        lrlDaC = (LinearLayout) findViewById(R.id.lrlDaC);
        tvTlC = (TextView) findViewById(R.id.tvTlC);
        lrlDaD = (LinearLayout) findViewById(R.id.lrlDaD);
        tvDaA = (TextView) findViewById(R.id.tvDaA);
        btnNextQue=findViewById(R.id.btnNextQue);
        tvDaB = (TextView) findViewById(R.id.tvDaB);
        tvDaC = (TextView) findViewById(R.id.tvDaC);
        tvDaD = (TextView) findViewById(R.id.tvDaD);
        tvTlD = (TextView) findViewById(R.id.tvTlD);
        imgsettingFast = (ImageView) findViewById(R.id.setting_fast);

        Scores=0;
        //Hiệu ứng
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.an_right);
        animation.setInterpolator(new LinearInterpolator());
        constraintLayout.startAnimation(animation);
        lrlDaA.startAnimation(animation);
        lrlDaC.startAnimation(animation);
        btnNextQue.startAnimation(animation);

        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.an_left);
        animation1.setInterpolator(new LinearInterpolator());
        tvQuetion.startAnimation(animation1);
        lrlDaB.startAnimation(animation1);
        lrlDaD.startAnimation(animation1);
        imgsettingFast.startAnimation(animation1);

        sqlOpenHelper  = new SqlOpenHelper(FastPlayActivity.this);
        cauHoiList= new ArrayList<>();
        sqlOpenHelper.createDataBase();

        cauHoiList= sqlOpenHelper.getAllCauHoi();

        random= new Random();
        Scores=0;
        position=random.nextInt(450);

        builder = new AlertDialog.Builder(FastPlayActivity.this, R.style.DialogCustomTheme);




tvQuetion.setText(cauHoiList.get(position).getCauHoi());
tvTlA.setText(cauHoiList.get(position).getDapAnA());
tvtlB.setText(cauHoiList.get(position).getDapAnB());
tvTlC.setText(cauHoiList.get(position).getDapAnC());
tvTlD.setText(cauHoiList.get(position).getDapAnD());


if (lrlDaA.isSelected()){

}





        //TimeStart
        clock();



//fragmentManager=getSupportFragmentManager();
//        getSupportFragmentManager().beginTransaction().add(R.id.frame, new FastPlayFragment()).commit();


    }

    public void clock() {
        giayClock = 90;
        countDownTimer = new CountDownTimer(giayClock * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                giayClock--;
                tvTimecout.setText(giayClock + "");
            }

            @Override
            public void onFinish() {
                //hết giờ chơi

                View view1 = LayoutInflater.from(FastPlayActivity.this).inflate(R.layout.dialog_hetgio, null);
                tvDiemend.setText(Scores+"");
                builder.setView(view1);
                builder.create();
                builder.show();
//                Button btnNoDialog;
//                Button btnYesDialog;

            }
        };
        countDownTimer.start();
    }





public void clickDapAn(){
        if (lrlDaA.isSelected()){

        }
}

public void chuyenCau(){
        int sobatky=1;
        sobatky=random.nextInt(10);
    position+=2;
    tvQuetion.setText(cauHoiList.get(position).getCauHoi());
    tvTlA.setText(cauHoiList.get(position).getDapAnA());
    tvtlB.setText(cauHoiList.get(position).getDapAnB());
    tvTlC.setText(cauHoiList.get(position).getDapAnC());
    tvTlD.setText(cauHoiList.get(position).getDapAnD());
}
//Chuyển câu tiếp theo.
    public void cauTiepTheo(View view) {

       chuyenCau();

    }

    public void settingFast(View view) {

        AlertDialog.Builder builder= new AlertDialog.Builder(FastPlayActivity.this);
        View dialog= LayoutInflater.from(FastPlayActivity.this).inflate(R.layout.dialog_setting, null, false);

        builder.setView(dialog);
        builder.create();
        builder.show();

    }

    public void timCauTraLoi(){

    }
//Click các đáp án, tính điểm.
    public void clickA(View view) {
        if (tvDaA.getText().toString().trim().equals(cauHoiList.get(position).getDapAnDung())){
            Scores+=1;
            tvdiemfas.setText(Scores+"");
            if (Scores==10){
                View view1 = LayoutInflater.from(FastPlayActivity.this).inflate(R.layout.dialog_victory, null);
                tvDiemthang = (TextView) view1.findViewById(R.id.tvDiemthang);
                btnChoiTiep = (Button) view1.findViewById(R.id.btnChoiTiep);
                btnCancleHomeVictory = (Button) view1.findViewById(R.id.btnCancleHomeVictory);
                tvDiemthang.setText(Scores+"");
                btnChoiTiep.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                        overridePendingTransition(0, 0);
                        startActivity(getIntent());
                        overridePendingTransition(0, 0);
                    }
                });
                btnCancleHomeVictory.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(FastPlayActivity.this,HomeActivity.class));
                        finish();
                    }
                });
                builder.setView(view1);
                builder.create();
                builder.show();
                countDownTimer.cancel();
            }
            chuyenCau();
        }else{
            View view1 = LayoutInflater.from(FastPlayActivity.this).inflate(R.layout.dialog_hetgio, null);
            tvDiemend =  view1.findViewById(R.id.tvDiemend);
            btnChoiLai = view1.findViewById(R.id.btnChoiLai);
            btnCancleHome =  view1.findViewById(R.id.btnCancleHome);
            btnChoiLai.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                    overridePendingTransition(0, 0);
                    startActivity(getIntent());
                    overridePendingTransition(0, 0);
                }
            });
            btnCancleHome.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(FastPlayActivity.this,HomeActivity.class));
                    finish();
                }
            });
            tvDiemend.setText(Scores+"");
            builder.setView(view1);
            builder.create();
            builder.show();
            countDownTimer.cancel();
        }
    }

    public void clickB(View view) {
        if (tvDaB.getText().toString().trim().equals(cauHoiList.get(position).getDapAnDung())){
            Scores+=1;
            tvdiemfas.setText(Scores+"");
            if (Scores==10){
                View view1 = LayoutInflater.from(FastPlayActivity.this).inflate(R.layout.dialog_victory, null);
                tvDiemthang = (TextView) view1.findViewById(R.id.tvDiemthang);
                btnChoiTiep = (Button) view1.findViewById(R.id.btnChoiTiep);
                btnCancleHomeVictory = (Button) view1.findViewById(R.id.btnCancleHomeVictory);
                tvDiemthang.setText(Scores+"");
                btnChoiTiep.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                        overridePendingTransition(0, 0);
                        startActivity(getIntent());
                        overridePendingTransition(0, 0);
                    }
                });
                btnCancleHomeVictory.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(FastPlayActivity.this,HomeActivity.class));
                        finish();
                    }
                });
                builder.setView(view1);
                builder.create();
                builder.show();
                countDownTimer.cancel();
            }
            chuyenCau();
        }else{
            View view1 = LayoutInflater.from(FastPlayActivity.this).inflate(R.layout.dialog_hetgio, null);
            tvDiemend =  view1.findViewById(R.id.tvDiemend);
            btnChoiLai = view1.findViewById(R.id.btnChoiLai);
            btnCancleHome =  view1.findViewById(R.id.btnCancleHome);
            btnChoiLai.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                    overridePendingTransition(0, 0);
                    startActivity(getIntent());
                    overridePendingTransition(0, 0);
                }
            });
            btnCancleHome.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(FastPlayActivity.this,HomeActivity.class));
                    finish();
                }
            });
            tvDiemend.setText(Scores+"");
            builder.setView(view1);

            builder.create();
            builder.show();
            countDownTimer.cancel();
        }
    }

    public void clickC(View view) {
        if (tvDaC.getText().toString().trim().equals(cauHoiList.get(position).getDapAnDung())){
            Scores+=1;
            tvdiemfas.setText(Scores+"");
            if (Scores==10){
                View view1 = LayoutInflater.from(FastPlayActivity.this).inflate(R.layout.dialog_victory, null);
                tvDiemthang = (TextView) view1.findViewById(R.id.tvDiemthang);
                btnChoiTiep = (Button) view1.findViewById(R.id.btnChoiTiep);
                btnCancleHomeVictory = (Button) view1.findViewById(R.id.btnCancleHomeVictory);
                tvDiemthang.setText(Scores+"");
                btnChoiTiep.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                        overridePendingTransition(0, 0);
                        startActivity(getIntent());
                        overridePendingTransition(0, 0);
                    }
                });
                btnCancleHomeVictory.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(FastPlayActivity.this,HomeActivity.class));
                        finish();
                    }
                });
                builder.setView(view1);
                builder.create();
                builder.show();
                countDownTimer.cancel();
            }
            chuyenCau();
        }else{
            View view1 = LayoutInflater.from(FastPlayActivity.this).inflate(R.layout.dialog_hetgio, null);
            tvDiemend =  view1.findViewById(R.id.tvDiemend);
            btnChoiLai = view1.findViewById(R.id.btnChoiLai);
            btnCancleHome =  view1.findViewById(R.id.btnCancleHome);
            btnChoiLai.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                    overridePendingTransition(0, 0);
                    startActivity(getIntent());
                    overridePendingTransition(0, 0);
                }
            });
            btnCancleHome.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(FastPlayActivity.this,HomeActivity.class));
                    finish();
                }
            });
            tvDiemend.setText(Scores+"");
            builder.setView(view1);
            builder.create();
            builder.show();
            countDownTimer.cancel();
        }
    }

    public void clickD(View view) {
        if (tvDaD.getText().toString().trim().equals(cauHoiList.get(position).getDapAnDung())){
            Scores+=1;
            tvdiemfas.setText(Scores+"");
            if (Scores==10){
                View view1 = LayoutInflater.from(FastPlayActivity.this).inflate(R.layout.dialog_victory, null);
                tvDiemthang = (TextView) view1.findViewById(R.id.tvDiemthang);
                btnChoiTiep = (Button) view1.findViewById(R.id.btnChoiTiep);
                btnCancleHomeVictory = (Button) view1.findViewById(R.id.btnCancleHomeVictory);
                tvDiemthang.setText(Scores+"");
                btnChoiTiep.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                        overridePendingTransition(0, 0);
                        startActivity(getIntent());
                        overridePendingTransition(0, 0);
                    }
                });
                btnCancleHomeVictory.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(FastPlayActivity.this,HomeActivity.class));
                        finish();
                    }
                });
                builder.setView(view1);
                builder.create();
                builder.show();
                countDownTimer.cancel();
            }
            chuyenCau();
        }else{
            View view1 = LayoutInflater.from(FastPlayActivity.this).inflate(R.layout.dialog_hetgio, null);
            tvDiemend =  view1.findViewById(R.id.tvDiemend);
            btnChoiLai = view1.findViewById(R.id.btnChoiLai);
            btnCancleHome =  view1.findViewById(R.id.btnCancleHome);
            btnChoiLai.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                    overridePendingTransition(0, 0);
                    startActivity(getIntent());
                    overridePendingTransition(0, 0);
                }
            });
            btnCancleHome.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(FastPlayActivity.this,HomeActivity.class));
                    finish();
                }
            });
            tvDiemend.setText(Scores+"");
            builder.setView(view1);
            builder.create();
            builder.show();
            countDownTimer.cancel();
        }

    }
}
