package com.example.portfolio;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

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
        final Integer imagedr[]={R.drawable.tenet,R.drawable.mul,R.drawable.sode,R.drawable.bts};
        //이미지뷰 제목 저장할 배열
        final String imgName[] = {"테넷","뮬란","검객","BTS"};

        for(int i=0; i<imageId.length; i++){
            final int index;
            index = i;
            image[index] = (ImageView)findViewById(imageId[index]);
            image[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final View dlgView = (View) View.inflate(MainActivity.this,R.layout.time,null);
                    AlertDialog.Builder dg = new AlertDialog.Builder(MainActivity.this);
                    dg.setTitle("영화 시간");
                    dg.setView(dlgView);
                    dg.setPositiveButton("시간선택완료", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            RadioGroup rg = (RadioGroup)dlgView.findViewById(R.id.rg);
                            RadioButton rd = (RadioButton)dlgView.findViewById(rg.getCheckedRadioButtonId());
                            String time = rd.getText().toString();

                            Intent intent = new Intent(getApplicationContext(),MovieActivity.class);
                            intent.putExtra("ImageDR",imagedr[index]);
                            intent.putExtra("ImageName",imgName[index]);
                            intent.putExtra("Time",time);
                            startActivity(intent);
                        }
                    });
                    dg.setNegativeButton("닫기",null);
                    dg.show();


                }
            });
        }

        }
    }