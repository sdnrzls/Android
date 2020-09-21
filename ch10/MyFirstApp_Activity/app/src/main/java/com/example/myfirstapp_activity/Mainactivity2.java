package com.example.myfirstapp_activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Mainactivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        setTitle("Secont 액티비티");

        Intent intent = getIntent();
        final int num1 = intent.getIntExtra("Num1",0);
        final int num2 = intent.getIntExtra("Num2",0);
        final Integer rg = intent.getIntExtra("rg",0);

        Button btn2 = (Button)findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            //계산
            @Override
            public void onClick(View v) {
                double result = 0;
                switch (rg) {
                    case R.id.sum:
                        result = (double) (num1 + num2);
                        break;
                    case R.id.sub:
                        result = (double) (num1 - num2);
                        break;
                    case R.id.mul:
                        result = (double) (num1 * num2);
                        break;
                    case R.id.div:
                        result = (double) (num1 / num2);
                        break;
                }

                //intent 선언
                Intent outintent = new Intent(getApplicationContext(),MainActivity.class);
                outintent.putExtra("result",result);
                setResult(RESULT_OK, outintent);
                finish();
            }
        });

    }
}
