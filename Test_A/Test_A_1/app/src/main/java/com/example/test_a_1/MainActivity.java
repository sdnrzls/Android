package com.example.test_a_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btnRandom, btnDap;
    EditText num1,num2,num3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("문제 맞추기");

        btnRandom = (Button)findViewById(R.id.btnRandom);
        btnDap = (Button)findViewById(R.id.btnDap);

        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //랜덤 변수 생성
                int rand1 = new Random().nextInt(8)+2;
                int rand2 = new Random().nextInt(8)+2;

                //랜덤 변수 EditText에 대입
                num1 =(EditText)findViewById(R.id.Num1);
                num1.setText(Integer.toString(rand1));
                num2 =(EditText)findViewById(R.id.Num2);
                num2.setText(Integer.toString(rand2));

                btnDap.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //EditText값 int 변수에 대입
                        int a = Integer.parseInt(num1.getText().toString());
                        int b = Integer.parseInt(num2.getText().toString());
                        num3 = (EditText)findViewById(R.id.Num3);
                        int c = Integer.parseInt(num3.getText().toString());

                        if(a * b == c){
                            Toast.makeText(getApplicationContext(),"정답입니다",Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getApplicationContext(),"오답입니다",Toast.LENGTH_SHORT).show();
                            //오답일 경우 ListView에 정답 생성
                            //배열 생성
                            String[] mid = new String[9];
                            for(int i=0; i<9; i++){
                                //mid[i]는 EditText(a) X i+1 = a*i
                                mid[i] = String.valueOf(a) + "X" + (i+1) + "=" + (a*(i+1));
                            }
                            //xml 리스트뷰 연결
                            ListView list = (ListView)findViewById(R.id.listView);
                            //리스트뷰에 연결할 어뎁터 생성
                            ArrayAdapter<String>adapter = new ArrayAdapter<>(getApplicationContext(),
                                    android.R.layout.simple_list_item_1,mid);
                            list.setAdapter(adapter);

                        }
                    }
                });
            }
        });
    }
}