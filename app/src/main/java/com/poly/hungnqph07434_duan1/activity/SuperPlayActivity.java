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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.poly.hungnqph07434_duan1.R;
import com.poly.hungnqph07434_duan1.datasql.SqlOpenHelper;
import com.poly.hungnqph07434_duan1.model.CauHoi;
import com.poly.hungnqph07434_duan1.model.NguoiChoi;
import com.poly.hungnqph07434_duan1.modelview.QuizView;
import com.poly.hungnqph07434_duan1.presenter.QuizPresenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SuperPlayActivity extends AppCompatActivity implements QuizView {
    private ConstraintLayout timeSinh;
    private TextView textView;
    private TextView tvdiemSinh;
    private TextView tvTimecoutSinh;
    private TextView tvQuetionSinh;
    private LinearLayout lrlDaASinh;
    private TextView tvDaASinh;
    private TextView tvTlASinh;
    private LinearLayout lrlDaBSinh;
    private TextView tvDaBSinh;
    private TextView tvtlBSinh;
    private LinearLayout lrlDaCSinh;
    private TextView tvDaCSinh;
    private TextView tvTlCSinh;
    private LinearLayout lrlDaDSinh;
    private TextView tvDaDSinh;
    private TextView tvTlDSinh;
    private Button btnNextQueSinh,  btnLuuNguoiChoi;
    private ImageView settingFastSinh;


    private int position;

    private Random random;
    private int Scores;
    private AlertDialog.Builder builder;

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

    private QuizPresenter quizPresenter;

    private EditText edtNguoiChoi;

    private AlertDialog alertDialog;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_super_play);

        //Ánh xạ thành phần
        timeSinh = (ConstraintLayout) findViewById(R.id.timeSinh);
        textView = (TextView) findViewById(R.id.textView);
        tvdiemSinh = (TextView) findViewById(R.id.tvdiemSinh);
        tvTimecoutSinh = (TextView) findViewById(R.id.tvTimecoutSinh);
        tvQuetionSinh = (TextView) findViewById(R.id.tvQuetionSinh);
        lrlDaASinh = (LinearLayout) findViewById(R.id.lrlDaASinh);
        tvDaASinh = (TextView) findViewById(R.id.tvDaASinh);
        tvTlASinh = (TextView) findViewById(R.id.tvTlASinh);
        lrlDaBSinh = (LinearLayout) findViewById(R.id.lrlDaBSinh);
        tvDaBSinh = (TextView) findViewById(R.id.tvDaBSinh);
        tvtlBSinh = (TextView) findViewById(R.id.tvtlBSinh);
        lrlDaCSinh = (LinearLayout) findViewById(R.id.lrlDaCSinh);
        tvDaCSinh = (TextView) findViewById(R.id.tvDaCSinh);
        tvTlCSinh = (TextView) findViewById(R.id.tvTlCSinh);
        lrlDaDSinh = (LinearLayout) findViewById(R.id.lrlDaDSinh);
        tvDaDSinh = (TextView) findViewById(R.id.tvDaDSinh);
        tvTlDSinh = (TextView) findViewById(R.id.tvTlDSinh);
        btnNextQueSinh = (Button) findViewById(R.id.btnNextQueSinh);
//        settingFastSinh = (ImageView) findViewById(R.id.setting_fastSinh);

        quizPresenter= new QuizPresenter(this);

        //Gắn điểm bằng 0;
        Scores=0;
        //Hiệu ứng
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.an_right);
        animation.setInterpolator(new LinearInterpolator());
        timeSinh.startAnimation(animation);
        lrlDaASinh.startAnimation(animation);
        lrlDaCSinh.startAnimation(animation);
        btnNextQueSinh.startAnimation(animation);

        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.an_left);
        animation1.setInterpolator(new LinearInterpolator());
        tvQuetionSinh.startAnimation(animation1);
        lrlDaBSinh.startAnimation(animation1);
        lrlDaDSinh.startAnimation(animation1);
