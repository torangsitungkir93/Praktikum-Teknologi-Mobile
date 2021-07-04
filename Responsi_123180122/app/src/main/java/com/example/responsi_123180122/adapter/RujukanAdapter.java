package com.example.responsi_123180122.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.responsi_123180122.R;
import com.example.responsi_123180122.model.rujukan.RujukanDataItem;

import java.util.ArrayList;

public class RujukanAdapter extends RecyclerView.Adapter<RujukanAdapter.ViewHolder> {
    private ArrayList<RujukanDataItem> fasilitasiKesehatanDataItems = new ArrayList<>();
    private Context context;

    public void setData(ArrayList<RujukanDataItem> items){
        fasilitasiKesehatanDataItems.clear();
        fasilitasiKesehatanDataItems.addAll(items);
        notifyDataSetChanged();
    }

    public RujukanAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RujukanAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist_rujukan,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RujukanAdapter.ViewHolder holder, int position) {
        holder.tv_namaRS.setText(fasilitasiKesehatanDataItems.get(position).getNama());
        holder.tv_alamatRS.setText(fasilitasiKesehatanDataItems.get(position).getAlamat());
        holder.btn_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:37.7749,-122.4194?q=restaurants"));
//                intent.setPackage("com.google.android.apps.maps");
//                context.startActivities(new Intent[]{intent});
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?q="+ fasilitasiKesehatanDataItems.get(position).getAlamat()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return fasilitasiKesehatanDataItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_namaRS,tv_alamatRS;
        Button btn_map;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_namaRS = itemView.findViewById(R.id.itemlist_rujukan_tv_namaRS);
            tv_alamatRS = itemView.findViewById(R.id.itemlist_rujukan_tv_alamatRS);
            btn_map = itemView.findViewById(R.id.itemlist_rujukan_btn_map);
        }
    }
}
