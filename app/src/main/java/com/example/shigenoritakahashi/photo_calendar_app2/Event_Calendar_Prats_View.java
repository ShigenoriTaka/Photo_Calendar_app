package com.example.shigenoritakahashi.photo_calendar_app2;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.jar.Attributes;

public class Event_Calendar_Prats_View extends FrameLayout {

    public Event_Calendar_Prats_View(Context context) {
        this(context, null);
    }

    public Event_Calendar_Prats_View(Context context, AttributeSet attrs) {
        this (context, attrs, 0);
    }
    public Event_Calendar_Prats_View(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs,defStyleAttr);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(400,400);
        params.weight = 1;
        setLayoutParams(params);
        setBackgroundColor(Color.GRAY);

    }

    public void Set_schedule(int year, int month, int day) {
        TextView textView = new TextView(getContext());
        textView.setText(String.valueOf(day));
        addView(textView);
    }

}
