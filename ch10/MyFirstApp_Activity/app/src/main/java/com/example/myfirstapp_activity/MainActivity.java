package com.example.myfirstapp_activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button)findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() { //버튼 이벤트 (버튼클릭시)
            @Override
            public void onClick(View v) {
                EditText edtNum1 = (EditText) findViewById(R.id.edtNum1);//View에있는 EditTExt id 를 변수에 대입
                EditText edtNum2 = (EditText) findViewById(R.id.edtNum2);

                RadioGroup rg = (RadioGroup)findViewById(R.id.rg);//View에있는 RadioGroup id 를 변수에 대입

                //Intent 객체 생성 (현위치 , 보낼위치)
                Intent intent = new Intent(getApplicationContext(), Mainactivity2.class );
                //Intent 객체에 값 넣기
                intent.putExtra("Num1", Integer.parseInt(edtNum1.getText().toString()));
                intent.putExtra("Num2", Integer.parseInt(edtNum2.getText().toString()));
                intent.putExtra("rg",rg.getCheckedRadioButtonId());
                //연결 시작
                startActivityForResult(intent,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            double result = data.getDoubleExtra("result", 0);
            Toast.makeText(getApplicationContext(), "합계 : " + result, Toast.LENGTH_SHORT).show();
        }
    }
}