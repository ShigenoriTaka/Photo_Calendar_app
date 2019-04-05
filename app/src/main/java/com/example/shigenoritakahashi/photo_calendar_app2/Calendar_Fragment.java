package com.example.shigenoritakahashi.photo_calendar_app2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Calendar;

public class Calendar_Fragment extends Fragment {

    private Calendar calendar;
    private LinearLayout mainlinerlyout;
    private App_tool apptool;

    public Calendar_Fragment_PagerAdapter.YearMonth create_YM;

    public static Calendar_Fragment newInstance(Calendar_Fragment_PagerAdapter.YearMonth ym) {
        Calendar_Fragment fragment = new Calendar_Fragment();
        fragment.create_YM = ym;
        //Log.e("hageeee","" + ym);
        return fragment;
    }

    @Override
    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle saveInstanceState) {
        View view = inflater.inflate(R.layout.calendar_fragment, null);


        mainlinerlyout = view.findViewById(R.id.calendarLayout);
        meake_calendar(create_YM);
        apptool = new App_tool();
        apptool.init(
                (TextView) view.findViewById(R.id.year_ID),
                (TextView) view.findViewById(R.id.month_ID),
                (TextView) view.findViewById(R.id.month_day_ID)
        );

        calendar = Calendar.getInstance();
        calendar.set(create_YM.y, create_YM.m, calendar.get(Calendar.DAY_OF_MONTH));
        apptool.Texttool(calendar);

        return view;

    }

    public void meake_calendar(Calendar_Fragment_PagerAdapter.YearMonth ym) {
        calendar = Calendar.getInstance();
        calendar_init(ym.y, ym.m);
        //日付を取得
        int month_day = getmonth_day();
        //先月の最後の日を取得する
        int last_month_endday = get_last_month_endday();
        // 先月を取得してカレンダーがずれたので初期化
        calendar_init(ym.y, ym.m);
        //１日が何曜日を取得する
        int strat_day = get_C_daystart();
        //カレンダーの横列を取得する
        int calendar_row = get_C_row(strat_day, month_day);
        //上の情報を元にカレンダーレイアウトを作る
        create_C_lyout(calendar_row, strat_day, month_day, last_month_endday);



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
    private int get_last_month_endday() {
        calendar.add(Calendar.MONTH, -1);
        return calendar.getActualMaximum(Calendar.DATE);
    }

    private int get_C_row(int start_day, int monthday) {
        float row = (float) (start_day + monthday) / 7f;
        return (int) Math.ceil(row);
    }

    private int get_C_daystart(){
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    public static final int SUNDAY_COLOR = 0xFFBD1F1F;
    public static final int SATURDAY_COLOR = 0xFF3A26D9;
    public static final int WEEK_DAY = 0xFFFFFFFF;
    public static final int REMAINDAR_DAY = 0xFF6E6E6E;


    private void create_C_lyout(int row, int month_stratday, int month_endday, int last_month_endday) {

        int day = - month_stratday + 1;

        for (int i = 0; i < row; i++) {

            LinearLayout row_Lyout = new LinearLayout(getActivity());
            LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            mainlinerlyout.addView(row_Lyout,param);


            for (int j = 0 ; j < 7; j++) {
                day++;
                String daystring;
                if (day <= 0) {
                    daystring = "" + (last_month_endday + day);
                }else if(day > month_endday){
                    daystring = "" + (day - month_endday);
                } else if(day >= 1) {
                    daystring = day + "";
                }else {
                    daystring = "";
                }
                TextView textView = new TextView(getActivity());
                textView.setText(daystring);
                textView.setTextSize(20);
                textView.setGravity(Gravity.CENTER);

                if (j == 0) {
                    textView.setTextColor(SUNDAY_COLOR);
                }

                if (j == 6) {
                    textView.setTextColor(SATURDAY_COLOR);
                }
                if ( (j >= 1 ) && (j <= 5)) {
                    textView.setTextColor(WEEK_DAY);
                }
                if (day <= 0) {
                    textView.setTextColor(REMAINDAR_DAY);
                }
                if (day > month_endday) {
                    textView.setTextColor(REMAINDAR_DAY);
                }

                LinearLayout.LayoutParams param1 = new LinearLayout.LayoutParams(
                        0,
                        ViewGroup.LayoutParams.MATCH_PARENT);
                param1.weight = 1.0f;
                param1.gravity = Gravity.CENTER;
                row_Lyout.addView(textView,param1);
            }
        }

    }




}

