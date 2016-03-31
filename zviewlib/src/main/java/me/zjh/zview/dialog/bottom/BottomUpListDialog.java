package me.zjh.zview.dialog.bottom;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.Window;

import java.util.ArrayList;
import java.util.List;

import me.zjh.zview.R;
import me.zjh.zview.recycler.decoration.DividerItemDecoration;
import me.zjh.zview.recycler.layoutmanager.WrapLinearLayoutManager;

/**
 * 由下向上滑动的列表dialog
 * <p/>
 * Created by zjh on 16/1/15.
 */
public class BottomUpListDialog extends BottomUpDialog {

    private Context mContext;

    private List<String> mList = new ArrayList<>();

    private RecyclerView selRV;

    private OnDialogClickListener mListener;

    public BottomUpListDialog(Context context, List<String> list) {
        super(context);
        this.mContext = context;
        this.mList = list;
    }

    public void setOnDialogClickListener(OnDialogClickListener listener) {
        this.mListener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_bottom_list);

        Window window = this.getWindow();
        // 此处可以设置dialog显示的位置
        window.setGravity(Gravity.BOTTOM);
        // 占满屏幕
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        initView();
    }

    private void initView() {
        selRV = (RecyclerView) findViewById(R.id.selRV);
        WrapLinearLayoutManager lm = new WrapLinearLayoutManager(mContext);
        selRV.setLayoutManager(lm);
        selRV.addItemDecoration(new DividerItemDecoration(mContext,
                DividerItemDecoration.VERTICAL_LIST));
        selRV.setHasFixedSize(true);

        BottomUpListAdapter mAdapter = new BottomUpListAdapter(mContext, mList);
        mAdapter.setOnItemClickListener(new BottomUpListAdapter.OnItemClickListener() {
            @Override
            public void onItemClicked(int position) {
                if (mListener != null) {
                    mListener.onDialogClick(BottomUpListDialog.this, position);
                }
            }
        });
        selRV.setAdapter(mAdapter);
    }

    public interface OnDialogClickListener {
        public void onDialogClick(DialogInterface dialog, int which);
    }

}
