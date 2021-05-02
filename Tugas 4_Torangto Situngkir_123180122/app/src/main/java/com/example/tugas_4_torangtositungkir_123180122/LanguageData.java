package com.example.tugas_4_torangtositungkir_123180122;

import java.util.ArrayList;

public class LanguageData {
    private static String[] title = new String[]{
            "JAVA",
            "C",
            "PHP",
            "Visual Basic",
            "Python",
            "C++",
            "Javascript",
            "C#",
            "Objective-C",
            "ActionScript"};

    private static String[] status = new String[]{
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10"
    };

    private static int[] thumbnail = new
            int[]{R.drawable.gambar1,R.drawable.gambar2,R.drawable.gambar3, R.drawable.gambar4,R.drawable.gambar5,R.drawable.gambar6,R.drawable.gambar7,R.drawable.gambar8,R.drawable.gambar9,R.drawable.gambar10};

    private static String[] keterangan = new String[]{
            "Java merupakan bahasa pemrograman yang dapat dijalankan di berbagai platform, dari mulai PC sampai perangkat mobile. Bahasa pemrograman ini awalnya dikembangkan pada The Green Project pada tahun 1991 oleh Sun Microsystem yang kemudian dilepas pada Oracle." +
                    " Nama Java sendiri dipilih karena salah seorang pendiri Java, James Gosling, sangat menyukai kopi murni yang langsung digiling dari mesin giling (kopi tubruk) dimana kopi jenis ini berasal dari pulau Jawa di Indonesia.\n" +
                    "\n" +
                    "Java menjadi salah satu bahasa pemrograman terpopuler bukan karena tanpa alasan, bahasa pemrograman ini memiliki beberapa kelebihan seperti misalnya bisa berjalan di sistem operasi yang berbeda-beda," +
                    "kemudian bahasa pemrograman ini termasuk kedalam pemrograman OOP (pemrograman orientasi objek) sehingga programer lebih mudah dalam menyusun program menggunakan bahasa ini, selain itu bahasa ini juga memiliki library yang lengkap sehingga akan sangat memudahkan programer." +
                    "Dan saat ini merupakan era dimana smartphone Android sangat banyak digunakan. Aplikasi dalam smartphone Android dibangun menggunakan bahasa Java, sehingga banyak juga programer-programer yang menggunakan bahasa ini karena memang sedang banyak dibutuhkan.",

            "Bahasa C ini termasuk bahasa pemrograman tertua yang pernah ada. Bahasa pemrograman C ini dikembangkan dari sekitar tahun 70-an. Pembuat bahasa C adalah Dennis Ritchie. Bahasa C menjadi bahasa pemrograman yang populer di Indonesia karena hampir sebagian besar perguruan tinggi jurusan IT" +
                    " ataupun lembaga kursus pemrograman menggunakan bahasa ini untuk dipelajari pertama kali sebelum mempelajari bahasa pemrograman yang lain. Bukan tanpa sebab bahasa C ini menjadi dasar untuk mempelajari bahasa pemrograman yang lain, karena memang bahasa C ini merupakan “bapak” " +
                    "dari bahasa pemrograman lain seperi C#, Java, C++, dan lain sebagainya.",

            "PHP (PHP Hypertext Pre-processor) merupakan bahasa pemrograman yang paling banyak digunakan di Indonesia. Selain karena gratis, PHP banyak digunakan karena bahasa pemrograman ini merupakan server side scripting yang memang dirancang untuk membangun website dinamis. Selain itu banyak website-website ternama seperti" +
                    " Facebook, Wordpress, ataupun Digg yang menggunakan PHP dalam pengembangannya. PHP pertama kali dikembangkan oleh Rasmus Lerdrorf.",

            "Visual Basic merupakan bahasa pemrograman yang dikembangkan oleh Microsoft. Bahasa pemrograman ini menawarkan IDE visual dalam pembuatan software, dan bahasa pemrograman ini dikembangkan untuk membuat software-software berbasis sistem operasi Windows. VisualBasic sendiri adalah keturunan dari bahasa pemrograman BASIC.\n" +
                    "\n" +
                    "Sebuah survey pada tahun 2005 menunjukan 62% developer software menggunakan Visual Basic dalam pengembangan software nya, sehingga hal tersebut menjadikan VisualBasic sebagai salah satu bahasa pemrograman yang populer. Di Indonesia sendiri terdapat grup Visual Basic Indonesia yang telah memiliki 22 ribu member lebih.",

            "Dalam tingkatan bahasa pemrograman, Python termasuk bahasa tingkat tinggi. Python menjadi salah satu bahasa pemrograman yang dapat membangun aplikasi, baik itu berbasis web ataupun berbasis mobile. Bahasa phyton ini termasuk kedalam bahasa pemorgraman yang cukup mudah bagi pemula," +
                    "karena bahasa tersebut mudah untuk dibaca dengan syntax yang mudah untuk dipahami juga. Banyak perusahaan besar menggunanakn Phyton dalam pengembanganya seperti Instagram, Pinterest dan Rdio. Python juga digunakan oleh para pengembang Google, Yahoo!, dan juga NASA.\n" +
                    "\n" +
                    "Di Indonesia sendiri terdapat grup Facebook yang membahas tentang Python yang telah memiliki lebih dari 6000 anggota. Grup ini cukup aktif, grup ini bernama Python Indonesia.",

            "C++ merupakan bahasa pemrograman pengembangan dari bahasa C. C++ dan C memiliki sintaks penulisan yang hampir sama, meski begitu kedua bahasa pemrograman ini memiliki perbedaan pada penyelesaian masalahnya. Pada bahasa C penyelesaian masalah dilakukan dengan membagi-bagi " +
                    "kedalam sub-sub masalah yang lebih kecil lagi atau bisa disebut bahasa pemrograman prosedural, sedangakan C++ berorientasi pada objek dimana permasalahan dibagi-bagi kedalam class-class. C++ pertama kali dikembangkan oleh Bjarne Stroustrup.\n" +
                    "\n" +
                    "C++ ini menjadi bahasa pemrograman yang populer karena banyak juga perusahaan-perusahaan software besar yang menggunakan bahasa ini untuk membangun software nya seperti Adobe, Firefox, ataupun Winamp yang sekarang pengembanganya di hentikan.",

            "JavaScript adalah bahasa pemrograma yang dikembangkan oleh Netscape. Penggunaan JavaScript saat ini kebanyakan terdapat pada pengembangan web. Dengan JavaScript ini kita bisa membuat web yang interaktif dan menarik. Di Indonesia sendiri terdapat grup Facebook yang membahas tentang JavaScript ini dengan nama JavaScript Indonesia. " +
                    "Grup yang beranggotakan lebih dari 10 ribu orang ini masih aktif sampai sekarang.",

            "C# adalah bahasa pemrograman yang dikembangkan oleh Microsoft. C# ini menggabungkan prinsip dari C dan C++. C# ini banyak digunakan untuk mengembangkan software yang menggunakan platform Windows.",

            "Objective-C adalah bahasa pemrograman yang berorientasi objek. Bahasa pemrograman ini digunakan untuk pengembangan aplikasi yang digunakan pada perangkat Apple, bahkan sistem operasi iOS pun dikembangkan menggunakan bahasa pemrograman Objective-C ini.",

            "ActionScript adalah bahasa pemrograman yang dibuat berdasarkan ECMAScript yang digunakan dalam pengembangan situs web dan perangkat lunak menggunakan platform Adobe Flash Player. ActionScript juga dipakai pada beberapa aplikasi basis data, seperti Alpha Five. Bahasa ini awalnya dikembangkan oleh Macromedia, " +
                    "tapi kini sudah dimiliki dan dilanjutkan perkembangannya oleh Adobe, yang membeli Macromedia pada tahun 2005.\n" +
                    "\n" +
                    "Action Script terbaru saat ini adalah Action Script 3.0. Action Script 3.0 adalah bahasa terbaru dari edisi yang sebelumnya dikenal dengan Action Script 2.0. Action Script 3.0 memiliki beberapa kelebihan dibanding pendahulunya, antara lain fitur yang ditawarkan adalah file pada Action Script 3.0 dapat dibuat terpisah saat runtime. (wikipedia.org)\n" +
                    "\n" +
                    "Di indonesia ActionScript ini menjadi populer karena banyaknya developer berbasis Flash yang tentu saja menggunakan ActionScript untuk keperluan koding. Di Facebook juga terdapat grup ACTIONSCRIPT Indonesia yang masih aktif hingga sekarang. Grup ini memiliki 1000 lebih anggota."
    };

    public static ArrayList<LanguageModel> getListData(){
        LanguageModel languageModel = null;
        ArrayList<LanguageModel> list = new ArrayList<>();
        for (int i = 0; i <title.length; i++){
            languageModel = new LanguageModel();
            languageModel.setNamaManga(title[i]);
            languageModel.setGambarManga(thumbnail[i]);
            languageModel.setStatusManga(status[i]);
            languageModel.setDetailManga(keterangan[i]);
            list.add(languageModel);
        }
        return list;
    }
}

