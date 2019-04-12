package com.example.shigenoritakahashi.photo_calendar_app2;


import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;


public class App_tool {

    private TextView Text_tool_01;
    private TextView Text_tool_02;
    private TextView Text_tool_03;

    public void init(TextView text_tool_01, TextView text_tool_02, TextView text_tool_03) {

        Text_tool_01 = text_tool_01;
        Text_tool_02 = text_tool_02;
        Text_tool_03 = text_tool_03;
    }



    public void Texttool(Calendar calendar){

        Calendar this_month_calendar = Calendar.getInstance();
        int this_month = this_month_calendar.get(Calendar.MONTH);

        int year = calendar.get(Calendar.YEAR);
        Text_tool_01.setText(String.valueOf(year));

        int month = calendar.get(Calendar.MONTH);
        String monthName = theMonth(month);
        Text_tool_02.setText(String.valueOf(monthName));

        int day = calendar.get(Calendar.DAY_OF_MONTH);
        Text_tool_03.setText(String.valueOf(day));
        if (month != this_month) {
            Text_tool_03.setVisibility(View.INVISIBLE);
        }

    }

    public static String theMonth(int month){
        String[] monthNames = {"January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December"};
        return monthNames[month];
    }




}
