package com.pskovhack.itstimetorelax;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StatisticsActivity extends AppCompatActivity {

    SharedPreferences DATA_BASE;
    public static final String APP = "base";
    public static final String APP_JOB = "job";
    public static final String APP_RELAX = "relax";
    public static final String APP_FATIGUE = "fatigue";
    public static final String APP_WORK = "work";
    public static final String APP_RECREATION = "recreation";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        DATA_BASE = getSharedPreferences(APP, Context.MODE_PRIVATE);

        TextView text_all_work = (TextView) findViewById(R.id.text_info_all_work);
        if (DATA_BASE.getString(APP_WORK, "") != "") {
            int a = Integer.parseInt(DATA_BASE.getString(APP_WORK, ""));
            text_all_work.setText(String.valueOf(a/3600 + "ч:" + a/60%3600 + "м:" + a%60 + "с"));
        }

        TextView text_all_recreation = (TextView) findViewById(R.id.text_info_all_recreation);
        if (DATA_BASE.getString(APP_RECREATION, "") != ""){
            int b = Integer.parseInt(DATA_BASE.getString(String.valueOf(APP_RECREATION), ""));
            text_all_recreation.setText(String.valueOf(b/3600 + "ч:" + b/60%3600 + "м:" + b%60 + "с"));
        }

        TextView text_all_stats = (TextView) findViewById(R.id.text_info_all_stats);
        if(DATA_BASE.getString(APP_JOB, "") != ""
                & DATA_BASE.getString(APP_RELAX, "") != ""
                & DATA_BASE.getString(APP_FATIGUE, "") != ""
                & DATA_BASE.getString(APP_RECREATION, "") != ""
                & DATA_BASE.getString(APP_WORK, "") != "") {
            int a = Integer.parseInt(DATA_BASE.getString(APP_WORK, ""));
            int b = Integer.parseInt(DATA_BASE.getString(APP_RECREATION, ""));
            int c = Integer.parseInt(DATA_BASE.getString(APP_JOB, ""));
            int d = Integer.parseInt(DATA_BASE.getString(APP_RELAX, ""));
            int e = Integer.parseInt(DATA_BASE.getString(APP_FATIGUE, ""));
            if (d != 0 & a != 0 & b != 0 & c != 0 & e != 0) {
                text_all_stats.setText(String.valueOf((c/d+e)/(a/b))+"/35");
            }
            else {
                text_all_stats.setText("Недостатосно данных");
            }
        }
    }
}