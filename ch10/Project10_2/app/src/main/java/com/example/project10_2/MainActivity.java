package com.example.project10_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("명화 선호도 투표");

        //투표를 저장할 배열
        final int voteCount[] = new int[9];
        for(int i=0; i<9; i++){
            voteCount[i]=0;
        }
        //이미제뷰 위젯을 저장할 배열
        ImageView image[] = new ImageView[9];
        //이미지뷰 위젯의 id 저장할 배열
        Integer imageId[] = {R.id.iv1,R.id.iv2,R.id.iv3,R.id.iv4,R.id.iv5,
                            R.id.iv6,R.id.iv7,R.id.iv8,R.id.iv9,};

        //그림의 이름을 저장한 배열
        final String imgName[] = {"독서하는 소녀", "꽃장식 모자 소녀", "부태를 든 소녀", "이레느깡 단 베르양",
                                   "잠자는 소녀","테라스의 두 자매","피아노 레슨","피아노 앞의 소녀들", "해변에서"};
        //이미지 뷰의 갯수만큼 반복
        for(int i=0; i<imageId.length; i++){
            final int index; //
            index = i;
            //1개의 이미지뷰에 대해 클릭 리스너를 작성한것과 동일(배열사용)
            image[index] = (ImageView)findViewById(imageId[index]);
            image[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voteCount[index]++; //이미지 뷰 클릭할때마다 해당 이미지 순번의 투표수(voteCount) 배열값 하나씩 증가
                    Toast.makeText(getApplicationContext(),// 이미지뷰 클랙할때마다 해당 이미지의 이름 과 투표수를 메세지로 표출
                            imgName[index] + ": 총"+ voteCount[index]+" 표",
                            Toast.LENGTH_SHORT).show();
                }
            });
        }

        Button btnFinish = (Button)findViewById(R.id.btnResult);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent(현위치,보낼위치)
                Intent intent = new Intent(getApplicationContext(),ResultActivity.class);
                //보낼 내용 첨부
                intent.putExtra("VoteCount",voteCount);//정수형 voteCount 배열을 VoteCount 이름으로 넘김
                intent.putExtra("ImageName",imgName);
                //보냄
                startActivity(intent);
            }
        });
    }
}