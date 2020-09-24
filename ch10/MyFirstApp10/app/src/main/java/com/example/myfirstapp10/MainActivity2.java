package com.example.myfirstapp10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button btn2 = (Button)findViewById(R.id.btn2);
        EditText edt2 = (EditText)findViewById(R.id.edt2);

        Intent in2 = getIntent(); // MainActivity 에서 Intent한 값을 받음

        int n = 0; //변수지정
        n = in2.getIntExtra("Data1",0); // Intent로 받은 값을 n에 대입
        edt2.setText(""+n);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}