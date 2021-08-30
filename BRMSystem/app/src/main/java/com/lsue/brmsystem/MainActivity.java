package com.lsue.brmsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    int prograss = 0;
    ProgressBar pbar1;

    private Handler mhnd = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pbar1 = findViewById(R.id.pBar1);

        final Intent i = new Intent(this,GetDetail_activity.class);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(prograss < 100){
                    prograss++;
                    android.os.SystemClock.sleep(20);
                    mhnd.post(new Runnable() {
                        @Override
                        public void run() {
                            pbar1.setProgress(prograss);
                        }
                    });
                }
                mhnd.post(new Runnable() {
                    @Override
                    public void run() {
//                        button.setVisibility(View.VISIBLE);
//                        pbar1.setVisibility(View.INVISIBLE);
                        startActivity(i);
                    }
                });
            }
        }).start();


//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(i);
//            }
//        });
    }

}
