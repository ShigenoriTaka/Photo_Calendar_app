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



        int machParent = ViewGroup.LayoutParams.MATCH_PARENT;
        int wrapContent = ViewGroup.LayoutParams.WRAP_CONTENT;

        ScrollView scrollView = new ScrollView(this);
        scrollView.setLayoutParams(new ScrollView.LayoutParams(
                machParent, wrapContent
        ));


        //drawableの画像を設定する
        ImageView imageView =new ImageView(this);

        imageView.setImageResource(R.drawable.backpphoto);

        imageView.setLayoutParams(new LinearLayout.LayoutParams(
                machParent, wrapContent));

        //ScrollViewにViewを追加

        scrollView.addView(imageView);

        setContentView(scrollView);

    }
}
