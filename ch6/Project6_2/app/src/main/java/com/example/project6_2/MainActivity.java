package com.example.project6_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2;
    ViewFlipper viewf1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button)findViewById(R.id.Btn1);
        btn2 = (Button)findViewById(R.id.Btn2);

        viewf1 = (ViewFlipper)findViewById(R.id.viewf1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewf1.startFlipping();
                viewf1.setFlipInterval(1000);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewf1.stopFlipping();
            }
        });
    }
}