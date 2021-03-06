package me.zjh.zview.recycler.scroll;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.ScrollView;

/**
 * 自定义的FullyLinearLayoutManager 在4.x系统上好用，能显示滑动也流畅，但是在5.x上虽然显示正常，
 * 但是滑动的时候好像被粘住了，没有惯性效果。。。。
 * <p/>
 * 解决方法是重写最外层的Scrollview
 * <p/>
 * http://blog.csdn.net/fangchao3652/article/details/46914987
 * <p/>
 * Created by zjh on 16/1/12.
 */
public class RecyclerScrollview extends ScrollView {
    private int downX;
    private int downY;
    private int mTouchSlop;

    public RecyclerScrollview(Context context) {
        super(context);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public RecyclerScrollview(Context context, AttributeSet attrs) {
        super(context, attrs);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public RecyclerScrollview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        int action = e.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                downX = (int) e.getRawX();
                downY = (int) e.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                int moveY = (int) e.getRawY();
                if (Math.abs(moveY - downY) > mTouchSlop) {
                    return true;
                }
        }
        return super.onInterceptTouchEvent(e);
    }
}