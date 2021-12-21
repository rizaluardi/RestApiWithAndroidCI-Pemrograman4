package com.yola.uasyola.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.yola.uasyola.R;
import com.yola.uasyola.adapter.JurusanAdapter;
import com.yola.uasyola.helper.DBHandler;
import com.yola.uasyola.helper.RecyclerItemClickListener;
import com.yola.uasyola.model.Jurusan;

import java.util.ArrayList;
import java.util.List;

public class LihatJurusanActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private JurusanAdapter adapter;
    private DBHandler dbHandler;
    private TextView txt_resultadapter;
    private List<Jurusan> jurusanList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_jurusan);
        initComponents();
        initRecyclerView();
        cekDataRecyclerView();
    }
    // FUNGSI INI UNTUK MENG-INIT RECYLERVIEW BESERTA ADAPTERNYA
    private void initRecyclerView(){
        recyclerView = (RecyclerView) findViewById(R.id.rv_jurusan);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        dbHandler = new DBHandler(LihatJurusanActivity.this);
        jurusanList = dbHandler.getSemuaJurusan();
        adapter = new JurusanAdapter(jurusanList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void initComponents(){
        txt_resultadapter = (TextView) findViewById(R.id.txt_resultadapter);
    }

    // FUNGSI INI UNTUK MENGECEK APAKAH ADA DATA DI DALEM RECYCLERVIEW ATAU TIDAK
    private void cekDataRecyclerView(){
        if (adapter.getItemCount() == 0){
            txt_resultadapter.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        } else {
            txt_resultadapter.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);

            recyclerView.addOnItemTouchListener(
                    new RecyclerItemClickListener(getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
                        @Override public void onItemClick(View view, int position) {
                            // TODO Handle item click
                            Jurusan jrs = jurusanList.get(position);
                            String jurusan = jrs.getJurusan();

                            Toast.makeText(LihatJurusanActivity.this, "Klik di " + jurusan, Toast.LENGTH_SHORT).show();
                        }
                    })
            );
        }
    }
}