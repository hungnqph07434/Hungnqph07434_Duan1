package com.poly.hungnqph07434_duan1.activity;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;

import com.poly.hungnqph07434_duan1.R;


public class FastPlayFragment extends Fragment {
private SwitchCompat switchCompatMusic;
private SwitchCompat switchCompatTime;
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
        switchCompatMusic= dialog.findViewById(R.id.swcMusic);
        switchCompatMusic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                MediaPlayer mediaPlayer= MediaPlayer.create(getActivity(),R.raw.nhacnen);

                if (switchCompatMusic.isChecked()) {
                    mediaPlayer.start();
                } else {
                    mediaPlayer.stop();
                }

            }
        });
        builder.setView(dialog);
        builder.create();
        builder.show();
    }
});
        return view;
    }


}
