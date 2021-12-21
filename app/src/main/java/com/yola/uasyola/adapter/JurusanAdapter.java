package com.yola.uasyola.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.yola.uasyola.R;
import com.yola.uasyola.model.Jurusan;
import java.util.ArrayList;
import java.util.List;
import androidx.recyclerview.widget.RecyclerView;


public class JurusanAdapter extends RecyclerView.Adapter<JurusanAdapter.JurusanViewHolder> {
    private List<Jurusan> jurusanList = new ArrayList<>();
    public JurusanAdapter(List<Jurusan> jurusanList) {
        this.jurusanList = jurusanList;
    }

    @Override
    public JurusanAdapter.JurusanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_jurusan, parent, false);
        JurusanViewHolder jurusanViewHolder = new JurusanViewHolder(view);
        return jurusanViewHolder;
    }

    @Override
    public void onBindViewHolder(JurusanAdapter.JurusanViewHolder holder, int position) {
        holder.txt_resultjurusan.setText(jurusanList.get(position).getJurusan());
        holder.txt_resultjenjang.setText(jurusanList.get(position).getJenjang());
    }

    @Override
    public int getItemCount() {
        return jurusanList.size();
    }

    public static class JurusanViewHolder extends RecyclerView.ViewHolder {

        TextView txt_resultjurusan;
        TextView txt_resultjenjang;

        public JurusanViewHolder(View itemView) {
            super(itemView);

            txt_resultjurusan = (TextView) itemView.findViewById(R.id.txt_resultjurusan);
            txt_resultjenjang = (TextView) itemView.findViewById(R.id.txt_resultjenjang);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
