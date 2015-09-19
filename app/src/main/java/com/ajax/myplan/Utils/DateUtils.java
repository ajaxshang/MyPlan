package com.ajax.myplan.Utils;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by ajax on 2015/6/25.
 */
public class DateUtils {
    /**
     * 获取时间
     */
    public static String getFormatDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd/ HH:mm:ss");
        Date curDate = new Date(System.currentTimeMillis());
        String str = formatter.format(curDate);
        return str;
    }

    /**
     * 获取时间
     */
    public static Map<String, String> getDate() {
        Map<String, String> map = new HashMap<String, String>();
        String mWay;
        String mYear;
        String mMonth;
        String mDay;
        String mHour;
        String mMinute;
        final Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        mYear = String.valueOf(c.get(Calendar.YEAR));
        mMonth = String.valueOf(c.get(Calendar.MONTH));
        mDay = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
        mHour = String.valueOf(c.get(Calendar.HOUR_OF_DAY));
        mMinute = String.valueOf(c.get(Calendar.MINUTE));
        mWay = String.valueOf(c.get(Calendar.DAY_OF_WEEK));

        if ("1".equals(mWay)) {
            mWay = "一";
        } else if ("2".equals(mWay)) {
            mWay = "二";
        } else if ("3".equals(mWay)) {
            mWay = "三";
        } else if ("4".equals(mWay)) {
            mWay = "四";
        } else if ("5".equals(mWay)) {
            mWay = "五";
        } else if ("6".equals(mWay)) {
            mWay = "六";
        } else if ("7".equals(mWay)) {
            mWay = "日";
        }
        map.put("year", mYear);
        map.put("month", mMonth);
        map.put("day", mDay);
        map.put("hour", mHour);
        map.put("minute", mMinute);
        map.put("week", mWay);

        return map;
    }
}
