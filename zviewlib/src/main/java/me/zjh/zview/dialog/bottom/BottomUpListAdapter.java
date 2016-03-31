package me.zjh.zview.dialog.bottom;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import me.zjh.zview.R;

/**
 * Created by zjh on 16/1/15.
 */
public class BottomUpListAdapter extends RecyclerView.Adapter<BottomUpListAdapter.ViewHolder> {

    private Context mContext;

    private List<String> mDatas = new ArrayList<>();

    private OnItemClickListener mListener;

    public BottomUpListAdapter(Context context, List<String> datas) {
        this.mContext = context;
        this.mDatas = datas;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_bottom_list, parent, false);
        ViewHolder vh = new ViewHolder(view, mListener);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.contentTXT.setText(mDatas.get(position));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView contentTXT;

        private OnItemClickListener mListener;

        public ViewHolder(View itemView, OnItemClickListener listener) {
            super(itemView);
            contentTXT = (TextView) itemView.findViewById(R.id.contentTXT);
            contentTXT.setOnClickListener(this);
            this.mListener = listener;
        }

        @Override
        public void onClick(View view) {
            if (mListener != null) {
                mListener.onItemClicked(getAdapterPosition());
            }
        }
    }

    public interface OnItemClickListener {
        void onItemClicked(int position);
    }

}
