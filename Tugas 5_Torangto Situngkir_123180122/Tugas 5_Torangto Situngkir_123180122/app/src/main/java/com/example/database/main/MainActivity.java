package com.example.database.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.database.R;
import com.example.database.entity.AppDatabase;
import com.example.database.entity.DataSekolah;

public class MainActivity extends AppCompatActivity {
    //inisiasi edit text, button, string untuk membaca inputan sesuaiin sama layout activity main, dan inisiasi class appdatabase
    private EditText etNama, etAlamat, etSiswa, etGuru ;
    private Button btnSubmit, btnLihat;
    private String setNama, setAlamat, setSiswa,setGuru ;

    AppDatabase appDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //seperti biasa untuk mengambil id dari layout yang dihubungkan dengan variable yang telah dibuat diatas
        etNama = findViewById(R.id.et_nama_sekolah);
        etAlamat = findViewById(R.id.et_alamat_sekolah);
        etSiswa = findViewById(R.id.et_jml_siswa);
        etGuru = findViewById(R.id.et_jml_guru);

        btnSubmit = findViewById(R.id.btn_submit);
        btnLihat = findViewById(R.id.btn_lihat);
        appDatabase = AppDatabase.iniDb(getApplicationContext()); //menginisiaslisasi db
        btnSubmit.setOnClickListener(new View.OnClickListener() { //action perpindahan dari class ini ke class lihat data
            @Override
            public void onClick(View v) {
                input();
                Intent submit = new Intent(getApplicationContext(), LihatDataActivity.class);
                startActivity(submit);
            }
        });
        btnLihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lihat = new Intent(getApplicationContext(), LihatDataActivity.class);
                startActivity(lihat);
            }
        });
    }
    //fungsi untuk create ke databasenya
    public void input(){
        setNama = etNama.getText().toString();
        setAlamat = etAlamat.getText().toString();
        setSiswa = etSiswa.getText().toString();
        setGuru = etGuru.getText().toString();

        //manggil kelas data sekolah
        final DataSekolah dataSekolah = new DataSekolah();

        dataSekolah.setNama_sekolah(setNama);
        dataSekolah.setAlamat(setAlamat);
        dataSekolah.setJml_siswa(setSiswa);
        dataSekolah.setJml_guru(setGuru);

        //memanggil fungsi insert data(variable appdatabase untuk koneksi ke app database, variabel kelas data sekolah untuk masukin data
        //ke databasee terus nanti baru di eksekusi
        new InsertData(appDatabase, dataSekolah).execute();
    }
    //class insertdata dengan extendsnya
    //asynctask itu kelas yg disediakan android untuk proses pengambilan/pengiriman yang dilakukan secara background
    class InsertData extends AsyncTask<Void, Void, Long> {
        //inisialisasi appdatabase dan datasekolah
        private AppDatabase database;
        private DataSekolah dataSekolah;

        //fungsi insert data ini menggunakan kelas kelas yg sudah di inisialisasi
        public InsertData(AppDatabase database, DataSekolah dataSekolah) {
            this.database = database;
            this.dataSekolah = dataSekolah;
        }

        //nah ini method yg ada di class asynctask
        //pada method ini proses thread berjalan, dan proses pengiriman/pengambilan datanya
        @Override
        protected Long doInBackground(Void... voids) {
            //dari appdatabase diambil var dao yang adalah class datasekolahdao lalu mengakses fungsi insertdata dengan parameternya datasekolah
            return database.dao().insertData(dataSekolah);
        }

        //method ini untuk mengupdate user interface ketika proses doinbackground telah selesai
        @Override
        protected void onPostExecute(Long aLong) {
            super.onPostExecute(aLong);
            //ngeluarin teks notif "sukses" untuk waktu yang sebentar, kalau dalam waktu lama diganti aja LENGTH_LONG
            Toast.makeText(getApplicationContext(), "sukses", Toast.LENGTH_SHORT).show();

        }

    }
}