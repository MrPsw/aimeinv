package com.example.mrpeng.aimeinv;



import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.jsoup.select.Elements;

import java.io.IOException;


/**
 * Created by Mr.peng on 2016/11/3.
 */

public class Data {
    public static void main (String[] args){
        try {
            Document doc = Jsoup.connect("http://www.zbjuran.com/mei/").timeout(5000).get();
            Elements div = doc.select("div.changeDiv");
            Elements img = div.select("img[src]");
            Elements alt = div.select("img[alt]");

            for(int i=0;i<img.size();i++){
                String imagee =img.get(i).attr("abs:src");


                System.out.println(imagee+alt.get(i).attr("abs:alt"));
            }
            System.out.println(div);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

  
}
