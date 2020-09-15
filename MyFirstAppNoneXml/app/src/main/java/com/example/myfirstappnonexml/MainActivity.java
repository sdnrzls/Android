package com.example.myfirstappnonexml;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //xml을 안쓰겠다

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);

        LinearLayout baseLayout = new LinearLayout(this);
        baseLayout.setOrientation(LinearLayout.VERTICAL);


        setContentView(baseLayout,params);

        //1.에디트 텍스트
        EditText edt = new EditText(this);
        edt.setHint("입력하세요");
        baseLayout.addView(edt);


        //2.버튼
        Button btn = new Button(this);
        btn.setText("버튼입니다");
        btn.setBackgroundColor(Color.MAGENTA);
        baseLayout.addView(btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"버튼",Toast.LENGTH_SHORT).show();
            }
        });

        //3.텍스트 뷰
        TextView tv = new TextView(this);
        tv.setText("텍스트뷰입니다");
        tv.setTextSize(20);

    }
}