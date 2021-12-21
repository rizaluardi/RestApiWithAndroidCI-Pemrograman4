package com.yola.uasyola.activityweb;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.yola.uasyola.R;
import com.yola.uasyola.model.PostPutDelRuangan;
import com.yola.uasyola.rest.ApiClient;
import com.yola.uasyola.rest.ApiInterfaceRuangan;

public class EditActivityRuangan extends AppCompatActivity {


    EditText edtId_ruangan, edtRuangan, edtNomor;
    Button btUpdateRuangan, btDeleteRuangan, btBackRuangan;
    ApiInterfaceRuangan mApiInterfaceRuangan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_ruangan);
        edtId_ruangan = (EditText) findViewById(R.id.edtIdRuangan);
        edtRuangan = (EditText) findViewById(R.id.edtRuangan);
        edtNomor = (EditText) findViewById(R.id.edtNomorg);

        Intent mIntentRuangan = getIntent();
        edtId_ruangan.setText(mIntentRuangan.getStringExtra("Id_ruangan"));
        edtId_ruangan.setTag(edtId_ruangan.getKeyListener());
        edtId_ruangan.setKeyListener(null);
        edtRuangan.setText(mIntentRuangan.getStringExtra("Ruangan"));
        edtNomor.setText(mIntentRuangan.getStringExtra("Nomor"));
        mApiInterfaceRuangan = ApiClient.getClient().create(ApiInterfaceRuangan.class);

        btUpdateRuangan = (Button) findViewById(R.id.btUpdateRuangann2);
        btUpdateRuangan.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Call<PostPutDelRuangan> updateRuanganCall = mApiInterfaceRuangan.putRuangan(
                        edtId_ruangan.getText().toString(),
                        edtRuangan.getText().toString(),
                        edtNomor.getText().toString());
                updateRuanganCall.enqueue(new Callback<PostPutDelRuangan>(){
                    @Override
                    public void onResponse(Call<PostPutDelRuangan> call, Response<PostPutDelRuangan> response) {
                        MainActivityRuangan.mar.refresh();
                        finish();
                    }
                    @Override
                    public void onFailure(Call<PostPutDelRuangan> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),
                                "Error", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        btDeleteRuangan = (Button) findViewById(R.id.btDeleteRuangann2);
        btDeleteRuangan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtId_ruangan.getText().toString().trim().isEmpty()==false){
                    Call<PostPutDelRuangan> deleteRuangan = mApiInterfaceRuangan.deleteRuangan(edtId_ruangan.getText().toString());
                    deleteRuangan.enqueue(new Callback<PostPutDelRuangan>() {
                        @Override
                        public void onResponse(Call<PostPutDelRuangan>call, Response<PostPutDelRuangan> response) {
                            MainActivityRuangan.mar.refresh();
                            finish();
                        }
                        @Override
                        public void onFailure(Call<PostPutDelRuangan> call, Throwable t) {
                            Toast.makeText(getApplicationContext(),"Error", Toast.LENGTH_LONG).show();
                        }
                    });
                }else{
                    Toast.makeText(getApplicationContext(), "Error",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
        btBackRuangan = (Button) findViewById(R.id.btBackGoRuangann);
        btBackRuangan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityRuangan.mar.refresh();
                finish();
            }
        });
    }
}