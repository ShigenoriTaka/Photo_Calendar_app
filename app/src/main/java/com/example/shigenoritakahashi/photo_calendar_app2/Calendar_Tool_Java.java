package com.example.shigenoritakahashi.photo_calendar_app2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableStringBuilder;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Calendar;

public class Calendar_Tool_Java extends AppCompatActivity {




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        Calendar_Fragment_PagerAdapter adapter = new Calendar_Fragment_PagerAdapter(manager);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(12);

        findViewById(R.id.click).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplication(), Input_Data_activity.class);
                startActivity(intent);

            }

        });

       Test_03 a02 = new Test_03();
       a02.a1();




    }








}
