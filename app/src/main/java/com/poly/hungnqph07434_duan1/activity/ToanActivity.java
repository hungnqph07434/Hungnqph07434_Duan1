package com.poly.hungnqph07434_duan1.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.poly.hungnqph07434_duan1.R;
import com.poly.hungnqph07434_duan1.datasql.SqlOpenHelper;
import com.poly.hungnqph07434_duan1.model.CauHoi;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToanActivity extends AppCompatActivity {

    private ConstraintLayout time;
    private TextView tvdiemToan;
    private TextView tvTimecoutToan;
    private TextView tvQuetionToan;
    private LinearLayout lrlDaA;
    private TextView tvDaA;
    private TextView tvTlAToan;
    private LinearLayout lrlDaB;
    private TextView tvDaB;
    private TextView tvtlBToan;
    private LinearLayout lrlDaC;
    private TextView tvDaC;
    private TextView tvTlCToan;
    private LinearLayout lrlDaD;

    private TextView tvDaD;
    private TextView tvTlDToan;
    private Button btnNextQueToan;
    private ImageView settingFast;

    private int position;

    private Random random;
    private int Scores;
    private AlertDialog.Builder builder;


    private TextView tvTlD;
    private ImageView imgsettingFast;
    private SqlOpenHelper sqlOpenHelper;
    private List<CauHoi> cauHoiList;

    private int giayClock;
    private CountDownTimer countDownTimer;

    private TextView tvDiemend;
    private Button btnChoiLai;
    private Button btnCancleHome;

    private TextView tvDiemthang;
    private Button btnChoiTiep;
    private Button btnCancleHomeVictory;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toan);
//Ánh sạ thành phần
        time = (ConstraintLayout) findViewById(R.id.timeToan);
        tvdiemToan = (TextView) findViewById(R.id.tvdiemToan);
        tvTimecoutToan = (TextView) findViewById(R.id.tvTimecoutToan);
        tvQuetionToan = (TextView) findViewById(R.id.tvQuetionToan);
        lrlDaA = (LinearLayout) findViewById(R.id.lrlDaAToan);
        tvDaA = (TextView) findViewById(R.id.tvDaAToan);
        tvTlAToan = (TextView) findViewById(R.id.tvTlAToan);
        lrlDaB = (LinearLayout) findViewById(R.id.lrlDaBToan);
        tvDaB = (TextView) findViewById(R.id.tvDaBToan);
        tvtlBToan = (TextView) findViewById(R.id.tvtlBToan);
        lrlDaC = (LinearLayout) findViewById(R.id.lrlDaCToan);
        tvDaC = (TextView) findViewById(R.id.tvDaCToan);
        tvTlCToan = (TextView) findViewById(R.id.tvTlCToan);
        lrlDaD = (LinearLayout) findViewById(R.id.lrlDaDToan);
        tvDaD = (TextView) findViewById(R.id.tvDaDToan);
        tvTlDToan = (TextView) findViewById(R.id.tvTlDToan);
        btnNextQueToan = (Button) findViewById(R.id.btnNextQueToan);
        settingFast = (ImageView) findViewById(R.id.setting_fastToan);


        //Gắn điểm bằng 0;
        Scores=0;
        //Hiệu ứng
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.an_right);
        animation.setInterpolator(new LinearInterpolator());
        time.startAnimation(animation);
        lrlDaA.startAnimation(animation);
        lrlDaC.startAnimation(animation);
        btnNextQueToan.startAnimation(animation);

        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.an_left);
        animation1.setInterpolator(new LinearInterpolator());
        tvQuetionToan.startAnimation(animation1);
        lrlDaB.startAnimation(animation1);
        lrlDaD.startAnimation(animation1);
        settingFast.startAnimation(animation1);



        //Khởi tạo dữ liệu
        sqlOpenHelper  = new SqlOpenHelper(ToanActivity.this);
        cauHoiList= new ArrayList<>();
        sqlOpenHelper.createDataBase();

        cauHoiList= sqlOpenHelper.getAllCauHoi();
