package com.example.responsi_123180122.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.responsi_123180122.R;
import com.example.responsi_123180122.model.kasus.KasusDataItem;

import java.util.ArrayList;

public class KasusAdapter extends RecyclerView.Adapter<KasusAdapter.ViewHolder> {
    private ArrayList<KasusDataItem> kasusHarianItem = new ArrayList<>();
    private Context context;

    public void setData(ArrayList<KasusDataItem> items){
        kasusHarianItem.clear();
        kasusHarianItem.addAll(items);
        notifyDataSetChanged();
    }

    public KasusAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist_kasus,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_tanggal.setText(kasusHarianItem.get(position).getTanggal()+"");
        holder.tv_terkonfirmasi.setText("Terkonfimasi : "+kasusHarianItem.get(position).getConfirmationDiisolasi()+"");
        holder.tv_sembuh.setText("Sembuh : "+kasusHarianItem.get(position).getConfirmationSelesai()+"");
        holder.tv_meninggal.setText("Meninggal : "+kasusHarianItem.get(position).getConfirmationMeninggal()+"");
    }

    @Override
    public int getItemCount() {
        return kasusHarianItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_tanggal,tv_terkonfirmasi,tv_sembuh,tv_meninggal;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_tanggal = itemView.findViewById(R.id.itemlist_kasus_tv_tanggal);
            tv_terkonfirmasi = itemView.findViewById(R.id.itemlist_kasus_tv_terkonfirmasi);
            tv_sembuh = itemView.findViewById(R.id.itemlist_kasus_tv_sembuh);
            tv_meninggal = itemView.findViewById(R.id.itemlist_kasus_tv_meninggal);
        }
    }
}
