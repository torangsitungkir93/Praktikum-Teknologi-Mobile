package com.example.database.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.database.Edit_data;
import com.example.database.R;
import com.example.database.entity.DataSekolah;
import com.example.database.main.MainContact;

import java.util.List;

//supaya inputan tadi masuk kedalam layout jangan lupa extend recycler
//viewholder ini untuk menyimpan view yang akan digunakan
public class SekolahAdapter extends RecyclerView.Adapter<SekolahAdapter.ViewHolder> {
    //inisialisasi context untuk tempat sementara, list inputan dari data sekolah, dan class maincontact untuk pengahapusan agar bisa terhapus langsung
    Context context;
    List<DataSekolah> list;
    MainContact.hapus view;

    //fungsi untuk menggunakan class yg sudah di inisiasi dengan 3 parameternya
    public SekolahAdapter(Context context, List<DataSekolah> list, MainContact.hapus view) {
        this.view = view;
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    //untuk pembuatan viewholder baru
    public SekolahAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //untuk mengconvert ke layout xml
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.activity_lihat_data, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    //untuk mengambil data yg akan digunakan untuk mengisi di tampilannya
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        //disini kita mengambil datanya dari class data sekolah
        final DataSekolah data = list.get(i);
        viewHolder.tvNama.setText(data.getNama_sekolah());
        viewHolder.tvAlamat.setText(data.getAlamat());
        viewHolder.tvSiswa.setText(data.getJml_siswa());
        viewHolder.tvGuru.setText(data.getJml_guru());
        viewHolder.id.setText(String.valueOf(data.getId())); //disini berbeda karena id itu langsung autogenerate jadi selalu ada nilainya
        viewHolder.btnHapus.setOnClickListener(new View.OnClickListener() { //membuat action hapus
            @Override
            public void onClick(View v) {
                view.deleteData(data); //terlempar ke class maincontact
                // return true;
            }
        });
        viewHolder.btnEdit.setOnClickListener(new View.OnClickListener() { //membuat action hapus
            @Override
            public void onClick(View v) {
                Intent x = new Intent(context, Edit_data.class); //pertama disini kita melemparkan class dulu dengan menyimpan berbagai data
                x.putExtra("nama", data.getNama_sekolah()); //data pertama dengan name valuenya nama, dan class data sekolah.ambil nilai dari get yg ada disana
                x.putExtra("alamat", data.getAlamat());
                x.putExtra("jml_siswa", data.getJml_siswa());
                x.putExtra("jml_guru", data.getJml_guru());
                x.putExtra("id", data.getId());
                //dia mengirim ke class edit data bahwa akan memulai aktivitas dalam tugas baru yang harus dilakukan
                x.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                //proses perpindahan
                context.startActivity(x);
            }
        });

    }

    @Override
    public int getItemCount() { return list.size(); } //mendapatkan ukuran set data yg akan ditampilkan

    public class ViewHolder extends RecyclerView.ViewHolder {
        //inisialisasi text view dan button samain kaya di layout lihat data
        TextView tvNama, tvAlamat,tvSiswa, tvGuru, id;
        Button btnHapus, btnEdit;

        //class holdernya yg menghubungkan antara inisialisasinya ke yg ada pada layout lihat data
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSiswa = itemView.findViewById(R.id.tv_item_jml_siswa);
            tvGuru = itemView.findViewById(R.id.tv_item_jml_guru);
            tvNama = itemView.findViewById(R.id.tv_item_nama_sekolah);
            tvAlamat = itemView.findViewById(R.id.tv_item_alamat);
            btnHapus = itemView.findViewById(R.id.btn_hapus);
            btnEdit = itemView.findViewById(R.id.btn_edit);
            id = itemView.findViewById(R.id.tv_item_id);
        }
    }
}