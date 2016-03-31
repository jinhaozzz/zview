package me.zjh.zview.calendar;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

/**
 * 增强点击时间的日历
 * <p/>
 * Created by zjh on 16/1/20.
 */
public class ExtMaterialCalendarView extends MaterialCalendarView {

    private boolean isJustClick;

    private OnDateClickListener listener;

    public ExtMaterialCalendarView(Context context) {
        super(context);
    }

    public ExtMaterialCalendarView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setOnDateClickListener(boolean isJustClick, OnDateClickListener listener) {
        this.isJustClick = isJustClick;
        this.listener = listener;
    }

    @Override
    protected void onDateClicked(@NonNull CalendarDay date, boolean nowSelected) {

        if (!isJustClick) {
            super.onDateClicked(date, nowSelected);
        } else {
            if (listener != null) {
                listener.onDateClick(date.getYear() + "-" + (date.getMonth() + 1) + "-" + date.getDay());
            }
        }
    }

    public interface OnDateClickListener {
        public void onDateClick(String date);
    }
}
