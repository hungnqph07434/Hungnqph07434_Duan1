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

public class VatlyActivity extends AppCompatActivity {

    private ConstraintLayout timeVatLy;
    private TextView textView;
    private TextView tvdiemfasVatLy;
    private TextView tvTimecoutVatLy;
    private TextView tvQuetionVatLy;
    private LinearLayout lrlDaAVatly;
    private TextView tvDaAVatLy;
    private TextView tvTlAVatLy;
    private LinearLayout lrlDaBVatLy;
    private TextView tvDaBVatLy;
    private TextView tvtlBVatLy;
    private LinearLayout lrlDaCVatLy;
    private TextView tvDaCVatLy;
    private TextView tvTlCVatLy;
    private LinearLayout lrlDaDVatLy;
    private TextView tvDaDVatLy;
    private TextView tvTlDVatLy;
    private Button btnNextQueVatLy;
    private ImageView settingFastVatLy;

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
        setContentView(R.layout.activity_vatly);

        timeVatLy = (ConstraintLayout) findViewById(R.id.timeVatLy);
        textView = (TextView) findViewById(R.id.textView);
        tvdiemfasVatLy = (TextView) findViewById(R.id.tvdiemfasVatLy);
        tvTimecoutVatLy = (TextView) findViewById(R.id.tvTimecoutVatLy);
        tvQuetionVatLy = (TextView) findViewById(R.id.tvQuetionVatLy);
        lrlDaAVatly = (LinearLayout) findViewById(R.id.lrlDaAVatly);
        tvDaAVatLy = (TextView) findViewById(R.id.tvDaAVatLy);
        tvTlAVatLy = (TextView) findViewById(R.id.tvTlAVatLy);
        lrlDaBVatLy = (LinearLayout) findViewById(R.id.lrlDaBVatLy);
        tvDaBVatLy = (TextView) findViewById(R.id.tvDaBVatLy);
        tvtlBVatLy = (TextView) findViewById(R.id.tvtlBVatLy);
        lrlDaCVatLy = (LinearLayout) findViewById(R.id.lrlDaCVatLy);
        tvDaCVatLy = (TextView) findViewById(R.id.tvDaCVatLy);
        tvTlCVatLy = (TextView) findViewById(R.id.tvTlCVatLy);
        lrlDaDVatLy = (LinearLayout) findViewById(R.id.lrlDaDVatLy);
        tvDaDVatLy = (TextView) findViewById(R.id.tvDaDVatLy);
        tvTlDVatLy = (TextView) findViewById(R.id.tvTlDVatLy);
        btnNextQueVatLy = (Button) findViewById(R.id.btnNextQueVatLy);
        settingFastVatLy = (ImageView) findViewById(R.id.setting_fastVatLy);




        //Gắn điểm bằng 0;
        Scores=0;
        //Hiệu ứng
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.an_right);
        animation.setInterpolator(new LinearInterpolator());
        timeVatLy.startAnimation(animation);
        lrlDaAVatly.startAnimation(animation);
        lrlDaCVatLy.startAnimation(animation);
        btnNextQueVatLy.startAnimation(animation);

        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.an_left);
        animation1.setInterpolator(new LinearInterpolator());
        tvQuetionVatLy.startAnimation(animation1);
        lrlDaBVatLy.startAnimation(animation1);
        lrlDaDVatLy.startAnimation(animation1);
        settingFastVatLy.startAnimation(animation1);



        //Khởi tạo dữ liệu
        sqlOpenHelper  = new SqlOpenHelper(VatlyActivity.this);
        cauHoiList= new ArrayList<>();
        sqlOpenHelper.createDataBase();

        cauHoiList= sqlOpenHelper.getAllCauHoi();
