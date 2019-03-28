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


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_data);

        findViewById(R.id.enter).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Task_Data data = new Task_Data();

                EditText edit = (EditText)findViewById(R.id.eventtile);
                SpannableStringBuilder sb = (SpannableStringBuilder)edit.getText();
                data.Task_title = sb.toString();

                edit = (EditText)findViewById(R.id.editMemo);
                sb = (SpannableStringBuilder)edit.getText();
                data.Memo = sb.toString();

                taskData_manager.add(data);

                taskData_manager.log();


            }

        });




    }

}
