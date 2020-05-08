package com.gb.util;

import java.text.SimpleDateFormat;
import java.util.Date;


public class DateUtil {


    /**
     * 格式化日期
     *
     * @param date
     * @return
     */
    public static String formatDateToYYYYMMddHHmmss(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return sdf.format(date);
        } catch (Exception e) {
            return "";
        }

    }


}
