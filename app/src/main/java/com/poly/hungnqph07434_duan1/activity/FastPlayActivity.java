package com.poly.hungnqph07434_duan1.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;

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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.poly.hungnqph07434_duan1.model.CauHoi;
import com.poly.hungnqph07434_duan1.R;
import com.poly.hungnqph07434_duan1.datasql.SqlOpenHelper;
import com.poly.hungnqph07434_duan1.model.NguoiChoi;
import com.poly.hungnqph07434_duan1.modelview.QuizView;
import com.poly.hungnqph07434_duan1.presenter.QuizPresenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FastPlayActivity extends AppCompatActivity implements QuizView {
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
    private Button btnChoiLai, btnLuuNguoiChoi;
    private Button btnCancleHome;
    private EditText edtNguoiChoi;

    private TextView tvDiemthang;
    private Button btnChoiTiep;
    private Button btnCancleHomeVictory;


    private AlertDialog alertDialog;


    private LinearLayout lrlDaD;
    private TextView tvTlD;
    private ImageView imgsettingFast;
    private SqlOpenHelper sqlOpenHelper;
    private List<CauHoi> cauHoiList;
    private List<NguoiChoi> nguoiChois;

    private int position;

private Random random;

    private QuizPresenter quizPresenter;




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
//        imgsettingFast = (ImageView) findViewById(R.id.setting_fast);
//Gắn điểm bằng 0;

        nguoiChois= new ArrayList<>();
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
//        imgsettingFast.startAnimation(animation1);

        //Khởi tạo dữ liệu
        sqlOpenHelper  = new SqlOpenHelper(FastPlayActivity.this);
        cauHoiList= new ArrayList<>();
        sqlOpenHelper.createDataBase();

        cauHoiList= sqlOpenHelper.getAllCauHoi();
//Khởi tạo vị trí lấy câu hỏi.
        random= new Random();
        Scores=0;
        position=random.nextInt(200);

        builder = new AlertDialog.Builder(FastPlayActivity.this, R.style.DialogCustomTheme);



//Gắn câu hỏi và câu trả lời lên.
tvQuetion.setText(cauHoiList.get(position).getCauHoi());
tvTlA.setText(cauHoiList.get(position).getDapAnA());
tvtlB.setText(cauHoiList.get(position).getDapAnB());
tvTlC.setText(cauHoiList.get(position).getDapAnC());
tvTlD.setText(cauHoiList.get(position).getDapAnD());

        quizPresenter= new QuizPresenter(this);






        //TimeStart
        chuyencau();
        time();



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
               // tvDiemend.setText(Scores+"");
                builder.setView(view1);
                builder.create();
                alertDialog=builder.show();
//                Button btnNoDialog;
//                Button btnYesDialog;

            }
        };
        countDownTimer.start();
    }






public void chuyenCau(){
        int sobatky;
        sobatky=random.nextInt(3);
        if (position>=490){
            position=random.nextInt(200);
        }
        else {
            position+=1;
            tvQuetion.setText(cauHoiList.get(position).getCauHoi());
            tvTlA.setText(cauHoiList.get(position).getDapAnA());
            tvtlB.setText(cauHoiList.get(position).getDapAnB());
            tvTlC.setText(cauHoiList.get(position).getDapAnC());
            tvTlD.setText(cauHoiList.get(position).getDapAnD());
        }

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
        quizPresenter.clickDapAn(tvDaA.getText().toString().trim(),cauHoiList.get(position).getDapAnDung());
    }

    public void clickB(View view) {
        quizPresenter.clickDapAn(tvDaB.getText().toString().trim(),cauHoiList.get(position).getDapAnDung());
    }

    public void clickC(View view) {
        quizPresenter.clickDapAn(tvDaC.getText().toString().trim(),cauHoiList.get(position).getDapAnDung());
    }

    public void clickD(View view) {
        quizPresenter.clickDapAn(tvDaD.getText().toString().trim(),cauHoiList.get(position).getDapAnDung());

    }

    public void quayLaiManHome(){
        startActivity(new Intent(FastPlayActivity.this,HomeActivity.class));
        finish();
    }

    @Override
    public void time() {
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
//                Button btnNoDialog;
//                Button btnYesDialog;

            }
        };
        countDownTimer.start();
    }

    @Override
    public void chuyencau() {
        int sobatky=1;
        sobatky=random.nextInt(10);
        position+=2;
        tvQuetion.setText(cauHoiList.get(position).getCauHoi());
        tvTlA.setText(cauHoiList.get(position).getDapAnA());
        tvtlB.setText(cauHoiList.get(position).getDapAnB());
        tvTlC.setText(cauHoiList.get(position).getDapAnC());
        tvTlD.setText(cauHoiList.get(position).getDapAnD());
    }

    @Override
    public void tinhDiem() {

        if (Scores < 10) {
            Scores++;
            tvdiemfas.setText(Scores + "");
        } else {
            View view1 = LayoutInflater.from(FastPlayActivity.this).inflate(R.layout.dialog_victory, null);
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
                    startActivity(new Intent(FastPlayActivity.this, HomeActivity.class));
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
        MediaPlayer mediaPlayer= MediaPlayer.create(FastPlayActivity.this, R.raw.dung);
        mediaPlayer.start();
    }

    @Override
    public void amThanhSai() {
        MediaPlayer mediaPlayer= MediaPlayer.create(FastPlayActivity.this, R.raw.sai);
        mediaPlayer.start();
    }

    @Override
    public void showKetQua() {

    }

    @Override
    public void timeStop() {

        countDownTimer.cancel();

    }

    @Override
    public void showDialogthua() {

        View view1 = LayoutInflater.from(FastPlayActivity.this).inflate(R.layout.dialog_hetgio, null);
        tvDiemend =  view1.findViewById(R.id.tvDiemend);
        btnChoiLai = view1.findViewById(R.id.btnChoiLai);
        edtNguoiChoi=view1.findViewById(R.id.edtTenNguoiChoi);
        btnLuuNguoiChoi=view1.findViewById(R.id.btnLuuDiem);
        btnLuuNguoiChoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtNguoiChoi.getText().toString().equals("")){
                    Toast.makeText(FastPlayActivity.this, "Bạn chua nhập tên!", Toast.LENGTH_SHORT).show();
                }
                else {
                    long kq=sqlOpenHelper.insertUser(new NguoiChoi(edtNguoiChoi.getText().toString(),Scores));
                    if (kq>0){
                        Toast.makeText(FastPlayActivity.this, "Thêm Thành Công", Toast.LENGTH_SHORT).show();
                        quayLaiManHome();
                        alertDialog.dismiss();
                    }
                    else {
                        Toast.makeText(FastPlayActivity.this, "Tên đã tồn tại! Hãy thử với một tên khác! ", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });
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
        alertDialog=builder.show();

    }

    @Override
    public void trangThaiChonTat() {
        lrlDaD.setClickable(false);
        lrlDaA.setClickable(false);
        lrlDaB.setClickable(false);
        lrlDaC.setClickable(false);
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
