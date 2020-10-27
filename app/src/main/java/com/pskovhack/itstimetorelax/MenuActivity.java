package com.pskovhack.itstimetorelax;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button job_relax = (Button) findViewById(R.id.button_job_relax);
        job_relax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        Button parameters = (Button) findViewById(R.id.button_parameters);
        parameters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, ParametersActivity.class);
                startActivity(intent);
            }
        });
        Button statistics = (Button) findViewById(R.id.button_statistics);
        statistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, StatisticsActivity.class);
                startActivity(intent);
            }
        });
        Button spravka = (Button) findViewById(R.id.button_spravka);
        spravka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, SpravkaActivity.class);
                startActivity(intent);
            }
        });
        Button razrab = (Button) findViewById(R.id.button_rzrab);
        razrab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, RazrabActivity.class);
                startActivity(intent);
            }
        });
    }
}
