package com.example.myfisrtapp11_listview_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("리스트뷰 동적 추가/ 삭제예제");

        //ArrayList<String>으로 비어있는 변수선언
        final ArrayList<String>midList = new ArrayList<String>();

        //리스트뷰 변수생성 xml<ListView> 대입
        ListView list = (ListView)findViewById(R.id.listView1);

        //1)ArrayAdapter<String>형 변수 선언
        //2)생성자 두번째 파라미터로 리스트뷰 형식(simple_list_item_single_choice)을 선택
        //3)적용할 배열 midList 지정
        final ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,midList);
        //생성한 ArrayAdapter을 24번행에 접근한 midlist 변수 적용
        list.setAdapter(adapter);

        final EditText edtItem = (EditText)findViewById(R.id.edtItem);
        Button btnAdd = (Button)findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                midList.add(edtItem.getText().toString());//edtItem에 입력한 값을 midList에 대입
                adapter.notifyDataSetChanged();// adapter의notifyDataSetChanged()호출하면 항목을 다시 보여줌
            }
        });
        //리스트뷰의 항목을 클릭할때 동작하는 리스너
        //추상메소드인 OnItemClick() 오버라이딩
        //파라미터는 AdapterView,View,클릭한 항목의 순번,항목의 아이디 순이다
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                midList.remove(position);//롱 클릭하면 삭제
                adapter.notifyDataSetChanged();//adapter항목 보여줌
                return false;
            }
        });
    }
}