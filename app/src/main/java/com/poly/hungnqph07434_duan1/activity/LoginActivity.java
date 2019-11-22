package com.poly.hungnqph07434_duan1.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.poly.hungnqph07434_duan1.R;
import com.poly.hungnqph07434_duan1.datasql.SqlOpenHelper;
import com.poly.hungnqph07434_duan1.model.User;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
private Toolbar toolbar;
    private TextInputLayout tilUser;
    private TextInputLayout tilPass;

    private CheckBox rem_userpass;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    private ImageView imglogo;
    private LinearLayout lrlHello;
    private LinearLayout lrlUsername;
    private EditText edtUsername;
    private LinearLayout lrlPassword;
    private EditText edtPassword;
    private LinearLayout lrlSingin;
    private CheckBox checkBox;
    private LinearLayout comboLoginwith;
    private SqlOpenHelper sqlOpenHelper;
    private List<User> userList;
    private  String nameinput,passinput;
    private static final String PREF_NAME = "prefs";
    private static final String KEY_REMEMBER = "remember";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASS = "password";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        toolbar= findViewById(R.id.toolbarSignIn);
        setSupportActionBar(toolbar);


        imglogo = (ImageView) findViewById(R.id.imglogo);
        lrlHello = (LinearLayout) findViewById(R.id.lrlHello);
        lrlUsername = (LinearLayout) findViewById(R.id.lrlUsername);
        edtUsername = (EditText) findViewById(R.id.edtUsername);
        lrlPassword = (LinearLayout) findViewById(R.id.lrlPassword);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        lrlSingin = (LinearLayout) findViewById(R.id.lrlSingin);
        rem_userpass = (CheckBox)findViewById(R.id.rem_userpass);
        comboLoginwith = (LinearLayout) findViewById(R.id.comboLoginwith);
        tilUser = (TextInputLayout) findViewById(R.id.tilUser);
        tilPass = (TextInputLayout) findViewById(R.id.tilPass);




        Animation animation = AnimationUtils.loadAnimation(this, R.anim.an_iconlogo);
        animation.setInterpolator(new LinearInterpolator());
        imglogo.startAnimation(animation);

        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.an_right);
        animation1.setInterpolator(new LinearInterpolator());
        lrlHello.startAnimation(animation1);

        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.an_left);
        animation1.setInterpolator(new LinearInterpolator());
        lrlUsername.startAnimation(animation2);
        lrlPassword.startAnimation(animation2);
        lrlSingin.startAnimation(animation1);
        comboLoginwith.startAnimation(animation2);


        sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        if(sharedPreferences.getBoolean(KEY_REMEMBER, false))
            rem_userpass.setChecked(true);
        else
            rem_userpass.setChecked(false);

        edtUsername.setText(sharedPreferences.getString(KEY_USERNAME,""));
        edtPassword.setText(sharedPreferences.getString(KEY_PASS,""));



        rem_userpass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                managePrefs();
            }
        });




    userList=new ArrayList<>();

 sqlOpenHelper= new SqlOpenHelper(LoginActivity.this);
 sqlOpenHelper.createDataBase();
        userList=sqlOpenHelper.getAllUser();

        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setTitle("Login");
        Log.e("SizeUser",userList.size()+"");





    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    public void login(View view) {

        startActivity(new Intent(LoginActivity.this, HomeActivity.class));

//        edtUsername.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                nameinput=tilUser.getEditText().getText().toString().trim();
//                if (nameinput.isEmpty()){
//                    tilUser.setError("Không được để trống Name");
//                    edtUsername.requestFocus();
//                }
//                else if (nameinput.length()>50){
//                    tilUser.setError("Vượt quá");
//                    edtUsername.requestFocus();
//                }
//                else {
//                    tilUser.setError(null);
//
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//            }
//        });
//        edtPassword.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                passinput=tilPass.getEditText().getText().toString().trim();
//                if (passinput.isEmpty()){
//                    tilPass.setError("Không được để trống Pass");
//                    edtPassword.requestFocus();
//                }
//                else if (passinput.length()<5){
//                    tilPass.setError("Pass quá ngắn");
//                    edtPassword.requestFocus();
//                }
//                else  if (passinput.length()>50){
//                    tilPass.setError("Pass quá dài");
//                    edtPassword.requestFocus();
//                }
//                else {
//                    tilPass.setError(null);
//
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//            }
//        });
//
//
//        for(int i=0; i<userList.size(); i++){
//
//            if (!edtUsername.getText().toString().trim().equals(userList.get(i).getName())&& edtPassword.getText().toString().trim().equals(userList.get(i).getPassword())){
//                Toast.makeText(LoginActivity.this, "Sai Username ",Toast.LENGTH_SHORT).show();
//            }
//            else if (!edtPassword.getText().toString().trim().equals(userList.get(i).getPassword()) && edtUsername.getText().toString().trim().equals(userList.get(i).getName())){
//                Toast.makeText(LoginActivity.this, "Sai password ",Toast.LENGTH_SHORT).show();
//            }
//            else {
//                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
//                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
//                Toast.makeText(LoginActivity.this, "Welcome!! "+ edtUsername.getText().toString()+"",Toast.LENGTH_SHORT).show();
//                finish();
//            }
//        }

    }

    public void signUp(View view) {

        startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
    }

    private void managePrefs(){
        if(rem_userpass.isChecked()){
            editor.putString(KEY_USERNAME, edtUsername.getText().toString().trim());
            editor.putString(KEY_PASS, edtPassword.getText().toString().trim());
            editor.putBoolean(KEY_REMEMBER, true);
            editor.apply();
        }else{
            editor.putBoolean(KEY_REMEMBER, false);
            editor.remove(KEY_PASS);//editor.putString(KEY_PASS,"");
            editor.remove(KEY_USERNAME);//editor.putString(KEY_USERNAME, "");
            editor.apply();
        }
    }
}
