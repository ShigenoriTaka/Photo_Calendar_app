package com.example.shigenoritakahashi.photo_calendar_app2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.Calendar;

public class Event_Calendar_Activity extends AppCompatActivity {

    private Calendar calendar;
    private ScrollView scrollView;
    private App_tool_Event appToolEvent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_calendar);
        appToolEvent = new App_tool_Event();
        appToolEvent.init(
                (TextView) findViewById(R.id.year_ID),
                (TextView) findViewById(R.id.month_ID)

        );
        Create_E_C_Prats();


    }

    public void Create_E_C_Prats() {
        Event_Calendar_Prats_View e_c_p = new Event_Calendar_Prats_View(this);
        e_c_p.Set_schedule(2019,4,18);
        LinearLayout e_s_linear = (LinearLayout) findViewById(R.id.event_scroll_linear);

        e_s_linear.addView(e_c_p);



    }
}
