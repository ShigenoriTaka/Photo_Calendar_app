package com.example.shigenoritakahashi.photo_calendar_app2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.Calendar;
import java.util.HashMap;

public class Calendar_Fragment_PagerAdapter extends FragmentPagerAdapter {

    public class YearMonth {
        int y;
        int m;
    }
    HashMap<Integer, YearMonth> ym_list = new HashMap<>();


    public Calendar_Fragment_PagerAdapter(FragmentManager fm) {
        super(fm);
        CreateYMList();

    }
    private void CreateYMList() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR) -1 ,calendar.get(Calendar.MONTH), 1);
        for(int i = 0; i < 24;i++) {
            YearMonth ym = new YearMonth();

            ym.y = calendar.get(Calendar.YEAR);
            ym.m = calendar.get(Calendar.MONTH);
            calendar.add(Calendar.MONTH, 1);
            ym_list.put(i, ym);
        }


    }

    @Override
    public Fragment getItem(int i) {
        YearMonth ym = ym_list.get(i);
        Calendar_Fragment c_fragment = Calendar_Fragment.newInstance(ym);
        return c_fragment;
    }

    @Override
    public int getCount() {
        return 24;
    }
}