//        settingFastSinh.startAnimation(animation1);



        //Khởi tạo dữ liệu
        sqlOpenHelper  = new SqlOpenHelper(SuperPlayActivity.this);
        cauHoiList= new ArrayList<>();
        sqlOpenHelper.createDataBase();

        cauHoiList= sqlOpenHelper.getAllCauHoi();
//Khởi tạo vị trí lấy câu hỏi.
        random= new Random();
        Scores=0;
        position=random.nextInt(450);

        builder = new AlertDialog.Builder(SuperPlayActivity.this, R.style.DialogCustomTheme);

//        tvQuetionSinh.setText(cauHoiList.get(position).getCauHoi());
//        tvTlASinh.setText(cauHoiList.get(position).getDapAnA());
//        tvtlBSinh.setText(cauHoiList.get(position).getDapAnB());
//        tvTlCSinh.setText(cauHoiList.get(position).getDapAnC());
//        tvTlDSinh.setText(cauHoiList.get(position).getDapAnD());

        chuyencau();
        time();



    }


    public void clickA(View view) {
        quizPresenter.clickDapAn(tvDaASinh.getText().toString().trim(),cauHoiList.get(position).getDapAnDung());
    }

    public void clickB(View view) {
        quizPresenter.clickDapAn(tvDaBSinh.getText().toString().trim(),cauHoiList.get(position).getDapAnDung());
    }

    public void clickC(View view) {
        quizPresenter.clickDapAn(tvDaCSinh.getText().toString().trim(),cauHoiList.get(position).getDapAnDung());
    }

    public void clickD(View view) {
        quizPresenter.clickDapAn(tvDaDSinh.getText().toString().trim(),cauHoiList.get(position).getDapAnDung());
    }

    public void cauTiepTheo(View view) {
        MediaPlayer mediaPlayer= MediaPlayer.create(SuperPlayActivity.this, R.raw.nutan);
        mediaPlayer.start();
        chuyencau();
    }

    public void settingFast(View view) {
    }

    @Override
    public void time() {
        giayClock = 90;
        countDownTimer = new CountDownTimer(giayClock * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                giayClock--;
                tvTimecoutSinh.setText(giayClock + "");
            }

            @Override
            public void onFinish() {
                //hết giờ chơi
                View view1 = LayoutInflater.from(SuperPlayActivity.this).inflate(R.layout.dialog_hetgio, null);
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
                        startActivity(new Intent(SuperPlayActivity.this,HomeActivity.class));
                        finish();

                    }
                });
                builder.setView(view1);
                builder.create();
                builder.show();
//                Button btnNoDialog;
//                Button btnYesDialog;

            }
        };
        countDownTimer.start();
    }

    @Override
    public void chuyencau() {

        position=random.nextInt(400);
        tvQuetionSinh.setText(cauHoiList.get(position).getCauHoi());
        tvTlASinh.setText(cauHoiList.get(position).getDapAnA());
        tvtlBSinh.setText(cauHoiList.get(position).getDapAnB());
        tvTlCSinh.setText(cauHoiList.get(position).getDapAnC());
        tvTlDSinh.setText(cauHoiList.get(position).getDapAnD());
    }

    @Override
    public void tinhDiem() {

        if (Scores < 100) {
            Scores+=10;
            tvdiemSinh.setText(Scores + "");
        } else {
            View view1 = LayoutInflater.from(SuperPlayActivity.this).inflate(R.layout.dialog_victory, null);
            tvDiemthang = (TextView) view1.findViewById(R.id.tvDiemthang);
            btnChoiTiep = (Button) view1.findViewById(R.id.btnChoiTiep);
            btnCancleHomeVictory = (Button) view1.findViewById(R.id.btnCancleHomeVictory);
            tvDiemthang.setText(Scores + "");
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
                    startActivity(new Intent(SuperPlayActivity.this, HomeActivity.class));
                    finish();

                }
            });
            builder.setView(view1);
            builder.create();
            builder.show();

