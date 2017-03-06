package com.example.mrpeng.aimeinv;

import android.app.Activity;
import android.app.Application;




import java.util.LinkedList;
import java.util.List;

import cn.bmob.v3.Bmob;

/**
 * Created by Mr.peng on 2016/10/13.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //第一：默认初始化
        Bmob.initialize(this, "95df5fbff2fd471c59f885fcb1e46459");

    }

    private List mList = new LinkedList();
    private static MyApplication instance;
    public synchronized static MyApplication getInstance() {
        if (null == instance) {
            instance = new MyApplication();
        }
        return instance;
    }
    // add Activity
    public void addActivity(Activity activity) {
        mList.add(activity);
    }
    public void exit() {
        try {
            for (int i=0;i<mList.size();i++) {
                Activity activity= (Activity) mList.get(i);
                if (activity != null)
                    activity.finish();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }
    }
}
