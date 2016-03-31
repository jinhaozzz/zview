package me.zjh.zview.dialog.bottom;

import android.app.Dialog;
import android.content.Context;

import me.zjh.zview.R;


/**
 * 有底部滑动出得dialog
 *
 * Created by zjh on 16/1/15.
 */
public class BottomUpDialog extends Dialog {

    public BottomUpDialog(Context context) {
        this(context, R.style.BottomUpDialogStyle);
    }

    public BottomUpDialog(Context context, int themeResId) {
        super(context, themeResId);
    }
}
