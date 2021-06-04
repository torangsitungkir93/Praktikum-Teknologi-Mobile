package com.example.database.entity;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao //untuk ngasih tau kalau ini kelas DAO (data access object)
public interface DataSekolahDAO {
    @Insert //fungsi insert
    long insertData(DataSekolah dataSekolah); //nantinya dia akan ambil dari kelas data sekolah

    @Query("Select * from sekolah_db") //untuk memanggil seluruh data yg ada di db
    List<DataSekolah> getData(); //si db itu ngambil datanya dari list yang ada di data sekolah

    @Update //fungsi edit data
    int updateData(DataSekolah item);

    @Delete //fungsi hapus data
    void deleteData(DataSekolah item);
}
