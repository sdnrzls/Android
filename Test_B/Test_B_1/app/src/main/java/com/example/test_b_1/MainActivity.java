package com.example.test_b_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button  btnDap;
    EditText num1;
    EditText num2;
    EditText num3;
    TextView tv1;
    RadioButton sum,sub,mul,div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //xml의 위젯과 연결
        tv1 = (TextView)findViewById(R.id.tv1);
        sum = (RadioButton)findViewById(R.id.Sum);
        sub = (RadioButton)findViewById(R.id.Sub);
        mul = (RadioButton)findViewById(R.id.Mul);
        div = (RadioButton)findViewById(R.id.Div);
        num1 = (EditText)findViewById(R.id.Num1);
        num2 = (EditText)findViewById(R.id.Num2);
        num3 = (EditText)findViewById(R.id.Num3);
        btnDap =(Button)findViewById(R.id.btnDap);


        //RadiButton의 클릭에따라 tv1(TextView) 값 변경
        sum.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              tv1.setText("+");
          }
         });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setText("-");
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setText("*");
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setText("/");
            }
        });

        btnDap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //num1,num2(EditText)의 값을 Double형으로 변환하여 변수에 대입
                double a1 = Double.parseDouble(num1.getText().toString());
                double a2 = Double.parseDouble(num2.getText().toString());
                double dap=0;

                // tv1(TextView) 값에 따라 계산 변수 지정
                if(tv1.getText().equals("+")){
                    dap =a1+a2;
                }else if(tv1.getText().equals("-")){
                    dap =a1-a2;
                }else if(tv1.getText().equals("*")){
                    dap =a1*a2;
                }else if(tv1.getText().equals("/")){
                    dap =a1/a2;
                }
                //int 형 dap변수를 String형으로 변환후 num3(EdtiText)에 대입
                String dap2 = String.valueOf(dap);
                num3.setText(dap2);

            }
        });

    }
}