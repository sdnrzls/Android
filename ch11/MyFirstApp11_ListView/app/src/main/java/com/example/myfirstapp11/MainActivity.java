package com.example.myfirstapp11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("리스트뷰 테스트");
        //리스트뷰에 나열할 내용을 String 배열로 생성
        final  String[] mid = {"히어로즈","24시","로스트","스몰빌","탐정몽크",
                                "빅뱅이론","프렌즈","덱스터","글리","가쉽걸","테이큰","슈퍼내추럴","브이"};
        //리스트뷰 변수생성 xml<ListView> 대입
        ListView list = (ListView)findViewById(R.id.listView1);
        //1)ArrayAdapter<String>형 변수 선언
        //2)생성자 두번째 파라미터로 리스트뷰 형식(simple_list_item_1)을 선택
        //3)적용할 배열 mid 지정
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mid);
        //생성한 ArrayAdapter을 23번행에 접근한 list 변수 적용
        list.setAdapter(adapter);

        //리스트뷰의 항목을 클릭할때 동작하는 리스너
        //추상메소드인 OnItemClick() 오버라이딩
        //파라미터는 AdapterView,View,클릭한 항목의 순번,항목의 아이디 순이다
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Toast.makeText(getApplicationContext(),mid[arg2],
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}