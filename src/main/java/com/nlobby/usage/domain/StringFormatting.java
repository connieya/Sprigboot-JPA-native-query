package com.nlobby.usage.domain;

public class StringFormatting {

    public static String 문자열변환(String data){

        int day = Integer.parseInt(data.substring(0, 2));

        int hour = Integer.parseInt(data.substring(3, 5));

        int minute = Integer.parseInt(data.substring(6, 8));

        int totalHour = day * 24 + hour;

        return totalHour+"시간"+minute+"분";


    }
}
