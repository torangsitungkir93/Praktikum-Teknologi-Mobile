package com.example.tugas_4_torangtositungkir_123180122;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class LanguageAdapter extends RecyclerView.Adapter<LanguageAdapter.ViewHolder> {

    public ArrayList<LanguageModel> getLanguageModels() {
        return languageModels;
    }

    public void setLanguageModels(ArrayList<LanguageModel> languageModels) {
        this.languageModels = languageModels;
    }

    public LanguageAdapter(ArrayList<LanguageModel> listData, Context context) {
        this.context = context;
    }

    public ArrayList<LanguageModel> languageModels;
    private Context context;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_language, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        Glide.with(context).load(getLanguageModels().get(i).getGambarManga()).into(holder.photo);
        holder.tvName.setText(getLanguageModels().get(i).getNamaManga());
        holder.tvdeskripsi.setText(getLanguageModels().get(i).getDetailManga());
        holder.cvCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("photo", getLanguageModels().get(i).getGambarManga());
                intent.putExtra("name", getLanguageModels().get(i).getNamaManga());
                intent.putExtra("detail", getLanguageModels().get(i).getDetailManga());
                intent.putExtra("status", getLanguageModels().get(i).getStatusManga());
                context.startActivities(new Intent[]{intent});
            }
        });
    }

    @Override
    public int getItemCount() {
        return languageModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView photo ;
        private TextView tvName,tvdeskripsi;
        private CardView cvCardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            photo = itemView.findViewById(R.id.ivphoto);
            tvName = itemView.findViewById(R.id.tvname);
            cvCardView = itemView.findViewById(R.id.cv_item);
            tvdeskripsi = itemView.findViewById(R.id.tvdetail);
        }
    }
}
