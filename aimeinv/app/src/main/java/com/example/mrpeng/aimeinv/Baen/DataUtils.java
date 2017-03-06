package com.example.mrpeng.aimeinv.Baen;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mr.peng on 2016/11/3.
 */

public class DataUtils {
    public static List<SyBaen> GetImages(){
        List<SyBaen> list=new ArrayList<>();
        SyBaen baen=new SyBaen();
        try {
            Document doc = Jsoup.connect("http://www.zbjuran.com/mei/").timeout(5000).get();
            Elements div = doc.select("div.changeDiv");
            Elements img = div.select("img[src]");
            Elements alt = div.select("img[alt]");

            for(int i=0;i<img.size();i++){
                String imagee =img.get(i).attr("abs:src");
                baen.setAlt(alt.get(i).attr("abs:alt"));
                baen.setImageSrc(imagee);
                list.add(baen);
            }
            System.out.println(div);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return  list;
    }


}
