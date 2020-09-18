package com.example.myfirstapp7_dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    final  boolean[] checkArray = new boolean[]{true, false, false}; //체크박스 목록 대화상자
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button btn1 = (Button)findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String[] versionArray = new String[]{"롤리팝","마시멜로","누가"};

                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("좋아하는 버전은?");
                dlg.setIcon(R.mipmap.ic_launcher);

                //체크박스 목록 대화상자
                dlg.setMultiChoiceItems(versionArray, checkArray, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        //btn1.setText(versionArray[which]);
                        if(isChecked){
                            checkArray[which] = true;
                        }else {
                            checkArray[which] = false;
                        }
                        String str1 = "";
                        int cnt = 0;
                        for(int i=0; i<checkArray.length; ++i){
                            if(checkArray[i]){
                                cnt++;
                                if(cnt !=1){
                                    str1 = str1+",";
                                }
                                str1 = str1+versionArray[i];
                            }
                            btn1.setText(str1);
                        }
                    }
                });
                dlg.setPositiveButton("닫기",null);
                dlg.show();
            }

//                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
//                dlg.setTitle("제목입니다");
//                dlg.setMessage("이곳이 내용입니다");
//                dlg.setIcon(R.mipmap.ic_launcher);
//                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(MainActivity.this, "확인을 눌렀네요", Toast.LENGTH_SHORT).show();
//                    }
//                });

                //목록대화상자
//                dlg.setItems(versionArray, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        btn1.setText(versionArray[which]);
//                    }
//                });
//                    dlg.setPositiveButton("닫기",null);
//                    dlg.show();

                //라디오버튼 목록 대화상자
//                dlg.setSingleChoiceItems(versionArray, 0, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        btn1.setText(versionArray[which]);
//                    }
//                });
//                    dlg.setPositiveButton("닫기",null);
//                    dlg.show();

        });
    }
}