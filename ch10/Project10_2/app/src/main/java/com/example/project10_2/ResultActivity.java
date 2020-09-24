package com.example.project10_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        setTitle("투표 결과");

        //Main에서 넘긴 인텐트 값을 getIntent()로 넘겨받음
        Intent intent = getIntent();
        //가져온 값을 변수에 대입
        int[] voteResult = intent.getIntArrayExtra("VoteCount");//정수형 배열이라 getIntArrayExtra
        String[] imageName = intent.getStringArrayExtra("ImageName");//문자열 배열이라 getStringArrayExtra
        //넘겨받은 그림파일 이름의 갯수만큼 텍스트뷰와 레이팅바 위젯 배열 변수 선언
        TextView tv[] = new TextView[imageName.length];
        RatingBar rbar[] = new RatingBar[imageName.length];
        //텍스트뷰와 레이팅바의 위젯id배열 선언
        Integer tvID[] ={R.id.tv1,R.id.tv2,R.id.tv3,R.id.tv4,R.id.tv5,
                        R.id.tv6, R.id.tv7,R.id.tv8,R.id.tv9};
        Integer rbarID[] = {R.id.rbar1,R.id.rbar2,R.id.rbar3,R.id.rbar4,R.id.rbar5,
                            R.id.rbar6,R.id.rbar7,R.id.rbar8,R.id.rbar9};
        //위젯id 배열위에 위젯을 대입
        for(int i=0; i<voteResult.length; i++){
            tv[i] = (TextView)findViewById(tvID[i]);
            rbar[i] = (RatingBar)findViewById(rbarID[i]);
        }
        //텍스트 뷰에는 파일이름과 레이팅바의 투표수 적용
        for(int i=0; i<voteResult.length; i++){
            tv[i].setText(imageName[i]);
            rbar[i].setRating((float) voteResult[i]);
        }

        //이미지 배열 생성
        Integer imageFileID[] = {R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4,R.drawable.pic5,
                R.drawable.pic6,R.drawable.pic7,R.drawable.pic8,R.drawable.pic9};
        int max = 0;
        int max_index =0;

        for(int i=0; i<voteResult.length; i++){
            if(voteResult[i]> voteResult[max]){
                max = voteResult[i];
                max_index = i;
            }
        }
        TextView tvTop = (TextView)findViewById(R.id.tvTop);
        ImageView ivTop = (ImageView)findViewById(R.id.ivTop);

        tvTop.setText(imageName[max_index]);
        ivTop.setImageResource(imageFileID[max_index]);
        //-----------------------------------------------------------------------------//


        Button btnReturn = (Button)findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
