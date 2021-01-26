package com.charles.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeExchange {


    public static String SeChageMi(int paramInt) {
        int i = paramInt / 60;
        StringBuilder stringBuilder = new StringBuilder();
        if (i <= 0) {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(paramInt - i * 60);
            stringBuilder1.append("");
            stringBuilder.append(stringBuilder1.toString());
        } else {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(i);
            stringBuilder1.append("");
            stringBuilder.append(stringBuilder1.toString());
        }
        return stringBuilder.toString();
    }

    public static Date StringToDate(String paramString) throws ParseException {
        Date date1;
        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            date1 = simpleDateFormat.parse(paramString);
            date2 = date1;
            System.out.println(date1.toString());
        } catch (Exception exception) {
            exception.printStackTrace();
            date1 = date2;
        }
        return date1;
    }


    public static Integer StringToTimestamp(String paramString) {
        long l = 0;
        try {
             l = Timestamp.valueOf(paramString).getTime() / 1000L;
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return Integer.valueOf((int) l);
    }


    public static String TimeChangeString(int paramInt) {
        int i = paramInt / 86400;
        int j = paramInt - 86400 * i;
        paramInt = j / 3600;
        int k = j - paramInt * 3600;
        j = k / 60;
        k -= j * 60;
        StringBuilder stringBuilder = new StringBuilder();
        if (i <= 0 && paramInt <= 0 && j <= 0) {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(k);
            stringBuilder1.append("秒");
            stringBuilder.append(stringBuilder1.toString());
        } else if (i <= 0 && paramInt <= 0) {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(j);
            stringBuilder1.append("分");
            stringBuilder1.append(k);
            stringBuilder1.append("秒");
            stringBuilder.append(stringBuilder1.toString());
        } else if (i <= 0) {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(paramInt);
            stringBuilder1.append("时");
                    stringBuilder1.append(j);
            stringBuilder1.append("分");
                    stringBuilder1.append(k);
            stringBuilder1.append("秒");
                    stringBuilder.append(stringBuilder1.toString());
        } else {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(i);
            stringBuilder1.append("天");
                    stringBuilder1.append(paramInt);
            stringBuilder1.append("时");
                    stringBuilder1.append(j);
            stringBuilder1.append("分");
                    stringBuilder1.append(k);
            stringBuilder1.append("分");
                    stringBuilder.append(stringBuilder1.toString());
        }
        return stringBuilder.toString();
    }


}
