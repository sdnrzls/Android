package com.example.project5_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edt1,edt2;
    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView textResult;
    String num1,num2;
    Integer result;
    //1.버튼을 배열로
    Button btnArr[] = new Button[10];

    //2.버튼의 ID를 배열로 , 목적은 반복문에서 인덱스(i)를 사용하기위해
    Integer[] btnIDs = {R.id.BtnNum0,R.id.BtnNum1,R.id.BtnNum2,R.id.BtnNum3,R.id.BtnNum4,
                            R.id.BtnNum5,R.id.BtnNum6,R.id.BtnNum7,R.id.BtnNum8,R.id.BtnNum9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        edt1 = (EditText)findViewById(R.id.Edt1);
        edt2 = (EditText)findViewById(R.id.Edt2);

        btnAdd =(Button)findViewById(R.id.BtnAdd);
        btnSub =(Button)findViewById(R.id.BtnSub);
        btnMul =(Button)findViewById(R.id.BtnMul);
        btnDiv =(Button)findViewById(R.id.BtnDiv);

        textResult = (TextView)findViewById(R.id.TextResult);

        //3.바인딩을 배열에
        for(int i=0; i<btnArr.length; i++){
            btnArr[i] = (Button)findViewById(btnIDs[i]);
        }
        //4.이벤트 처리를 배열에
        for(int i=0; i<btnArr.length; i++) {
            final int idx = i;
            btnArr[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (edt1.isFocused()) {
                        String str1 = edt1.getText().toString()
                                + btnArr[idx].getText().toString();
                        edt1.setText(str1);
                    } else if (edt2.isFocused()) {
                        String str1 = edt2.getText().toString()
                                + btnArr[idx].getText().toString();
                        edt2.setText(str1);
                    } else {
                        Toast.makeText(getApplicationContext(), "에디터를 선택해주세요",
                                Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }

        btnAdd.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1 = edt1.getText().toString();
                num2 = edt2.getText().toString();
                //둘중에 하나라도 공백이면, 에러표시
                if(num1.equals("") || num2.equals("")){
                    Toast.makeText(MainActivity.this,"빈칸입력",Toast.LENGTH_SHORT).show();
                }
                else{
                     result = Integer.parseInt(num1)
                            +Integer.parseInt(num2);
                    textResult.setText("결과:" + result);
                }
                return false;
            }
        });

        btnSub.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1 = edt1.getText().toString();
                num2 = edt2.getText().toString();
                //둘중에 하나라도 공백이면, 에러표시
                if(num1.equals("") || num2.equals("")){
                    Toast.makeText(MainActivity.this,"빈칸입력",Toast.LENGTH_SHORT).show();
                }
                else{
                    result = Integer.parseInt(num1)
                            -Integer.parseInt(num2);
                    textResult.setText("결과:" + result);
                }
                return false;
            }
        });

        btnMul.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1 = edt1.getText().toString();
                num2 = edt2.getText().toString();
                //둘중에 하나라도 공백이면, 에러표시
                if(num1.equals("") || num2.equals("")){
                    Toast.makeText(MainActivity.this,"빈칸입력",Toast.LENGTH_SHORT).show();
                }
                else{
                    result = Integer.parseInt(num1)
                            *Integer.parseInt(num2);
                    textResult.setText("결과:" + result);
                }
                return false;
            }
        });

        btnDiv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1 = edt1.getText().toString();
                num2 = edt2.getText().toString();
                //둘중에 하나라도 공백이면, 에러표시
                if(num1.equals("") || num2.equals("")){
                    Toast.makeText(MainActivity.this,"빈칸입력",Toast.LENGTH_SHORT).show();
                }
                else{
                    result = Integer.parseInt(num1)
                            /Integer.parseInt(num2);
                    textResult.setText("결과:" + result);
                }
                return false;
            }
        });


    }
}