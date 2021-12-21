package com.yola.uasyola;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.yola.uasyola.activity.HomeScrActivity;

public class crud extends Fragment {

    Button web,sqlite,updown;

    private static final String TAG = "crud";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crud, container, false);

        sqlite = (Button)view.findViewById(R.id.menuju_sqlite);
        sqlite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cv = new Intent(getActivity(), HomeScrActivity.class);
                //berfunngsi untuk melakukan eksekusi dari parameter explicit ke activity berikutnya
                startActivity(cv);
            }
        });

        web = (Button)view.findViewById(R.id.menuju_webserver);
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cv = new Intent(getActivity(), HomeWebActivity.class);
                //berfunngsi untuk melakukan eksekusi dari parameter explicit ke activity berikutnya
                startActivity(cv);
            }
        });
        updown = (Button)view.findViewById(R.id.menuju_downup);
        updown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cv = new Intent(getActivity(), DownloadUpload.class);
                //berfunngsi untuk melakukan eksekusi dari parameter explicit ke activity berikutnya
                startActivity(cv);
            }
        });

        return view;
    }
}