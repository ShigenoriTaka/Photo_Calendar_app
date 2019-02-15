package com.example.shigenoritakahashi.photo_calendar_app2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Calendar;

public class Calendar_Tool_Java extends AppCompatActivity {

    private Calendar calendar;
    private LinearLayout mainlinerlyout;
    private App_tool apptool;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainlinerlyout = findViewById(R.id.calendarLayout);
        meake_calendar();
        apptool = new App_tool();
        apptool.init(
                (TextView) findViewById(R.id.year_ID),
                (TextView) findViewById(R.id.month_ID),
                (TextView)findViewById(R.id.month_day_ID)
        );

        apptool.Texttool(calendar);
        apptool.Daychager_start(this, calendar.get(Calendar.DAY_OF_MONTH));

    }

    public void meake_calendar() {
        calendar = Calendar.getInstance();
        //calendar_init(2019,1);
        //日付を取得
        int month_day = getmonth_day();
        //１日が何曜日を取得する
        int strat_day = get_C_daystart();
        //カレンダーの横列を取得する
        int calendar_row = get_C_row(strat_day, month_day);
        //上の情報を元にカレンダーレイアウトを作る
        create_C_lyout(calendar_row, strat_day, month_day);


    }

    private void calendar_init(int y, int m){
        calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, y);
        calendar.set(Calendar.MONTH,m);
        calendar.set(Calendar.DAY_OF_MONTH,1);

    }

    private int getmonth_day() {
        return calendar.getActualMaximum(Calendar.DATE);
    }

    private int get_C_row(int start_day, int monthday) {
        float row = (float) (start_day + monthday) / 7f;
        return (int) Math.ceil(row);
    }

    private int get_C_daystart(){
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    private void create_C_lyout(int row, int month_stratday, int month_endday) {

        int day = - month_stratday + 1;

        for (int i = 0; i < row; i++) {

            LinearLayout row_Lyout = new LinearLayout(this);
            mainlinerlyout.addView(row_Lyout);

            for (int j = 0 ; j < 7; j++) {
                day++;
                String daystring;
                if (day <= 0) {
                    daystring = "";
                }else if(day > month_endday){
                    daystring = "";
                } else if(day >= 1) {
                        daystring = day + "";
                }else {
                    daystring = "";
                }
                TextView textView = new TextView(this);
                textView.setText(daystring);
                row_Lyout.addView(textView);
            }
        }

    }

    public void InvalidateScreen() {
        apptool.InvalidateDay();
    }
}
