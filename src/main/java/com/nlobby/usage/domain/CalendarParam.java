package com.nlobby.usage.domain;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CalendarParam {

    public Date getDate(Date date){

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY,0);



        return c.getTime();

    }
}
