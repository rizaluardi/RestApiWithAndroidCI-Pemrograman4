package com.yola.uasyola.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.yola.uasyola.R;
import com.yola.uasyola.adapter.JurusanAdapter;
import com.yola.uasyola.helper.DBHandler;
import com.yola.uasyola.model.Jurusan;

import java.util.List;

public class TambahJurusanActivity extends AppCompatActivity {
    private EditText et_jurusan;
    private EditText et_jenjang;
    private Button button_tambahdata;

    private DBHandler dbHandler;
    private JurusanAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_jurusan);
        dbHandler = new DBHandler(this);
        initComponents();
    }

    private void initComponents(){
        et_jurusan = (EditText) findViewById(R.id.et_jurusan);
        et_jenjang = (EditText) findViewById(R.id.et_jenjang);
        button_tambahdata = (Button) findViewById(R.id.button_tambahdata);

        button_tambahdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validasiForm();
            }
        });
    }

    // FUNGSI INI UNTUK MEMVALIDASI FORM JIKA ADA YANG KOSONG ATAU TIDAK
    // LALU DILANJUT UNTUK MENJALANKAN PERINTAH SELANJUTNYA
    private void validasiForm(){
        String form_jurusan = et_jurusan.getText().toString();
        String form_jenjang = et_jenjang.getText().toString();

        if (form_jurusan.isEmpty()){
            et_jurusan.setError("Isi jurusan dulu");
            et_jurusan.requestFocus();
        } if (form_jenjang.isEmpty()){
            et_jenjang.setError("Isi jenjang dulu");
            et_jenjang.requestFocus();
        } else {
            dbHandler.tambahJurusan(new Jurusan(form_jurusan, form_jenjang));
            List<Jurusan> jurusanList = dbHandler.getSemuaJurusan();
            adapter = new JurusanAdapter(jurusanList);
            adapter.notifyDataSetChanged();

            Toast.makeText(TambahJurusanActivity.this, "Berhasil Menambahkan Data", Toast.LENGTH_SHORT).show();
        }
    }
}