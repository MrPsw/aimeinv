package com.example.mrpeng.aimeinv.View;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Scroller;

/**
 * Created by Mr.peng on 2016/12/14.
 */

public class MyViewGroup extends ViewGroup {
    private int mHeight;
    private Scroller mScroller;

    public MyViewGroup(Context context) {
        super(context,null);
    }

    public MyViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs,0);
    }

    public MyViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void Init(){
        WindowManager wd=(WindowManager)getContext().getSystemService(Context.WINDOW_SERVICE);
        mHeight=wd.getDefaultDisplay().getHeight();
        mScroller = new Scroller(getContext());

    }

    /**
     * 摆放子控件
     * @param changed
     * @param l
     * @param t
     * @param r
     * @param b
     */
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    /**
     * 测量控件
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
