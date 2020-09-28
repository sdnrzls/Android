package com.example.test_b_2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText sleeping,codding,reading,english,workout;
    CheckBox cb1,cb2,cb3,cb4;
    Button btn1;
    TextView tv1,tv2,tv3;
    View dilogView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //액티비티.xml의 위젯과 연결
        sleeping = (EditText)findViewById(R.id.sleeping);
        codding = (EditText)findViewById(R.id.codding);
        reading = (EditText)findViewById(R.id.reading);
        english = (EditText)findViewById(R.id.english);
        workout = (EditText)findViewById(R.id.workout);
        cb1 = (CheckBox)findViewById(R.id.cb1);
        cb2 = (CheckBox)findViewById(R.id.cb2);
        cb3 = (CheckBox)findViewById(R.id.cb3);
        cb4 = (CheckBox)findViewById(R.id.cb4);
        btn1 = (Button)findViewById(R.id.btn1);
        tv1 = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.tv2);
        tv3 = (TextView)findViewById(R.id.tv3);

        //이상형 (스피너 설정)
        //스피너에 대입할 배열설정
        String[] type = {"Appearance(외모)","Ability(능력)","Personality(성격)","Lineage(가문)","Faith(신앙)"};
        final Spinner spinner = (Spinner)findViewById(R.id.spinner1);
        //스피너와 배열 연결을 위한 어뎁터 설정
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,type);
        spinner.setAdapter(adapter);

        //다이얼로그 설정
        //dilog1.xml inflate
        dilogView = (View) View.inflate(MainActivity.this,R.layout.dilog1,null);
        //다이얼로그 생성
        final AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
        dlg.setTitle("수면시간");
        dlg.setView(dilogView);
        dlg.setPositiveButton("닫기",null);



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //sleeping(EditText)의 값이 공백일땐 Dialog 창 띄우기
                String sleep = sleeping.getText().toString();
                if(sleep.matches("")){
                    dlg.show();
                }else{//공백이 아닐경우 값을 대입
                    tv1.setText("1. 나는 "+sleep+"시간 잠을 잡니다!");
                }


                ((InputMethodManager)getSystemService(INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(v.getWindowToken(),0);

                ArrayList<Integer>ImageID = new ArrayList<Integer>();

                //그리브뷰 설정
                GridView gv =(GridView)findViewById(R.id.gridView1);
                //어댑터 객체 생성(BaseAdapter를 상속받는)
                MyGridAdapter gAdapter =new MyGridAdapter(getApplicationContext(),ImageID);
                gv.setAdapter(gAdapter);

                int a1 =0;
                int a2 =0;
                int a3 =0;
                int a4 =0;
                //cb1(checkbox)에 체크가 되어있고 EditText의 값이 공백이 아니라면
                if(cb1.isChecked() && !codding.getText().toString().equals("")){
                    //EditText의 값을 int a에 대입 (값을 가져와서  String -> int)
                    String s1 = codding.getText().toString();
                    a1 = Integer.parseInt(s1);
                    //ImageID(ArrayList)에 이미지 삽입
                    ImageID.add(R.drawable.programming);
                }else a1=0;

                if(cb2.isChecked() && !reading.getText().toString().equals("")){
                    String s1 = codding.getText().toString();
                    a2 = Integer.parseInt(s1);
                    ImageID.add(R.drawable.book_reading);
                }else a2=0;

                if(cb3.isChecked() && !english.getText().toString().equals("")){
                    String s1 = codding.getText().toString();
                    a3 = Integer.parseInt(s1);
                    ImageID.add(R.drawable.engligh_study);
                }else a3=0;

                if(cb4.isChecked() && !workout.getText().toString().equals("")){
                    String s1 = codding.getText().toString();
                    a4 = Integer.parseInt(s1);
                    ImageID.add(R.drawable.work_out);
                }else a4=0;

                int sum = a1+a2+a3+a4;
                tv2.setText("2. 나는 꿈을 위해 "+sum+"시간 투자 합니다!");

                //스피너의 선택한 값을 String 형의 변수에 대입
                String ab = spinner.getSelectedItem().toString();
                tv3.setText("3. 나의 이상형은 "+ab+" 입니다!");


            }
        });

    }
    // BaseAdapter를 상속받는 MyGridAdapter 클래스 생성
    public class MyGridAdapter extends BaseAdapter {
        Context context;
        //ArrayList 생성
        ArrayList<Integer>ImageID =null;

        public  MyGridAdapter(Context c,ArrayList<Integer>ImageID){
            context = c;
            this.ImageID = ImageID;
        }
        @Override
        public int getCount() {
           return ImageID.size();
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            //convertView 가 널일때 새로 이미지 뷰 생성
            if(convertView==null){
                imageView = new ImageView(context);
                imageView.setLayoutParams(new GridView.LayoutParams(150,150));
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setPadding(5,5,5,5);
            }else {//널이 아니면 그대로 이미지뷰는 유지
                imageView = (ImageView)convertView;
            }
            //이미지뷰에 이미지 대입
            imageView.setImageResource(ImageID.get(position));
            return imageView;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }


    }
}