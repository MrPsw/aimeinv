package com.example.mrpeng.aimeinv.ViewHolder;

import android.content.Context;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.mrpeng.aimeinv.Activity.ParticularsActivity;


/**
 * Created by Mr.peng on 2016/11/3.
 */

public class BaseViewHolder extends RecyclerView.ViewHolder {
    View convertView;
    Context mContext;
    public BaseViewHolder(View itemView, Context context) {
        super(itemView);
        this.convertView=itemView;
        this.mContext=context;
    }
    public void setText(int id, String text) {
        TextView tx = (TextView) convertView.findViewById(id);
        tx.setText(text);
    }

    public void setImageResource(int id, int resouceId) {
        ImageView img= (ImageView) convertView.findViewById(id);
        img.setImageResource(resouceId);
    }
    public void setImageResource(int id, String url) {
        ImageView img= (ImageView) convertView.findViewById(id);


        try {

            Glide.with(mContext)
                    .load(url)
                    .override(600,800)
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .into(img);

//            Glide.with(mContext).load(url).override(600, 800).into(img);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
