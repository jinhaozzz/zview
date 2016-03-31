package me.zjh.zviewdemo;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import butterknife.Bind;
import me.zjh.zview.recycler.pull.ExtRecyclerAdapter;
import me.zjh.zview.recycler.pull.ExtViewHolder;

/**
 * Created by zjh on 16/1/18.
 */
public class MainAdapter extends ExtRecyclerAdapter<String> {
    public MainAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new MainViewHolder(parent, R.layout.adapter_main);
    }

    static class MainViewHolder extends ExtViewHolder<String> {

        @Bind(R.id.showTXT)
        TextView showTXT;

        public MainViewHolder(ViewGroup parent, int res) {
            super(parent, res);
        }

        @Override
        public void setData(String data) {
            super.setData(data);
            showTXT.setText(data);
        }
    }

}