//Khởi tạo vị trí lấy câu hỏi.
        random= new Random();
        Scores=0;
        position=random.nextInt(450);

        builder = new AlertDialog.Builder(VatlyActivity.this, R.style.DialogCustomTheme);

        tvQuetionVatLy.setText(cauHoiList.get(position).getCauHoi());
        tvTlAVatLy.setText(cauHoiList.get(position).getDapAnA());
        tvtlBVatLy.setText(cauHoiList.get(position).getDapAnB());
        tvTlCVatLy.setText(cauHoiList.get(position).getDapAnC());
        tvTlDVatLy.setText(cauHoiList.get(position).getDapAnD());

        clock();

    }

    public void clock() {
        giayClock = 90;
        countDownTimer = new CountDownTimer(giayClock * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                giayClock--;
                tvTimecoutVatLy.setText(giayClock + "");
            }

            @Override
            public void onFinish() {
                //hết giờ chơi

                View view1 = LayoutInflater.from(VatlyActivity.this).inflate(R.layout.dialog_hetgio, null);
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
        tvQuetionVatLy.setText(cauHoiList.get(position).getCauHoi());
        tvTlAVatLy.setText(cauHoiList.get(position).getDapAnA());
        tvtlBVatLy.setText(cauHoiList.get(position).getDapAnB());
        tvTlCVatLy.setText(cauHoiList.get(position).getDapAnC());
        tvTlDVatLy.setText(cauHoiList.get(position).getDapAnD());
    }


    public void settingFast(View view) {
        AlertDialog.Builder builder= new AlertDialog.Builder(VatlyActivity.this);
        View dialog= LayoutInflater.from(VatlyActivity.this).inflate(R.layout.dialog_setting, null, false);

        builder.setView(dialog);
        builder.create();
        builder.show();
    }

    public void amThanhTraLoiDung(){
        MediaPlayer mediaPlayer= MediaPlayer.create(VatlyActivity.this, R.raw.dung);
        mediaPlayer.start();
    }

    public void amThanhsai(){
        MediaPlayer mediaPlayer= MediaPlayer.create(VatlyActivity.this, R.raw.sai);
        mediaPlayer.start();
    }

    public void trangthaiKhongDuocChon(){
        lrlDaDVatLy.setClickable(false);
        lrlDaAVatly.setClickable(false);
        lrlDaBVatLy.setClickable(false);
        lrlDaCVatLy.setClickable(false);
    }

    public void cauTiepTheo(View view) {
        chuyenCau();
    }

    public void clickAVatLy(View view) {
        if (tvDaAVatLy.getText().toString().trim().equals(cauHoiList.get(position).getDapAnDung())){
            amThanhTraLoiDung();
            Scores+=1;
            tvdiemfasVatLy.setText(Scores+"");
            if (Scores==10){
                View view1 = LayoutInflater.from(VatlyActivity.this).inflate(R.layout.dialog_victory, null);
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
                        startActivity(new Intent(VatlyActivity.this,HomeActivity.class));
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
            View view1 = LayoutInflater.from(VatlyActivity.this).inflate(R.layout.dialog_hetgio, null);
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
                    startActivity(new Intent(VatlyActivity.this,HomeActivity.class));
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

    public void clickBVatLy(View view) {
        if (tvDaBVatLy.getText().toString().trim().equals(cauHoiList.get(position).getDapAnDung())){
            amThanhTraLoiDung();
            Scores+=1;
            tvdiemfasVatLy.setText(Scores+"");
            if (Scores==10){
                View view1 = LayoutInflater.from(VatlyActivity.this).inflate(R.layout.dialog_victory, null);
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
                        startActivity(new Intent(VatlyActivity.this,HomeActivity.class));
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
            View view1 = LayoutInflater.from(VatlyActivity.this).inflate(R.layout.dialog_hetgio, null);
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
                    startActivity(new Intent(VatlyActivity.this,HomeActivity.class));
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

    public void clickCVatLy(View view) {
        if (tvDaCVatLy.getText().toString().trim().equals(cauHoiList.get(position).getDapAnDung())){
            amThanhTraLoiDung();
            Scores+=1;
            tvdiemfasVatLy.setText(Scores+"");
            if (Scores==10){
                View view1 = LayoutInflater.from(VatlyActivity.this).inflate(R.layout.dialog_victory, null);
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
                        startActivity(new Intent(VatlyActivity.this,HomeActivity.class));
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
            View view1 = LayoutInflater.from(VatlyActivity.this).inflate(R.layout.dialog_hetgio, null);
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
                    startActivity(new Intent(VatlyActivity.this,HomeActivity.class));
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

    public void clickDVatLy(View view) {
        if (tvDaDVatLy.getText().toString().trim().equals(cauHoiList.get(position).getDapAnDung())){
            amThanhTraLoiDung();
            Scores+=1;
            tvdiemfasVatLy.setText(Scores+"");
            if (Scores==10){
                View view1 = LayoutInflater.from(VatlyActivity.this).inflate(R.layout.dialog_victory, null);
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
                        startActivity(new Intent(VatlyActivity.this,HomeActivity.class));
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
            View view1 = LayoutInflater.from(VatlyActivity.this).inflate(R.layout.dialog_hetgio, null);
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
                    startActivity(new Intent(VatlyActivity.this,HomeActivity.class));
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

    public void cauTiepTheoVatLy(View view) {
    }
}
