package com.example.mrpeng.aimeinv.Http;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.example.mrpeng.aimeinv.Baen.BaseBean;
import com.example.mrpeng.aimeinv.Baen.SyBaen;
import com.example.mrpeng.aimeinv.Url.UrlConfig;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Mr.peng on 2016/11/3.
 */

public class HomeHttp {

    public static List<? extends BaseBean>  Getadvertisement(final Handler h, final int what){
        final List<SyBaen> list=new ArrayList<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    Document doc = Jsoup.parse(new URL(UrlConfig.HOMEURL), 100000);

                    System.out.println(doc.body());
                    Elements div = doc.select("div.changeDiv");
                    Elements div2 = doc.select("div.pic-list mb7");


                    Elements img = div.select("img[src]");
                    Elements alt = div.select("img[alt]");

                    Elements img2 = div2.select("img[src]");
                    Elements alt2 = div2.select("img[alt]");



                    for(int i=0;i<img.size();i++){
                        SyBaen baen=new SyBaen();
                        String imagee =img.get(i).attr("abs:src");
                        baen.setAlt(alt.get(i).attr("alt"));
                        baen.setImageSrc(imagee);

                        list.add(baen);
                        System.out.println(baen.getAlt()+baen.getImageSrc());
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }

                Message msg=new Message();{
                    msg.what=what;
                    msg.obj=list;
                    h.sendMessage(msg);
                }
            }
        }).start();
        return list;
    }
    public static List<? extends BaseBean>  GetREcyData(final Handler h, final int what){
        final List<SyBaen> list=new ArrayList<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    Document doc = Jsoup.parse(new URL(UrlConfig.HOMEURL), 100000);

                    System.out.println(doc.body());
                    Elements div1 = doc.select("div.main");
                    Elements div2 = div1.select("div.pic-list");
                    System.out.println(div2.get(0));
                    Elements img2 = div2.get(0).select("img[data-original]");
                    Elements alt2 = div2.get(0).select("img[alt]");



                    for(int i=0;i<img2.size();i++){
                        SyBaen baen=new SyBaen();
                        String imagee =img2.get(i).attr("abs:data-original");
                        baen.setAlt(alt2.get(i).attr("alt"));
                        baen.setImageSrc(imagee);

                        list.add(baen);
                        System.out.println(baen.getAlt()+baen.getImageSrc());
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }

                Message msg=new Message();{
                    msg.what=what;
                    msg.obj=list;
                    h.sendMessage(msg);
                }
            }
        }).start();
        return list;
    }

    public static List<? extends BaseBean>  GetxingganData(final Handler h, final int what){
        final List<SyBaen> list=new ArrayList<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    Document doc = Jsoup.parse(new URL(UrlConfig.XINGGANURL), 100000);

                    System.out.println(doc.body());
                    Elements div1 = doc.select("div.main");
                    Elements div2 = div1.select("div.pic-list");
                    System.out.println(div2.get(0));

                    Elements img2 = div2.get(0).select("img[data-original]");
                    Elements alt2 = div2.get(0).select("img[alt]");



                    for(int i=0;i<img2.size();i++){
                        SyBaen baen=new SyBaen();
                        String imagee =img2.get(i).attr("abs:data-original");
                        baen.setAlt(alt2.get(i).attr("alt"));
                        baen.setImageSrc(imagee);

                        list.add(baen);
                        System.out.println("性感"+baen.getAlt()+baen.getImageSrc());
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }

                Message msg=new Message();{
                    msg.what=what;
                    msg.obj=list;
                    h.sendMessage(msg);
                }
            }
        }).start();
        return list;
    }

    public static void   GetfreshiyData(final Handler h, final int what, final Context context){
        final List<SyBaen> list=new ArrayList<>();
                Map<String ,String> map=new HashMap<String, String>();
                map.put("currentPage","1");
                map.put("userId","d79085d7a47baef38c25d5b91df934d4");

         new myHttp2(HttpHelp.BoayMap(map),UrlConfig.freshImage,h,what,context) .start();
    }
}
