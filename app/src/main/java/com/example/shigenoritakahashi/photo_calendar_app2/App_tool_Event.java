package com.example.shigenoritakahashi.photo_calendar_app2;



import android.widget.TextView;

import java.util.Calendar;



public class App_tool_Event {
    private TextView Text_tool_Ev_1;
    private TextView Text_tool_Ev_2;

    public void init(TextView text_tool_Ev_1, TextView text_tool_Ev_2) {
        Text_tool_Ev_1 = text_tool_Ev_1;
        Text_tool_Ev_2 = text_tool_Ev_2;

    }

    public  void Text_tool_EV(Calendar calendar) {
        int year = calendar.get(Calendar.YEAR);
        Text_tool_Ev_1.setText(String.valueOf(year));

        int month = calendar.get(Calendar.MONTH);
        String monthName_Ev = theMonth_Ev(month);
        Text_tool_Ev_2.setText(String.valueOf(monthName_Ev));

    }

    public static String theMonth_Ev(int month) {
        String[] monthNAme_EV = {"January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December"};
        return monthNAme_EV[month];
    }



}
