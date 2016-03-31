package me.zjh.zview.helpers;

import android.content.Context;
import android.view.Gravity;

import com.flyco.dialog.listener.OnBtnClickL;
import com.flyco.dialog.widget.NormalDialog;

import java.util.List;

import me.zjh.zview.dialog.bottom.BottomUpListDialog;

/**
 * dialog管理,显示帮助类
 * <p/>
 * Created by zjh on 16/1/18.
 */
public class DialogHelper {

    public interface OnNormalDialogClickListener {
        public void onDialogClick(NormalDialog dialog);
    }

    /**
     * 显示底部弹出列表dialog
     *
     * @param context  context
     * @param list     list
     * @param listener listener
     */
    public static void showBottomUpDialog(Context context, List<String> list, BottomUpListDialog.OnDialogClickListener listener) {
        BottomUpListDialog dialog = new BottomUpListDialog(context, list);
        dialog.setOnDialogClickListener(listener);
        dialog.show();
    }


    /**
     * 显示双选对话框
     *
     * @param context      context
     * @param content      content
     * @param listeners listeners
     */
    public static void showNormalDialog(final Context context, String content, final OnNormalDialogClickListener... listeners) {
        final NormalDialog dialog = new NormalDialog(context);
        dialog.isTitleShow(false)
                .cornerRadius(5)//
                .content(content)//
                .contentGravity(Gravity.CENTER)//
                .widthScale(0.75f)//
                .show();

        if (listeners != null) {
            if (listeners.length == 1) {
                dialog.setOnBtnClickL(new OnBtnClickL() {
                    @Override
                    public void onBtnClick() {
                        listeners[0].onDialogClick(dialog);
                    }
                });
            } else if (listeners.length == 2) {
                dialog.setOnBtnClickL(new OnBtnClickL() {
                    @Override
                    public void onBtnClick() {
                        listeners[0].onDialogClick(dialog);
                    }
                }, new OnBtnClickL() {
                    @Override
                    public void onBtnClick() {
                        listeners[1].onDialogClick(dialog);
                    }
                });
            } else if (listeners.length == 3) {
                dialog.setOnBtnClickL(new OnBtnClickL() {
                    @Override
                    public void onBtnClick() {
                        listeners[0].onDialogClick(dialog);
                    }
                }, new OnBtnClickL() {
                    @Override
                    public void onBtnClick() {
                        listeners[1].onDialogClick(dialog);
                    }
                }, new OnBtnClickL() {
                    @Override
                    public void onBtnClick() {
                        listeners[2].onDialogClick(dialog);
                    }
                });
            }
        }
    }

}
