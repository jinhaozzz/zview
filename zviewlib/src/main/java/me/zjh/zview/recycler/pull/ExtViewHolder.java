package me.zjh.zview.recycler.pull;

import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import butterknife.ButterKnife;

/**
 * 增强型的viewholder
 * <p/>
 * Created by zjh on 16/1/18.
 */
public class ExtViewHolder<M> extends BaseViewHolder<M> {
    public ExtViewHolder(ViewGroup parent, int res) {
        super(parent, res);
        ButterKnife.bind(this, itemView);
    }
}
