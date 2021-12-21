package com.yola.uasyola.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.yola.uasyola.R;
import com.yola.uasyola.helper.DBHandler;

public class HomeScrActivity extends AppCompatActivity {
    private Button button_tambahdata;
    private Button button_lihatdata;
    private Button button_hapusdata;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_scr);
        dbHandler = new DBHandler(HomeScrActivity.this);
        initComponents();
    }

    private void initComponents(){
        button_tambahdata = (Button) findViewById(R.id.button_tambahdata);
        button_lihatdata = (Button) findViewById(R.id.button_lihatdata);
        button_hapusdata = (Button) findViewById(R.id.button_hapusdata);

        button_tambahdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeScrActivity.this, TambahJurusanActivity.class));
            }
        });

        button_lihatdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeScrActivity.this, LihatJurusanActivity.class));
            }
        });

        button_hapusdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHandler.hapusSemuaDataJurusan();
                Toast.makeText(HomeScrActivity.this, "Berhasil Menghapus Semua Data Jurusan", Toast.LENGTH_SHORT).show();
            }
        });
    }
}