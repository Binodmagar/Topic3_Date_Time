package com.binod.topic3_datetime;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    private TextView tvDob;
    private  TextView tvTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDob = findViewById(R.id.tvDob);
        tvDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDatePicker();
            }
        });

        //for time
        tvTime = findViewById(R.id.tvTime);
        tvTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadTimePicker();

            }
        });
    }

    //fucnction loadDatePicker
    private  void loadDatePicker(){
        //use current date as default date in the picker and popup calender of todays
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, this, year, month, day);
        datePickerDialog.show();
    }

    //set the value of calender selected by user in popup calender
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        String date = "Date/Month/Year: " + dayOfMonth + "/" + month + "/" + year;
        tvDob.setText(date);

    }

    //For Time
    //function
    private void loadTimePicker(){
        final Calendar calendar = Calendar.getInstance();
        final int hour = calendar.get(calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(calendar.SECOND);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, this, hour, minute,false);
        timePickerDialog.show();
    }

    //to set time selected by user

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        String time = "Time is: " + hourOfDay + ":" + minute;
        tvTime.setText(time);
    }
}
