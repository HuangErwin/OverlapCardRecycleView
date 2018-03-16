package com.bfmehuang.overlapcardrecycleview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;


public class CustomLayoutManager extends RecyclerView.LayoutManager {
    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        super.onLayoutChildren(recycler, state);
        detachAndScrapAttachedViews(recycler);//
        for (int i = 0; i <getItemCount() ; i++) {
            View child = recycler.getViewForPosition(i);//拿到子view
            measureChildWithMargins(child,0,0);//测量
            addView(child);
            int height = getDecoratedMeasuredHeight(child);
            int width = getDecoratedMeasuredWidth(child);
            layoutDecorated(child,0,0,width,height);
            if(i==getItemCount()-1) {
                child.setX(child.getX() - 10);
                child.setY(child.getY() - 10);//第一个偏移5个像素
            }else if(i == getItemCount()-2){
                child.setX(child.getX() - 5);
                child.setY(child.getY() - 5);//第一个偏移5个像素
            }
        }
    }
}
