package com.example.shigenoritakahashi.photo_calendar_app2;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Member;
import java.util.ArrayList;

public class TaskData_manager {

    public int ID_NO = 0;
    public ArrayList<Task_Data>  data_List = new ArrayList<Task_Data>();

    public void add(Task_Data data){

        data.ID = ID_NO;
        ID_NO ++;
        data_List.add(data);
    }

    public void delete(Task_Data data){
        data_List.remove(data);
    }

    public void log(){
        Log.e("paypay", "listsize=" + data_List.size());
        String str = "";
        for (int i = 0; i < data_List.size(); i++){
            str += "title:" + data_List.get(i).Task_title + data_List.get(i).ID + ":::memo:" + data_List.get(i).Memo + "....";
        }
        Log.e("paypay2", str);
    }

    public void data_save(Activity activity) {

        try {
            JSONArray jsonArray = new JSONArray();

            for (Task_Data data : data_List) {
                org.json.JSONObject json_Shedulu_DATA = new org.json.JSONObject();
                json_Shedulu_DATA.put("ID",data.ID);
                json_Shedulu_DATA.put("start_Time",data.start_Time);
                json_Shedulu_DATA.put("end_Time",data.end_Time);
                json_Shedulu_DATA.put("Tag_ID01",data.Tag_ID01);
                json_Shedulu_DATA.put("Task_title",data.Task_title);
                json_Shedulu_DATA.put("Memo",data.Memo);
                json_Shedulu_DATA.put("address",data.address);

                jsonArray.put(json_Shedulu_DATA);
            }
            SharedPreferences sharedPreferences = activity.getSharedPreferences("Schedule_Data", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("S_save_data", jsonArray.toString());
            editor.apply();


        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    public void data_Read(Activity activity) {
        SharedPreferences data_Read = activity.getSharedPreferences("Schedule_Data", Context.MODE_PRIVATE);
        String Schedule_jsonArray = data_Read.getString("S_save_data"," ");
        Log.e("TEST","JSONちゃんと入力してあるか==" + Schedule_jsonArray);

        data_List.clear();

        try {
            JSONArray jsonArray = new JSONArray(Schedule_jsonArray);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject DATA = jsonArray.getJSONObject(i);
                int ID = DATA.getInt("ID");
                long start_Time = DATA.getLong("start_Time");
                long end_Time = DATA.getLong("end_Time");
                int Tag_ID01 = DATA.getInt("Tag_ID01");
                String Task_title = DATA.getString("Task_title");
                String Memo = DATA.getString("Memo");
                String address = DATA.optString("address", "def");

                Task_Data task_data = new Task_Data();
                task_data.ID = ID;
                task_data.start_Time = start_Time;
                task_data.end_Time = end_Time;
                task_data.Tag_ID01 = Tag_ID01;
                task_data.Task_title = Task_title;
                task_data.Memo = Memo;
                task_data.address = address;

                data_List.add(task_data);

            }
        } catch (JSONException e){
            e.printStackTrace();
        }

    }



}
