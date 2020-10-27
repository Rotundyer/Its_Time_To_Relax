package com.pskovhack.itstimetorelax;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.CollationElementIterator;

public class ParametersActivity extends AppCompatActivity {

    SharedPreferences DATA_BASE;
    public static final String APP = "base";
    public static final String APP_JOB = "job";
    public static final String APP_RELAX = "relax";
    public static final String APP_FATIGUE = "fatigue";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parameters);

        DATA_BASE = getSharedPreferences(APP, Context.MODE_PRIVATE);

        final SeekBar how_many_job_seekBar = (SeekBar) findViewById(R.id.how_many_job_seekBar);
        final TextView how_many_job = (TextView) findViewById(R.id.how_many_job);
        if (DATA_BASE.getString(APP_JOB, "") != "") {
            how_many_job.setText(DATA_BASE.getString(APP_JOB, ""));
            how_many_job_seekBar.setProgress(Integer.parseInt(DATA_BASE.getString(APP_JOB, "")));
        }

        final SeekBar how_many_relax_seekBar = (SeekBar) findViewById(R.id.how_many_relax_seekBar);
        final TextView how_many_relax = (TextView) findViewById(R.id.how_many_relax);
        if (DATA_BASE.getString(APP_RELAX, "") != "") {
            how_many_relax.setText(DATA_BASE.getString(APP_RELAX, ""));
            how_many_relax_seekBar.setProgress(Integer.parseInt(DATA_BASE.getString(APP_RELAX, "")));
        }

        final SeekBar how_many_fatigue_seekBar = (SeekBar) findViewById(R.id.how_many_fatigue_seekBar);
        final TextView how_many_fatigue = (TextView) findViewById(R.id.how_many_fatigue);
        if (DATA_BASE.getString(APP_FATIGUE, "") != "") {
            how_many_fatigue.setText(DATA_BASE.getString(APP_FATIGUE, ""));
            how_many_fatigue_seekBar.setProgress(Integer.parseInt(DATA_BASE.getString(APP_FATIGUE, "")));
        }

        how_many_job_seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                how_many_job.setText(String.valueOf(progress));
                SharedPreferences.Editor job = DATA_BASE.edit();
                job.putString(APP_JOB, how_many_job.getText().toString());
                job.apply();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        how_many_relax_seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                how_many_relax.setText(String.valueOf(progress));
                SharedPreferences.Editor relax = DATA_BASE.edit();
                relax.putString(APP_RELAX, how_many_relax.getText().toString());
                relax.apply();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        how_many_fatigue_seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                how_many_fatigue.setText(String.valueOf(progress));
                SharedPreferences.Editor fatigue = DATA_BASE.edit();
                fatigue.putString(APP_FATIGUE, how_many_fatigue.getText().toString());
                fatigue.apply();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }
}