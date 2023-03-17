package com.example.ktra1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class DateTimePickerActivity extends AppCompatActivity implements View.OnClickListener {
    EditText timeText, dateText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time_picker);

        this.initView();
        this.setOnClick();
    }

    private void setOnClick() {
        this.timeText.setOnClickListener(this);
        this.dateText.setOnClickListener(this);
    }

    private void initView() {
        this.timeText = findViewById(R.id.timeText);
        this.dateText = findViewById(R.id.dateText);
    }

    @Override
    public void onClick(View view) {
        Calendar calendar = Calendar.getInstance();
        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        if (view == timeText) {
            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int h, int m) {
                    timeText.setText(h + ":" + m);
                }
            }, hourOfDay, minute, true);

            timePickerDialog.show();
        }

        if (view == dateText) {
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int yy, int mm, int dd) {
                    dateText.setText(yy + "/" + (mm + 1) + "/" + dd);
                }
            }, year, month, month);

            datePickerDialog.show();
        }
    }


}