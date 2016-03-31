package me.zjh.zview.recycler.pull;

import android.content.Context;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.List;

/**
 * 增强型的包含头和尾的recyclerview
 * <p/>
 * Created by zjh on 16/1/18.
 */
abstract public class ExtRecyclerAdapter<T> extends RecyclerArrayAdapter<T> {
    public ExtRecyclerAdapter(Context context) {
        super(context);
    }

    public ExtRecyclerAdapter(Context context, T[] objects) {
        super(context, objects);
    }

    public ExtRecyclerAdapter(Context context, List<T> objects) {
        super(context, objects);
    }

    @Override
    abstract public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType);
}
