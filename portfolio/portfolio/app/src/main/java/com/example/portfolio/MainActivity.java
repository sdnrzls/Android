package com.example.portfolio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.example.portfolio.NetWork.NetworkGet;
import com.example.portfolio.NetWork.NetworkInsert;

public class MainActivity extends AppCompatActivity {
    TextView tvid;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0,1,0,"로그인");
        menu.add(0,2,0,"회원가입");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case 1:
                final View dlgView = (View) View.inflate(MainActivity.this,R.layout.login,null);
                AlertDialog.Builder dg = new AlertDialog.Builder(MainActivity.this);
                dg.setTitle("로그인");
                dg.setView(dlgView);

                dg.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String id = ((EditText)dlgView.findViewById(R.id.edtID)).getText().toString();
                        String password = ((EditText)dlgView.findViewById(R.id.edtpassword)).getText().toString();

                        if(id.length() == 0 || password.length() == 0){
                            Toast toast = Toast.makeText(MainActivity.this,"아이디와 비밀번호를 입력해주세요",Toast.LENGTH_SHORT);
                            toast.show();
                            return;
                        }

                        new NetworkGet().execute(id,password);
                        tvid=(TextView)findViewById(R.id.tvid);
                        tvid.setText(id);
                    }
                });
                dg.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                dg.show();
                return true;

            case 2:
                final View dlgView_2 = (View) View.inflate(MainActivity.this,R.layout.join,null);
                AlertDialog.Builder dg_2 = new AlertDialog.Builder(MainActivity.this);
                dg_2.setTitle("회원가입");
                dg_2.setView(dlgView_2);
                dg_2.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String id = ((EditText)dlgView_2.findViewById(R.id.edtID)).getText().toString();
                        String name = ((EditText)dlgView_2.findViewById(R.id.edtName)).getText().toString();
                        String password = ((EditText)dlgView_2.findViewById(R.id.edtpassword)).getText().toString();
                        String phone = ((EditText)dlgView_2.findViewById(R.id.edtPhone)).getText().toString();
                        String email = ((EditText)dlgView_2.findViewById(R.id.edtemail)).getText().toString();

                        new NetworkInsert().execute(id,name,password,phone,email);
                    }
                });
                dg_2.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                dg_2.show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("CGV");

//        if(tvid.getText().toString().equals("null")){
//            setTitle("CGV");
//        }else {
//            setTitle("CGV ("+tvid+"님 환영합니다)");
//        }


        //이미지뷰 위젯 저장할 배열
        ImageView image[] = new ImageView[4];
        //이미지뷰 위젯 id 저장할 배열
        final Integer imageId[] = {R.id.ivTenet,R.id.ivMul,R.id.ivSo,R.id.ivBts};
        //이미지뷰 drawable 저장할 배열 설정(이미지 자체를 넘겨주기 위해)
        final Integer imagedr[]={R.drawable.tenet,R.drawable.mul,R.drawable.sode,R.drawable.bts};
        //이미지뷰 제목 저장할 배열
        final String imgName[] = {"테넷","뮬란","검객","BTS"};

        //이미지 위젯 설정과 클릭이벤트 사용을위해 for문 생성
        for(int i=0; i<imageId.length; i++){
            final int index;
            index = i;
            image[index] = (ImageView)findViewById(imageId[index]);
            image[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //이미지 클릭시 타임.xml을 inflate한 다이얼로그 뷰! 생성
                    final View dlgView = (View) View.inflate(MainActivity.this,R.layout.time,null);
                    //다이얼로그 생성
                    AlertDialog.Builder dg = new AlertDialog.Builder(MainActivity.this);
                    dg.setTitle("영화 시간");
                    //다이얼로그에 뷰 지정
                    dg.setView(dlgView);
                    //버튼 이벤트
                    dg.setPositiveButton("시간선택완료", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //라디오그룹 위젯 연결
                            RadioGroup rg = (RadioGroup)dlgView.findViewById(R.id.rg);
                            //라디오 그룹에 체크되어있는 id만 라디오 버튼위젯 연결
                            RadioButton rd = (RadioButton)dlgView.findViewById(rg.getCheckedRadioButtonId());
                            //체크되어있던 라디오버튼의 text를 time변수에 지정
                            String time = rd.getText().toString();
                            String tid = tvid.getText().toString();

                            //인텐트 설정 (현위치,보낼위치)
                            Intent intent = new Intent(getApplicationContext(),MovieActivity.class);
                            //인텐트로 보낼 값 설정 (클릭한 image의 이름배열과 이미지주소배열 그리고 라디오텍스트)
                            //("보낼값의 이름",값)
                            intent.putExtra("ImageDR",imagedr[index]);
                            intent.putExtra("ImageName",imgName[index]);
                            intent.putExtra("Time",time);
                            intent.putExtra("id",tid);
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

