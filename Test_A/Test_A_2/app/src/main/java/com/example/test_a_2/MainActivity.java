package com.example.test_a_2;

import androidx.appcompat.app.AlertDialog;
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
    View dialogView;
    ImageView imageView;
    Integer[] image = {R.drawable.drinking,R.drawable.ciga,R.drawable.running,R.drawable.weight};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //액티비티.xml 의 위젯과 연결
        cm = (EditText)findViewById(R.id.cm);
        kg = (EditText)findViewById(R.id.kg);
        women = (RadioButton)findViewById(R.id.women);
        men = (RadioButton)findViewById(R.id.men);
        cb1 = (CheckBox)findViewById(R.id.cb1);
        cb2 = (CheckBox)findViewById(R.id.cb2);
        cb3 = (CheckBox)findViewById(R.id.cb3);
        tv1 = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.tv2);
        btnSet = (Button)findViewById(R.id.btnSet);
        imageView = (ImageView)findViewById(R.id.imageView);
        imageView.setVisibility(View.INVISIBLE);

        //혈액형 (스피너 설정)
        //스피너에 대입할 배열 설정
        String[] blood = {"A","B","O","AB"};
        final Spinner spinner = (Spinner)findViewById(R.id.spinner1);
        //스피너와 배열을 연결할 어뎁터 생성
        ArrayAdapter<String>adapter;
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,blood);
        spinner.setAdapter(adapter);

        //갤러리 설정
        final Gallery gallery = (Gallery)findViewById(R.id.gallery1);
        //갤러리를 연결할 어뎁터 생성
        MyGallertAdapter galAdapter = new MyGallertAdapter(getApplicationContext());
        gallery.setAdapter(galAdapter);

        //다이얼로그 설정 (새창)
        //dilog1.xml로 부터 inflate
        dialogView = (View) View.inflate(MainActivity.this,R.layout.dilog1,null);
        final AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
        dlg.setTitle("키와 체중");
        //inflate 한 dialogView 연결
        dlg.setView(dialogView);
        dlg.setPositiveButton("닫기",null);

        //라디오버튼 클릭되어있는 상태에 따라 변수 지정
        women.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton rb = (RadioButton)v;
                //String형 gender에 버튼의 텍스트값 지정
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
                //스피너에서 선택한 값을 String 형으로 변수 대입
                String sb = spinner.getSelectedItem().toString();
                tv1.setText(sb+"형 "+gender+" 입니다!");
                //키와 체중 EditText의 값을 String 형의 변수에 대입
                String str1 = cm.getText().toString();
                String str2 = kg.getText().toString();

                //위에 대입한 str1과 str2에 값이 공백일경우 다이얼로그 창 띄움
                if(str1.matches("")||str1.matches("")){
                    dlg.show();
                }else{
                    //공백이 아닐경우 Double 형으로 변환하여 계산
                    height = Double.parseDouble(str1);
                    weight = Double.parseDouble(str2);

                    bmi = weight/((height/100)+(height/100));
                    tv2.setText("신체질량지수는 "+Math.round(bmi)+" 입니다!");
                }
                //체크박스 의 체크여부에 따라 갤러리는 보이지않게 설정하고 이미지 보이게 설정
                if(cb1.isChecked()){
                    imageView.setVisibility(View.VISIBLE);
                    gallery.setVisibility(View.INVISIBLE);
                    imageView.setImageResource(R.drawable.drinking);
                }else if(cb2.isChecked()){
                    imageView.setVisibility(View.VISIBLE);
                    gallery.setVisibility(View.INVISIBLE);
                    imageView.setImageResource(R.drawable.ciga);
                }else if(cb3.isChecked()){
                    imageView.setVisibility(View.VISIBLE);
                    gallery.setVisibility(View.INVISIBLE);
                    imageView.setImageResource(R.drawable.running);
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