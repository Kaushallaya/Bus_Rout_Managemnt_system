package com.lsue.brmsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class GetDetail_activity extends AppCompatActivity {

    Spinner spn1, spn2;
    Button btnsub;
    String[] city;
    String from,to;
    TextView txtTime;
    int hour,min;
    TimePickerDialog.OnTimeSetListener mTime;

    private static final String TAG = "GetDetail_activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_detail_activity);

        spn1 = findViewById(R.id.spinFrom);
        spn2 = findViewById(R.id.spinTo);
        btnsub = findViewById(R.id.btngda);
        txtTime = findViewById(R.id.textTime);


        city = getResources().getStringArray(R.array.stop_names);

//        ArrayAdapter adp = new ArrayAdapter(this,android.R.layout.simple_spinner_item,city);
//        adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spn1.setAdapter(adp);

        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                from = city[position];
                Toast.makeText(GetDetail_activity.this,from,Toast.LENGTH_SHORT ).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spn2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                to = city[position];
                Toast.makeText(GetDetail_activity.this,to,Toast.LENGTH_SHORT ).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        txtTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cal = Calendar.getInstance();
                hour=cal.get(cal.HOUR_OF_DAY);
                min=cal.get(cal.MINUTE);

                TimePickerDialog dialog= new TimePickerDialog(GetDetail_activity.this,android.R.style.Theme_Holo_Dialog,mTime,hour,min,false);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mTime = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hour, int min) {
                String Time = min+" : "+hour ;
                txtTime.setText(Time);
            }
        };

    }


}
