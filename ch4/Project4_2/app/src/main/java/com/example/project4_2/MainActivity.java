package com.example.project4_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView text1, text2;
    Switch swiAgree;
    RadioGroup rGroup1;
    RadioButton []rdoBtn = new RadioButton[3];
//  Button btnOK;
    ImageView imgPet;
    Button btnFinish,btnInit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("애완동물 사진 보기");

        text1 = (TextView)findViewById(R.id.Text1);
        swiAgree = (Switch) findViewById(R.id.SwiAgree);

        text2 = (TextView)findViewById(R.id.Text2);
        rGroup1 = (RadioGroup)findViewById(R.id.Rgroup1);
        rdoBtn[0] = (RadioButton)findViewById(R.id.Rdololl);
        rdoBtn[1] = (RadioButton)findViewById(R.id.Rdopie);
        rdoBtn[2] = (RadioButton)findViewById(R.id.Rdoapi44);


//      btnOK=(Button)findViewById(R.id.BtnOK);
        imgPet=(ImageView)findViewById(R.id.ImgPet);
        btnFinish =(Button)findViewById(R.id.BtnFinish);
        btnInit = (Button)findViewById(R.id.BtnInit);

        swiAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(swiAgree.isChecked() == true) { //체크된상태로 바뀌면
                    //아래 위젯들을 화면에 보이게
                    text2.setVisibility(View.VISIBLE);
                    rGroup1.setVisibility(View.VISIBLE);
//                    btnOK.setVisibility(View.VISIBLE);
                    imgPet.setVisibility(View.VISIBLE);
                    btnFinish.setVisibility(View.VISIBLE);
                    btnInit.setVisibility(View.VISIBLE);
                }else{
                    //아래 위젯들을 화면에 안보이게
                    text2.setVisibility(View.INVISIBLE);
                    rGroup1.setVisibility(View.INVISIBLE);
//                    btnOK.setVisibility(View.INVISIBLE);
                    imgPet.setVisibility(View.INVISIBLE);
                    btnFinish.setVisibility(View.INVISIBLE);
                    btnInit.setVisibility(View.INVISIBLE);
                }
            }
        });

        //1.라디오 버튼 3개를 1개로 ? -> 배열로 객체 배열로
        //2.이미지 객체를(예:R.drwawable.dog2)를 1개로 ->배열로

        final int [] nImages = {R.drawable.api44,
                          R.drawable.lollipop,
                          R.drawable.pie};
        for(int i=0; i<nImages.length; ++i){
            final int idx_i = i; //왜 final인가?
            rdoBtn[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imgPet.setImageResource(nImages[idx_i]);
                }
            });
        }


//        rGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                switch (rGroup1.getCheckedRadioButtonId()) {
//                    case R.id.Rdololl:
//                        imgPet.setImageResource(R.drawable.lollipop);
//                        break;
//                    case R.id.Rdopie:
//                        imgPet.setImageResource(R.drawable.pie);
//                        break;
//                    case R.id.Rdoapi44:
//                        imgPet.setImageResource(R.drawable.api44);
//                        break;
//                    default:
//                        Toast.makeText(getApplicationContext(), "안드로이드 먼저 선택하세요",
//                                Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnInit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text2.setVisibility(View.INVISIBLE);
                rGroup1.setVisibility(View.INVISIBLE);
//                    btnOK.setVisibility(View.INVISIBLE);
                imgPet.setVisibility(View.INVISIBLE);
                btnFinish.setVisibility(View.INVISIBLE);
                btnInit.setVisibility(View.INVISIBLE);

                swiAgree.setChecked(false);
                rGroup1.clearCheck();
                imgPet.setImageResource(0); //
            }
        });
    }
}