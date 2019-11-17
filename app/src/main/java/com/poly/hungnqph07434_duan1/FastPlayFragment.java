package com.poly.hungnqph07434_duan1;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class FastPlayFragment extends Fragment {

private ImageView  setting_fast;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_fast_play, container, false);
setting_fast=view.findViewById(R.id.setting_fast);
setting_fast.setOnClickListener(new View.OnClickListener() {
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
