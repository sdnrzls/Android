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

        Intent intent = getIntent();// Intent 변수 생성 Main에서 받아온 값 대입
        //intent 안의 값들을 변수지정하여 대입
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

                //Intent 선언
                Intent outintent = new Intent(getApplicationContext(),MainActivity.class);
                //Intent(변수명 outintent)에 값을대입
                outintent.putExtra("result",result);
                //메인 액티비티로 돌려준다
                setResult(RESULT_OK, outintent);
                finish();
            }
        });

    }
}
