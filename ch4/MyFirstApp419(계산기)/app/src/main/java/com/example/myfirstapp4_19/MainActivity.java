package com.example.myfirstapp4_19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText Edt1, Edt2;
    Button btn1, btn2, btn3, btn4, btn5;
    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //1.바인딩(View)

        Edt1 = (EditText)findViewById(R.id.Edt1); //2.바인딩(위젯)
        Edt2 = (EditText)findViewById(R.id.Edt2); //2.바인딩(위젯)

        btn1 = (Button)findViewById(R.id.BtnAdd);
        btn2 = (Button)findViewById(R.id.BtnSub);
        btn3 = (Button)findViewById(R.id.BtnMul);
        btn4 = (Button)findViewById(R.id.BtnDiv);
        btn5 = (Button)findViewById(R.id.BtnNa);

        tv1 = (TextView)findViewById(R.id.TextResult);



        //이벤트 처리
        btn1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {


                String str1 = Edt1.getText().toString();
                String str2 = Edt2.getText().toString();
                //둘중에 하나라도 공백이면, 에러표시
                if(str1.equals("") || str2.equals("")){
                    Toast.makeText(MainActivity.this,"빈칸입력",Toast.LENGTH_SHORT).show();
                }
                else{
                    double result = Double.parseDouble(str1)
                            +Double.parseDouble(str2);
                    tv1.setText("결과:" + result);
                }
                return false;
            }
        });

        btn2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                String str1 = Edt1.getText().toString();
                String str2 = Edt2.getText().toString();

                if(str1.equals("") || str2.equals("")){
                    Toast.makeText(MainActivity.this,"빈칸입력",Toast.LENGTH_SHORT).show();
                }
                else {
                    double result = Double.parseDouble(str1)
                            -Double.parseDouble(str2);
                    tv1.setText("결과:" + result);
                }
                return false;
            }
        });

        btn3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                String str1 = Edt1.getText().toString().trim();
                String str2 = Edt2.getText().toString().trim();

                if(str1.equals("") || str2.equals("")){
                    Toast.makeText(MainActivity.this,"빈칸입력",Toast.LENGTH_SHORT).show();
                }
                else{
                    double result = Double.parseDouble(str1)
                            *Double.parseDouble(str2);
                    tv1.setText("결과:" + result);
                }
                return false;
            }
        });

        btn4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                String str1 = Edt1.getText().toString().trim();
                String str2 = Edt2.getText().toString().trim();

                if(str1.equals("") || str2.equals("")){
                    Toast.makeText(MainActivity.this,"빈칸입력",Toast.LENGTH_SHORT).show();
                }
                else{
                    if(str2.equals("0")){
                        Toast.makeText(getApplicationContext(),"0으로 나눌 수 없음",Toast.LENGTH_SHORT).show();
                    }else{
                        double result = Double.parseDouble(str1)
                                /Double.parseDouble(str2);
                        result =(int)(result*100)/100.0;
                        tv1.setText("결과:" + result);

                    }
                }
                return false;
            }
        });

        btn5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                String str1 = Edt1.getText().toString();
                String str2 = Edt2.getText().toString();

                if(str1.equals("") || str2.equals("")){
                    Toast.makeText(MainActivity.this,"빈칸입력",Toast.LENGTH_SHORT).show();
                }
                else{
                    double result = Double.parseDouble(str1)
                            %Double.parseDouble(str2);
                    tv1.setText("결과:" + result);
                }
                return false;
            }
        });


    }
}