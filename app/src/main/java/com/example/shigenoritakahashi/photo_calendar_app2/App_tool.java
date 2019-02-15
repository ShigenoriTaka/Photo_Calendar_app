package com.example.shigenoritakahashi.photo_calendar_app2;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

        int year = calendar.get(Calendar.YEAR);
        Text_tool_01.setText(String.valueOf(year));

        int month = calendar.get(Calendar.MONTH);
        String monthName = theMonth(month);
        Text_tool_02.setText(String.valueOf(monthName));

        int day = calendar.get(Calendar.DAY_OF_MONTH);
        Text_tool_03.setText(String.valueOf(day));

    }

    public static String theMonth(int month){
        String[] monthNames = {"January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December"};
        return monthNames[month];
    }

    public void Daychager_start(Context context, int day) {
        Timer timer = new Timer();
        Daychenge_Task daychenge_task = new Daychenge_Task(context, day, this, timer);
        timer.scheduleAtFixedRate(daychenge_task,1000,100);
    }

    public int display_day;
    public void InvalidateDay() {
        Text_tool_03.setText("" + display_day);
        Text_tool_03.invalidate();
    }

    public class Daychenge_Task extends TimerTask{
        private Handler handler;
        private Context context;
        private float day;
        private  float tenp_day;
        private App_tool app_tool;
        private Timer timer;

        public Daychenge_Task(Context context,float day,App_tool app_tool, Timer timer) {
            this.context = context;
            this.app_tool = app_tool;
            this.day = day;
            tenp_day = 1;
            handler = new Handler();
            this.timer = timer;
        }
        @Override
        public void run() {
            handler.post(new Runnable() {

                @Override
                public void run() {
                    tenp_day++;
                    app_tool.display_day = (int)tenp_day;
                    Log.e("avaaaaaaaaaaaaaaaaa","" + tenp_day);
                    ((Calendar_Tool_Java)context).InvalidateScreen();
                    if (tenp_day >= day){
                        timer.cancel();
                        handler.removeCallbacks(this);

                    }
                }
            });
        }
    }

}
