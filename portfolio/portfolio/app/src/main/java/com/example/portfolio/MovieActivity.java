package com.example.portfolio;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MovieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie);
        setTitle("좌석 정하기");

        Intent intent = getIntent();

        GridView gv = (GridView)findViewById(R.id.gridView1);

    }

    public class MyGridAdapter extends BaseAdapter{
        Context context;
        //이미지파일
        Integer[] Seat ={};
        //좌석이름
        String[] SeatNum = {"A1","A2","A3","A4","A5","A6","A7","A8",
                            "B1","B2","B3","B4","B5","B6","B7","B8",
                            "C1","C2","C3","C4","C5","C6","C7","C8",
                            "D1","D2","D3","D4","D5","D6","D7","D8"};


        public MyGridAdapter(Context c){
            context = c;
        }

        @Override
        public int getCount() {
            return SeatNum.length;
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
            CheckBox ch = new CheckBox(context);
            ch.setLayoutParams(new GridView.LayoutParams(100,100));
            ch.setPadding(5,5,5,5);


            return null;
        }
    }
}
