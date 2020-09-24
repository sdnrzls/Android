package com.example.test_a_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText cm,kg;
    String gender;
    RadioButton women,men;
    CheckBox cb1,cb2,cb3;
    Button btnSet;
    TextView tv1,tv2;
    Double height,weight,bmi;
    Integer[] image = {R.drawable.ciga,R.drawable.drinking,R.drawable.running,R.drawable.weight};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cm = (EditText)findViewById(R.id.cm);
        kg = (EditText)findViewById(R.id.kg);
        //gender = (RadioGroup)findViewById(R.id.gender);
        women = (RadioButton)findViewById(R.id.women);
        men = (RadioButton)findViewById(R.id.men);
        cb1 = (CheckBox)findViewById(R.id.cb1);
        cb2 = (CheckBox)findViewById(R.id.cb2);
        cb3 = (CheckBox)findViewById(R.id.cb3);
        tv1 = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.tv2);
        btnSet = (Button)findViewById(R.id.btnSet);

        //혈액형 (스피너 설정)
        String[] blood = {"A","B","O","AB"};
        final Spinner spinner = (Spinner)findViewById(R.id.spinner1);
        ArrayAdapter<String>adapter;
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,blood);
        spinner.setAdapter(adapter);




        women.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton rb = (RadioButton)v;
                gender = rb.getText().toString();
            }
        });

        men.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton rb = (RadioButton)v;
                gender = rb.getText().toString();
            }
        });

        btnSet.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String sb = spinner.getSelectedItem().toString();
                tv1.setText(sb+"형 "+gender+" 입니다!");

                String str1 = cm.getText().toString();
                String str2 = kg.getText().toString();
                height = Double.parseDouble(str1);
                weight = Double.parseDouble(str2);

                if(cm.getText().toString()==""||kg.getText().toString()==""){

                }else{
                    bmi = weight/((height/100)+(height/100));
                    tv2.setText("신체질량지수는" +bmi+"입니다!");
                }


                //갤러리 설정
                final Gallery gallery = (Gallery)findViewById(R.id.gallery1);
                MyGallertAdapter galAdapter = new MyGallertAdapter(getApplicationContext());
                gallery.setAdapter(galAdapter);

                if(cb1.isChecked()){

                }else if(cb2.isChecked()){

                }else  if(cb3.isChecked()){

                }
            }
        });
    }

    //갤러리 MyGallertAdapter 클래스 생성
    public class MyGallertAdapter extends BaseAdapter {
        Context context;


        public MyGallertAdapter(Context c){
            context = c;
        }
        @Override
        public int getCount() {
            return image.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new Gallery.LayoutParams(300,300));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setImageResource(image[position]);
            return imageView;
        }

    }
}