package com.example.myfirstapp10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
//액티비티(Activity) : 화면을 구성하는 가장 기본적인 컴포넌트

//AppCompatActivity 클래스를 상속
public class MainActivity extends AppCompatActivity {
    RadioButton rdsecond, rdthird;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = (Button) findViewById(R.id.btn1);
        final EditText edt1 = (EditText) findViewById(R.id.edt1);
        RadioGroup rg = (RadioGroup)findViewById(R.id.rg);
        rdsecond = (RadioButton) findViewById(R.id.rdsecond);
        rdthird = (RadioButton) findViewById(R.id.rdthird);

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(rdsecond.isChecked()) {

                        Intent in = new Intent(MainActivity.this,
                                MainActivity2.class); //연결(통로) 객체(현위치,이동할 위치)

                        String str1 = edt1.getText().toString(); //Edit Text(edt1)의 값을 변수지정

                        int n = Integer.parseInt(str1); //Integer로 숫자로 변환

//                in.putExtra("Data1", str1);
                        in.putExtra("Data1", n);//값을 연결객체에 삽입 (변수명 , 값)

                        startActivity(in); //연결 시작(이동)
                    }else if(rdthird.isChecked()) {
                        Intent in = new Intent(MainActivity.this,
                                MainActivity3.class); //연결(통로) 객체(현위치,이동할 위치)

                        String str1 = edt1.getText().toString();

                        int n = Integer.parseInt(str1);

//                in.putExtra("Data1", str1);
                        in.putExtra("Data1", n);//값을 연결객체에 삽입

                        startActivity(in); //이동
                    }
                }
            });

        }
    }
