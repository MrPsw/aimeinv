package com.example.mrpeng.aimeinv.Baen;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobUser;

/**
 * Created by Mr.peng on 2016/12/9.
 */

public class UserUtils{
    private static BmobUser User;

 public static void setUserBase(BmobUser bmobUser){
     User=bmobUser;
 }
    public static BmobUser getUserBase(){
        return User;
    }
}
