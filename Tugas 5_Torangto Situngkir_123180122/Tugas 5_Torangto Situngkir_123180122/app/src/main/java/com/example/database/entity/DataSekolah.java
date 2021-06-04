package com.example.database.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "sekolah_db") //untuk nama tabelnya

public class DataSekolah {
    @NonNull
    @PrimaryKey(autoGenerate = true) //menandakan primary key yaitu id
    @ColumnInfo(name = "id") //info buat atribut dalam database
    private int id; // tipe data dari masing masin gatributnya

    @ColumnInfo(name = "jml_siswa")
    private String jml_siswa;

    @ColumnInfo(name = "jml_guru")
    private String jml_guru;

    @ColumnInfo(name = "nama_sekolah")
    private String nama_sekolah;

    @ColumnInfo(name = "alamat")
    private String alamat;

    //selanjutnya di alt enter untuk setter dan getternya
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) { this.id = id; }

    public String getJml_siswa() {
        return jml_siswa;
    }

    public void setJml_siswa(String jml_siswa) {
        this.jml_siswa = jml_siswa;
    }

    public String getJml_guru() {
        return jml_guru;
    }

    public void setJml_guru(String jml_guru) {
        this.jml_guru = jml_guru;
    }

    public String getNama_sekolah() {
        return nama_sekolah;
    }

    public void setNama_sekolah(String nama_sekolah) {
        this.nama_sekolah = nama_sekolah;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}