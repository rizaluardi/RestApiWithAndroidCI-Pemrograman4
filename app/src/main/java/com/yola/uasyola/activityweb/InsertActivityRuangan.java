package com.yola.uasyola.activityweb;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.yola.uasyola.R;
import com.yola.uasyola.model.PostPutDelRuangan;
import com.yola.uasyola.rest.ApiClient;
import com.yola.uasyola.rest.ApiInterfaceRuangan;

public class InsertActivityRuangan extends AppCompatActivity {

    EditText edtRuangan, edtNomor;
    Button btInsertRuangan, btBackRuangan;
    ApiInterfaceRuangan mApiInterfaceRuangan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_ruangan);
        edtRuangan = (EditText) findViewById(R.id.edtRuangan);
        edtNomor = (EditText) findViewById(R.id.edtNomorg);
        mApiInterfaceRuangan = ApiClient.getClient().create(ApiInterfaceRuangan.class);
        btInsertRuangan = (Button) findViewById(R.id.btInsertingRuangan);
        btInsertRuangan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDelRuangan> postRuanganCall =
                        mApiInterfaceRuangan.postRuangan(edtRuangan.getText().toString(),
                                edtNomor.getText().toString());
                postRuanganCall.enqueue(new Callback<PostPutDelRuangan>()
                {
                    @Override
                    public void onResponse(Call<PostPutDelRuangan> call,
                                           Response<PostPutDelRuangan> response) {
                        MainActivityRuangan.mar.refresh();
                        finish();
                    }
                    @Override
                    public void onFailure(Call<PostPutDelRuangan> call,
                                          Throwable t) {
                        Toast.makeText(getApplicationContext(),
                                "Error", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        btBackRuangan = (Button) findViewById(R.id.btBackGoRuangan);
        btBackRuangan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityRuangan.mar.refresh();
                finish();
            }
        });
    }
}
