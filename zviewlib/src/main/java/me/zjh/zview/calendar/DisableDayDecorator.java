package me.zjh.zview.calendar;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;

import java.util.List;

/**
 * 设置不可用
 */
public class DisableDayDecorator implements DayViewDecorator {

    private List<String> selDayList;

    public DisableDayDecorator(List<String> dayList) {
        this.selDayList = dayList;
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        return !selDayList.contains("" + day.getDay());
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.setDaysDisabled(true);
    }
}
