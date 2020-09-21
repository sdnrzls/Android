package com.example.myfirstapp10;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

            Button btn3 = (Button)findViewById(R.id.btn3);
            EditText edt3 = (EditText)findViewById(R.id.edt3);

            Intent in2 = getIntent();

            int n = 0;
            n = in2.getIntExtra("Data1",0);
            edt3.setText(""+n);

            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
    }
}