//Khởi tạo vị trí lấy câu hỏi.
        random= new Random();
        Scores=0;
        position=random.nextInt(450);

        builder = new AlertDialog.Builder(ToanActivity  .this, R.style.DialogCustomTheme);

        tvQuetionToan.setText(cauHoiList.get(position).getCauHoi());
        tvTlAToan.setText(cauHoiList.get(position).getDapAnA());
        tvtlBToan.setText(cauHoiList.get(position).getDapAnB());
        tvTlCToan.setText(cauHoiList.get(position).getDapAnC());
        tvTlDToan.setText(cauHoiList.get(position).getDapAnD());

        clock();

    }

    public void clock() {
        giayClock = 90;
        countDownTimer = new CountDownTimer(giayClock * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                giayClock--;
                tvTimecoutToan.setText(giayClock + "");
            }

            @Override
            public void onFinish() {
                //hết giờ chơi

                View view1 = LayoutInflater.from(ToanActivity.this).inflate(R.layout.dialog_hetgio, null);
                //tvDiemend.setText(Scores+"");
                builder.setView(view1);
                builder.create();
                builder.show();
//                Button btnNoDialog;
//                Button btnYesDialog;

            }
        };
        countDownTimer.start();
    }

    public void chuyenCau(){
        int sobatky=1;
        sobatky=random.nextInt(10);
        position+=2;
        tvQuetionToan.setText(cauHoiList.get(position).getCauHoi());
        tvTlAToan.setText(cauHoiList.get(position).getDapAnA());
        tvtlBToan.setText(cauHoiList.get(position).getDapAnB());
        tvTlCToan.setText(cauHoiList.get(position).getDapAnC());
        tvTlDToan.setText(cauHoiList.get(position).getDapAnD());
    }

    public void settingFast(View view) {

        AlertDialog.Builder builder= new AlertDialog.Builder(ToanActivity.this);
        View dialog= LayoutInflater.from(ToanActivity.this).inflate(R.layout.dialog_setting, null, false);

        builder.setView(dialog);
        builder.create();
        builder.show();

    }


    public void amThanhTraLoiDung(){
        MediaPlayer mediaPlayer= MediaPlayer.create(ToanActivity.this, R.raw.dung);
        mediaPlayer.start();
    }

    public void amThanhsai(){
        MediaPlayer mediaPlayer= MediaPlayer.create(ToanActivity.this, R.raw.sai);
        mediaPlayer.start();
    }

    public void cauTiepTheo(View view) {
        chuyenCau();
    }

    public void clickD(View view) {
        if (tvDaD.getText().toString().trim().equals(cauHoiList.get(position).getDapAnDung())){
            amThanhTraLoiDung();
            Scores+=1;
            tvdiemToan.setText(Scores+"");
            if (Scores==10){
                View view1 = LayoutInflater.from(ToanActivity.this).inflate(R.layout.dialog_victory, null);
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
                        startActivity(new Intent(ToanActivity.this,HomeActivity.class));
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
            trangthaiKhongDuocChon();
            amThanhsai();
            View view1 = LayoutInflater.from(ToanActivity.this).inflate(R.layout.dialog_hetgio, null);
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
                    startActivity(new Intent(ToanActivity.this,HomeActivity.class));
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
            amThanhTraLoiDung();
            Scores+=1;
            tvdiemToan.setText(Scores+"");
            if (Scores==10){
                View view1 = LayoutInflater.from(ToanActivity.this).inflate(R.layout.dialog_victory, null);
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
                        startActivity(new Intent(ToanActivity.this,HomeActivity.class));
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
            trangthaiKhongDuocChon();
            amThanhsai();
            View view1 = LayoutInflater.from(ToanActivity.this).inflate(R.layout.dialog_hetgio, null);
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
                    startActivity(new Intent(ToanActivity.this,HomeActivity.class));
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
            amThanhTraLoiDung();
            Scores+=1;
            tvdiemToan.setText(Scores+"");
            if (Scores==10){
                View view1 = LayoutInflater.from(ToanActivity.this).inflate(R.layout.dialog_victory, null);
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
                        startActivity(new Intent(ToanActivity.this,HomeActivity.class));
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
            trangthaiKhongDuocChon();
            amThanhsai();
            View view1 = LayoutInflater.from(ToanActivity.this).inflate(R.layout.dialog_hetgio, null);
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
                    startActivity(new Intent(ToanActivity.this,HomeActivity.class));
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

    public void clickA(View view) {
        if (tvDaA.getText().toString().trim().equals(cauHoiList.get(position).getDapAnDung())){
            amThanhTraLoiDung();
            Scores+=1;
            tvdiemToan.setText(Scores+"");
            if (Scores==10){
                View view1 = LayoutInflater.from(ToanActivity.this).inflate(R.layout.dialog_victory, null);
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
                        startActivity(new Intent(ToanActivity.this,HomeActivity.class));
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
            trangthaiKhongDuocChon();
            amThanhsai();
            View view1 = LayoutInflater.from(ToanActivity.this).inflate(R.layout.dialog_hetgio, null);
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
                    startActivity(new Intent(ToanActivity.this,HomeActivity.class));
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

    public void trangthaiKhongDuocChon(){
        lrlDaD.setClickable(false);
        lrlDaA.setClickable(false);
        lrlDaB.setClickable(false);
        lrlDaC.setClickable(false);
    }
}
