package com.poly.hungnqph07434_duan1.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.poly.hungnqph07434_duan1.NguoiChoiAdapter;
import com.poly.hungnqph07434_duan1.R;
import com.poly.hungnqph07434_duan1.datasql.SqlOpenHelper;
import com.poly.hungnqph07434_duan1.model.NguoiChoi;

import java.util.ArrayList;
import java.util.List;

public class TopActivity extends AppCompatActivity {

    private RecyclerView rcvTop;
    private SqlOpenHelper sqlOpenHelper;
    private List<NguoiChoi> nguoiChois;
    private NguoiChoiAdapter nguoiChoiAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);
        rcvTop = (RecyclerView) findViewById(R.id.rcvTop);

        sqlOpenHelper= new SqlOpenHelper(this);
        nguoiChois= new ArrayList<>();
        sqlOpenHelper.createDataBase();

       nguoiChois= sqlOpenHelper.getAllNguoiChoi();

        nguoiChoiAdapter= new NguoiChoiAdapter(TopActivity.this, nguoiChois);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(TopActivity.this);
        rcvTop.setLayoutManager(linearLayoutManager);
        rcvTop.setAdapter(nguoiChoiAdapter);


    }
}
