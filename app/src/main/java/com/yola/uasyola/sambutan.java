package com.yola.uasyola;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class sambutan extends Fragment {

    private static final String TAG = "sambutan";
    private static final String LOGINS="login";
    Button logouts;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sambutan, container, false);
        logouts = view.findViewById(R.id.logouts);
        SharedPreferences lgot = this.getActivity().getSharedPreferences(LOGINS, Context.MODE_PRIVATE);

        logouts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor edits = lgot.edit();
                edits.clear();
                edits.commit();
                Toast.makeText(getActivity(), "logout berhasil", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getActivity(),LoginActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        return view;
    }
}