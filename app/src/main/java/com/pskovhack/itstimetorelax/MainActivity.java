package com.pskovhack.itstimetorelax;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends AppCompatActivity {

    SharedPreferences DATA_BASE;
    public static final String APP = "base";
    public static final String APP_WORK = "work";
    public static final String APP_RECREATION = "recreation";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final int[] l1 = {0};
        final int[] l2 = {0};

        DATA_BASE = getSharedPreferences(APP, Context.MODE_PRIVATE);

        final ViewFlipper viewFlipper = (ViewFlipper) findViewById(R.id.viewflipper);

        Button button_relax = (Button) findViewById(R.id.button_relax);
        Button button_job = (Button) findViewById(R.id.button_job);
        Button button_stop = (Button) findViewById(R.id.button_stop);

        final TextView time_text_recreation = (TextView) findViewById(R.id.text_timer_recreation);

        final CountDownTimer yourCountDownTimer = new CountDownTimer(86400000, 1000) {
            @Override
            public void onTick(long l) {
                l1[0]++;
                if (l1[0] % 7200 == 0 & l1[0] != 0) {
                    LayoutInflater inflater = getLayoutInflater();
                    View layout = inflater.inflate(R.layout.toast_job, (ViewGroup) findViewById(R.id.toast_job));
                    Toast toast = new Toast(getApplicationContext());
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.setDuration(LENGTH_LONG);
                    toast.setView(layout);
                    toast.show();
                }
                time_text_recreation.setText(((86400 - l / 1000) / 3600) + "ч:" + ((86400 - l / 1000) / 60 % 3600) + "м:" + ((86400 - l / 1000) % 60 % 3600) + "c");
            }

            @Override
            public void onFinish() {
                time_text_recreation.setText("");
            }
        }.start();

        final TextView time_text_work = (TextView) findViewById(R.id.text_timer_work);
        final CountDownTimer yourCountDownTimer2 = new CountDownTimer(86400000, 1000) {
            @Override
            public void onTick(long l) {
                l2[0]++;
                if (l2[0] % 7200 == 0 & l2[0] != 0) {
                    LayoutInflater inflater = getLayoutInflater();
                    View layout = inflater.inflate(R.layout.toast_relax, (ViewGroup) findViewById(R.id.toast_relax));
                    Toast toast = new Toast(getApplicationContext());
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.setDuration(LENGTH_LONG);
                    toast.setView(layout);
                    toast.show();
                } else if ((l2[0] + 100) % 10800 == 0) {
                    LayoutInflater inflater = getLayoutInflater();
                    View layout = inflater.inflate(R.layout.toast_water, (ViewGroup) findViewById(R.id.toast_water));
                    Toast toast = new Toast(getApplicationContext());
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.setDuration(LENGTH_LONG);
                    toast.setView(layout);
                    toast.show();
                } else if ((l2[0] + 120) % 14400 == 0) {
                    LayoutInflater inflater = getLayoutInflater();
                    View layout = inflater.inflate(R.layout.toast_water, (ViewGroup) findViewById(R.id.toast_water));
                    Toast toast = new Toast(getApplicationContext());
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.setDuration(LENGTH_LONG);
                    toast.setView(layout);
                    toast.show();
                }
                time_text_work.setText(((86400 - l / 1000) / 3600) + "ч:" + ((86400 - l / 1000) / 60 % 3600) + "м:" + ((86400 - l / 1000) % 60 % 3600) + "с");
            }

            @Override
            public void onFinish() {
                time_text_work.setText("");
            }
        }.start();

        button_relax.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (DATA_BASE.getString(APP_RECREATION, "") != "") {
                    int b = Integer.parseInt(DATA_BASE.getString(APP_RECREATION, ""));
                    l1[0] += b;
                }
                viewFlipper.showNext();
                SharedPreferences.Editor recreation = DATA_BASE.edit();
                recreation.putString(APP_RECREATION, String.valueOf(l1[0]));
                recreation.apply();
                if (l1[0] != 0) {
                    yourCountDownTimer.cancel();
                }
                l1[0] = 0;
                yourCountDownTimer2.start();
            }
        });
        button_job.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (DATA_BASE.getString(APP_WORK, "") != "") {
                    int a = Integer.parseInt(DATA_BASE.getString(APP_WORK, ""));
                    l2[0] += a;
                }
                viewFlipper.showPrevious();
                SharedPreferences.Editor work = DATA_BASE.edit();
                work.putString(APP_WORK, String.valueOf(l2[0]));
                work.apply();
                yourCountDownTimer.start();
                if (l2[0] != 0) {
                    yourCountDownTimer2.cancel();
                }
                l2[0] = 0;
            }
        });
        button_stop.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (DATA_BASE.getString(APP_RECREATION, "") != "") {
                    int b = Integer.parseInt(DATA_BASE.getString(APP_RECREATION, ""));
                    l1[0] += b;
                }
                if (DATA_BASE.getString(APP_WORK, "") != "") {
                    int a = Integer.parseInt(DATA_BASE.getString(APP_WORK, ""));
                    l2[0] += a;
                }
                SharedPreferences.Editor recreation = DATA_BASE.edit();
                recreation.putString(APP_RECREATION, String.valueOf(l1[0]));
                recreation.apply();
                if (l1[0] != 0) {
                    yourCountDownTimer.cancel();
                }
                SharedPreferences.Editor work = DATA_BASE.edit();
                work.putString(APP_WORK, String.valueOf(l2[0]));
                work.apply();
                if (l2[0] != 0) {
                    yourCountDownTimer2.cancel();
                }
                l1[0] = 0;
                l2[0] = 0;
            }
        });
        yourCountDownTimer.cancel();
        yourCountDownTimer2.cancel();
    }
}