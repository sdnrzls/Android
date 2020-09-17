package com.example.project7_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    EditText edt1;
    ImageView iv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("제주도 풍경");

        edt1 = (EditText)findViewById(R.id.edt1);
        iv1 = (ImageView)findViewById(R.id.iv1);
    }

    @Override//Generate - override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu1, menu);
        return  true;
    }
    float f2 = 0;//누적연산
    @Override//Generate - override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemRotate:
                String str1 = edt1.getText().toString();
                Float f1 = Float.parseFloat(str1);
                f2 = f2 + f1;
                iv1.setRotation(f2);
                return true;
            case R.id.item1:
                iv1.setImageResource(R.drawable.jeju1);
                item.setChecked(true);
                return true;
            case R.id.item2:
                iv1.setImageResource(R.drawable.jeju10);
                item.setChecked(true);
                return true;
            case R.id.item3:
                iv1.setImageResource(R.drawable.jeju15);
                item.setChecked(true);
                return true;
        }
        return false;
    }
}