package com.example.mrpeng.aimeinv.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mrpeng.aimeinv.Baen.BaseBean;
import com.example.mrpeng.aimeinv.R;
import com.example.mrpeng.aimeinv.ViewHolder.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Mr.peng on 2016/11/3.
 */

public abstract class BaseAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    int layoutId;
    List<? extends BaseBean> data =new ArrayList<>();
    Context context;
    RecyViewonItemClick mViewonItemClick;
    RecyViewonItemLongClick  mItemLongClick;

    public BaseAdapter(Context context, int layoutId, List<? extends BaseBean> data) {
        this.layoutId = layoutId;
        this.data = data;//==null ?this.data:data;
        this.context = context;
    }
    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       final View view= LayoutInflater.from(context).inflate(layoutId,parent,false);
        Log.e("布局文件", R.layout.homerecyviewitem+"");

        final BaseViewHolder holder = new BaseViewHolder(view, context);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mViewonItemClick.onItemClick(view,holder.getLayoutPosition());
                }
            });

            view.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mItemLongClick.onLongClick(view,holder.getLayoutPosition());
                 return false;
                }
            });

        return holder;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        convert(holder, data.get(position));
    }
    protected abstract <T extends BaseBean> void convert(BaseViewHolder holder, T bean);


    @Override
    public int getItemCount() {
        return data.size();
    }

    public interface  RecyViewonItemClick{
        void  onItemClick(View v,int position);
    }
    public interface  RecyViewonItemLongClick{
        void  onLongClick(View v,int position);
    }
    public void setOnItemClickListner(RecyViewonItemClick onItemClickListner) {
        this.mViewonItemClick = onItemClickListner;
    }

    public void setOnItemLongClickListner(RecyViewonItemLongClick onItemLongClickListner) {
        this.mItemLongClick = onItemLongClickListner;
    }
}
