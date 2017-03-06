package com.example.mrpeng.aimeinv.Adapter;

import android.content.Context;
import android.util.Log;

import com.example.mrpeng.aimeinv.Baen.BaseBean;
import com.example.mrpeng.aimeinv.Baen.SyBaen;
import com.example.mrpeng.aimeinv.R;
import com.example.mrpeng.aimeinv.ViewHolder.BaseViewHolder;

import java.util.List;

/**
 * Created by Mr.peng on 2016/11/3.
 */

public class HomeRecyAdapter extends BaseAdapter {
    public HomeRecyAdapter(Context context, int layoutId, List<? extends BaseBean> data) {
        super(context,layoutId, data);
        Log.e("布局文件",R.layout.homerecyviewitem+"");
    }

    @Override
    protected <T extends BaseBean> void convert(BaseViewHolder holder, T bean) {
        SyBaen baen= (SyBaen) bean;
        holder.setText(R.id.altTitle,baen.getAlt());
        holder.setImageResource(R.id.image,baen.getImageSrc());
    }

}