//        if (Scores==10){
//            View view1 = LayoutInflater.from(SinhActivity.this).inflate(R.layout.dialog_victory, null);
//            tvDiemthang = (TextView) view1.findViewById(R.id.tvDiemthang);
//            btnChoiTiep = (Button) view1.findViewById(R.id.btnChoiTiep);
//            btnCancleHomeVictory = (Button) view1.findViewById(R.id.btnCancleHomeVictory);
//            tvDiemthang.setText(Scores+"");
//            btnChoiTiep.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    finish();
//                    overridePendingTransition(0, 0);
//                    startActivity(getIntent());
//                    overridePendingTransition(0, 0);
//                }
//            });
//            btnCancleHomeVictory.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    startActivity(new Intent(SinhActivity.this,HomeActivity.class));
//                    finish();
//
//                }
//            });
//            builder.setView(view1);
//            builder.create();
//            builder.show();
//        }
//       else
//            Scores++;
//            tvdiemSinh.setText(Scores+"");

        }

    }

    @Override
    public void amThanhDung() {
        MediaPlayer mediaPlayer= MediaPlayer.create(SuperPlayActivity.this, R.raw.dung);
        mediaPlayer.start();
    }

    @Override
    public void amThanhSai() {
        MediaPlayer mediaPlayer= MediaPlayer.create(SuperPlayActivity.this, R.raw.sai);
        mediaPlayer.start();
    }

    @Override
    public void showKetQua() {

        View view1 = LayoutInflater.from(SuperPlayActivity.this).inflate(R.layout.dialog_hetgio, null);
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
                startActivity(new Intent(SuperPlayActivity.this,HomeActivity.class));
                finish();
            }
        });
        tvDiemend.setText(Scores+"");
        builder.setView(view1);
        builder.create();
        builder.show();

    }

    @Override
    public void timeStop() {
        countDownTimer.cancel();
    }

    @Override
    public void showDialogthua() {

        View view1 = LayoutInflater.from(SuperPlayActivity.this).inflate(R.layout.dialog_hetgio, null);
        tvDiemend =  view1.findViewById(R.id.tvDiemend);
        btnChoiLai = view1.findViewById(R.id.btnChoiLai);
        btnCancleHome =  view1.findViewById(R.id.btnCancleHome);
        edtNguoiChoi=view1.findViewById(R.id.edtTenNguoiChoi);
        btnLuuNguoiChoi=view1.findViewById(R.id.btnLuuDiem);
        btnLuuNguoiChoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtNguoiChoi.getText().toString().equals("")){
                    Toast.makeText(SuperPlayActivity.this, "Bạn chưa nhập tên", Toast.LENGTH_SHORT).show();
                }
                else {
                    long kq=sqlOpenHelper.insertUser(new NguoiChoi(edtNguoiChoi.getText().toString(),Scores+""));
                    if (kq>0){
                        Toast.makeText(SuperPlayActivity.this, "Thêm Thành Công", Toast.LENGTH_SHORT).show();

                        quayLaiManHome();
                        alertDialog.dismiss();
                    }
                    else {
                        Toast.makeText(SuperPlayActivity.this, "Tên đã tồn tại! Hãy thử với một tên khác! ", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });
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
                startActivity(new Intent(SuperPlayActivity.this,HomeActivity.class));
                finish();
            }
        });
        tvDiemend.setText(Scores+"");
        builder.setView(view1);
        builder.create();
        alertDialog=builder.show();

    }
    public void quayLaiManHome(){
        startActivity(new Intent(SuperPlayActivity.this,HomeActivity.class));
        finish();
    }
    @Override
    public void trangThaiChonTat() {
        lrlDaDSinh.setClickable(false);
        lrlDaASinh.setClickable(false);
        lrlDaBSinh.setClickable(false);
        lrlDaCSinh.setClickable(false);
    }

    @Override
    public void dapAnA() {

    }

    @Override
    public void dapAnB() {

    }

    @Override
    public void dapAnC() {

    }

    @Override
    public void dapAnD() {

    }
}
