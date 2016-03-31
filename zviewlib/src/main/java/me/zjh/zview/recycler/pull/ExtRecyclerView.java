package me.zjh.zview.recycler.pull;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import me.zjh.zview.R;

/**
 * 支持下拉刷新和上拉加载更多的view
 * <p/>
 * Created by zjh on 16/1/13.
 */
public class ExtRecyclerView extends EasyRecyclerView {
    public ExtRecyclerView(Context context) {
        super(context);
    }

    public ExtRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ExtRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    /**
     * 设置下拉刷新
     *
     * @param listener listener
     */
    public void setPullRefresh(SwipeRefreshLayout.OnRefreshListener listener) {
        setRefreshListener(listener);
    }

    /**
     * 设置加载更多
     *
     * @param listener listener
     */
    public void setLoadMore(RecyclerArrayAdapter.OnLoadMoreListener listener) {
        RecyclerView.Adapter adapter = getAdapter();

        if (adapter instanceof RecyclerArrayAdapter) {
            RecyclerArrayAdapter recyclerArrayAdapter = (ExtRecyclerAdapter) getAdapter();

            recyclerArrayAdapter.setMore(R.layout.easy_view_more, listener);
            recyclerArrayAdapter.setNoMore(R.layout.easy_view_nomore);
        }
    }
}
