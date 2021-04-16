package com.nlobby.usage.domain;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateData {

    public static String serialization(Date date){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


       return sdf.format(date);
    }

    public static Date getMonth(Date date){

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR,0);

        Date time = calendar.getTime();

        return time;
    }
    public static Date getMonth2(Date date){

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR,0);
        calendar.add(Calendar.MONTH,1);

        Date time = calendar.getTime();

        return time;
    }
}
