package com.bfmehuang.overlapcardrecycleview;

import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Created by BFMe.miao on 2018/3/16.
 */

public abstract class BaseAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    protected List mList;

    public BaseAdapter(List list) {
        mList = list;
    }

    /**
     * 删除最顶部Item
     */

    public void delTopItem() {
        int position = getItemCount() - 1;
        mList.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
