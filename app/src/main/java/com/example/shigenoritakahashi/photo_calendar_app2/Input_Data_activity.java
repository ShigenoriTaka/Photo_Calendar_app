package com.example.shigenoritakahashi.photo_calendar_app2;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

public class Input_Data_activity extends AppCompatActivity {
    public TaskData_manager taskData_manager = new TaskData_manager();
    public int Task_Data_ID = -1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_data);

        findViewById(R.id.enter).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Task_Data task_data;

                //Task_Dataがない場合、新規保存する。
                if (Task_Data_ID < 0) {
                    task_data = new Task_Data();
                    taskData_manager.add(task_data);
                    Task_Data_ID = task_data.ID;
                } else {
                    //Task_Data_IDある場合、既存のデータを編集する。
                    task_data = taskData_manager.get(Task_Data_ID);
                }


                EditText edit = (EditText)findViewById(R.id.eventtitle);
                SpannableStringBuilder sb = (SpannableStringBuilder)edit.getText();
                task_data.Task_title = sb.toString();

                edit = (EditText)findViewById(R.id.editMemo);
                sb = (SpannableStringBuilder)edit.getText();
                task_data.Memo = sb.toString();

                taskData_manager.log();
                test_save_load();



            }

        });




    }
    private void test_save_load() {
        taskData_manager.data_save(this);
        taskData_manager.data_Read(this);
    }

}
