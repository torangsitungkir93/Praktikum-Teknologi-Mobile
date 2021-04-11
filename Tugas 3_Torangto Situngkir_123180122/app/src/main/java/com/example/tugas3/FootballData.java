package com.example.tugas3;

import java.util.ArrayList;

public class FootballData {
    private static String[] title = new String[]{"Java","C++","PHP", "Angular","Phyton","Javascript"};
    private static int[] thumbnail = new
            int[]{R.drawable.gambar1,R.drawable.gambar2,R.drawable.gambar3, R.drawable.gambar4,R.drawable.gambar5,R.drawable.gambar6};
    public static ArrayList<FootballModel> getListData(){
        FootballModel footballModel = null;
        ArrayList<FootballModel> list = new ArrayList<>();
        for (int i = 0; i <title.length; i++){
            footballModel = new FootballModel();
            footballModel.setLogoTeam(thumbnail[i]);
            footballModel.setNamaTeam(title[i]);
            list.add(footballModel);
        }
        return list;
    }
}
