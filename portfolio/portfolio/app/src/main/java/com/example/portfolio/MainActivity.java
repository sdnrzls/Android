package com.example.portfolio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("영화 예매");

        //이미지뷰 위젯 저장할 배열
        ImageView image[] = new ImageView[4];
        //이미지뷰 위젯 id 저장할 배열
        final Integer imageId[] = {R.id.ivTenet,R.id.ivMul,R.id.ivSo,R.id.ivBts};
        //이미지뷰 제목 저장할 배열
        final String imgName[] = {"테넷","뮬란","검객","BTS"};

        for(int i=0; i<imageId.length; i++){
            final int index =i;

            image[index] = (ImageView)findViewById(imageId[index]);
            image[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(),MovieActivity.class);
                    intent.putExtra("ImageID",imageId[index]);
                    intent.putExtra("ImageName",imgName[index]);
                    startActivity(intent);
                }
            });
        }



    }
}