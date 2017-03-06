package com.example.mrpeng.aimeinv.Adapter;

import android.content.Context;
import android.util.Log;

import com.example.mrpeng.aimeinv.Baen.BaseBean;
import com.example.mrpeng.aimeinv.Baen.FreshlyPictureBase;
import com.example.mrpeng.aimeinv.Baen.SyBaen;
import com.example.mrpeng.aimeinv.R;
import com.example.mrpeng.aimeinv.ViewHolder.BaseViewHolder;

import java.util.List;

/**
 * Created by Mr.peng on 2016/11/3.
 */

public class FreshlyAdapter extends BaseAdapter {
    public FreshlyAdapter(Context context, int layoutId, List<? extends BaseBean> data) {
        super(context,layoutId, data);
        Log.e("布局文件",R.layout.homerecyviewitem+"");
    }

    String ImageUrl="http://7xq0d5.com2.z0.glb.qiniucdn.com/";
    @Override
    protected <T extends BaseBean> void convert(BaseViewHolder holder, T bean) {
        FreshlyPictureBase.ItemsBean baen= (FreshlyPictureBase.ItemsBean) bean;
        holder.setText(R.id.altTitle,baen.getName());
        holder.setImageResource(R.id.image,ImageUrl+baen.getPicture());
    }

}
