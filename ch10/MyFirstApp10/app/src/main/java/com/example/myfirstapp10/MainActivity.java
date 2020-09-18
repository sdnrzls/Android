package com.example.myfirstapp10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = (Button) findViewById(R.id.btn1);
        final EditText edt1 = (EditText) findViewById(R.id.edt1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this,
                        MainActivity2.class);

                String str1 = edt1.getText().toString();

                int n = Integer.parseInt(str1);

//                in.putExtra("Data1", str1);
                in.putExtra("Data1", n);

                startActivity(in);
            }
        });
    }
}