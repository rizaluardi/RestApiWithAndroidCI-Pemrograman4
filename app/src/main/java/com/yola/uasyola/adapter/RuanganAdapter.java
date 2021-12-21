package com.yola.uasyola.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yola.uasyola.R;
import com.yola.uasyola.activityweb.EditActivityRuangan;
import com.yola.uasyola.model.Ruangan;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class RuanganAdapter extends
        RecyclerView.Adapter<RuanganAdapter.MyViewHolderRuangan> {
    List<Ruangan> mRuanganList;

    public RuanganAdapter(List<Ruangan> RuanganList) {
        mRuanganList = RuanganList;
    }

    @Override
    public MyViewHolderRuangan onCreateViewHolder(ViewGroup parent, int
            viewType) {
        View mViewInstnansi = LayoutInflater.from(parent.getContext()).inflate(R.layout.ruangan_list, parent, false);
        MyViewHolderRuangan mViewHolderRuangan = new MyViewHolderRuangan(mViewInstnansi);
        return mViewHolderRuangan;
    }

    @Override
    public void onBindViewHolder(MyViewHolderRuangan holder, final int
            position) {
        holder.mTextViewIdRuangan.setText("Id = " + mRuanganList.get(position).getId_ruangan());
        holder.mTextViewRuangan.setText("Ruangan = " + mRuanganList.get(position).getRuangan());
        holder.mTextViewNomor.setText("Nomor = " + mRuanganList.get(position).getNomor());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntentRuangan = new Intent(view.getContext(), EditActivityRuangan.class);
                mIntentRuangan.putExtra("IdRuangan", mRuanganList.get(position).getId_ruangan());
                mIntentRuangan.putExtra("Ruangan", mRuanganList.get(position).getRuangan());
                mIntentRuangan.putExtra("Nomor", mRuanganList.get(position).getNomor());
                view.getContext().startActivity(mIntentRuangan);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mRuanganList.size();
    }

    public class MyViewHolderRuangan extends RecyclerView.ViewHolder {
        public TextView mTextViewIdRuangan, mTextViewRuangan, mTextViewNomor;

        public MyViewHolderRuangan(View itemView) {
            super(itemView);
            mTextViewIdRuangan = (TextView) itemView.findViewById(R.id.tvIdRuangan);
            mTextViewRuangan = (TextView)
                    itemView.findViewById(R.id.tvRuangan);
            mTextViewNomor = (TextView)
                    itemView.findViewById(R.id.tvNomorg);
        }
    }
}