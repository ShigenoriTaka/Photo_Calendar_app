package com.example.shigenoritakahashi.photo_calendar_app2;

import android.util.Log;

import java.lang.reflect.Member;
import java.util.ArrayList;

public class TaskData_manager {
    public ArrayList<Task_Data> data_List = new ArrayList<Task_Data>();

    public void add(Task_Data data){
        data_List.add(data);
    }

    public void delete(Task_Data data){
        data_List.remove(data);
    }

    public void log(){
        Log.e("paypay", "listsize=" + data_List.size());
        String str = "";
        for (int i = 0; i < data_List.size(); i++){
            str += "title:" + data_List.get(i).Task_title + ":::memo:" + data_List.get(i).Memo + "....";
        }
        Log.e("paypay2", str);
    }



}
