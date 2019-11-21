package com.poly.hungnqph07434_duan1.activity;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.poly.hungnqph07434_duan1.R;


public class SuperIntegeceFragment extends Fragment {

private ImageView setting_super;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_super_integece, container, false);
        setting_super=view.findViewById(R.id.setting_super);
        setting_super.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder= new AlertDialog.Builder(getActivity());
                View dialog= LayoutInflater.from(getActivity()).inflate(R.layout.dialog_setting, null, false);
                builder.setView(dialog);
                builder.create();
                builder.show();
            }
        });
        return view;
    }


}
