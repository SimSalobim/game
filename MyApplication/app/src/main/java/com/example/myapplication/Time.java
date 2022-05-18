package com.example.myapplication;

import java.util.Date;

public class Time {

    public String calc() {
        Date date = new Date();
        int hours = date.getHours();
        int min = date.getMinutes();
        int sec = date.getSeconds();
        int m = 0;
        int s = 0;
        String text = "Сейчас " + String.valueOf(hours) + " часов " + String.valueOf(min) +
                "минут " + String.valueOf(sec) + " секунд.";
        if (hours == 10) {
            m = 60 - min;
            if (sec > 0) {
                s = 60 - sec;
                m = m - 1;
            }
            text = text + '\n' + "До 11 осталось " + String.valueOf(m) + " минут " +
                    String.valueOf(s) + " секунд.";
        }
        return text;
    }
}
