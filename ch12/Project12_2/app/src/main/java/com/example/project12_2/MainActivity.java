package com.example.project12_2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    myDBHelper myHelper;
    EditText edtName, edtNum, edtNameResult, edtNumResult;
    Button btn1,btn2,btn3,btn4,btn5;
    SQLiteDatabase sqlDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("가수 그룹 관리 DB");

        edtName = (EditText)findViewById(R.id.edtName);
        edtNum = (EditText)findViewById(R.id.edtNum);
        edtNameResult = (EditText)findViewById(R.id.edtNameResult);
        edtNumResult = (EditText)findViewById(R.id.edtNumResult);
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);
        btn5 = (Button)findViewById(R.id.btn5);

        myHelper = new myDBHelper(this);

        //초기화
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myHelper.getWritableDatabase();
                myHelper.onUpgrade(sqlDB,1,2);
                sqlDB.close();
            }
        });

        //입력
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myHelper.getWritableDatabase();
                sqlDB.execSQL("INSERT INTO groupTBL VALUES ('"
                        +edtName.getText().toString() + "', "
                        +edtNum.getText().toString()+");");
                sqlDB.close();
                Toast.makeText(getApplicationContext(),"입력됨",Toast.LENGTH_SHORT).show();
            }
        });

        //조회
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB =myHelper.getReadableDatabase();
                Cursor cursor;
                cursor = sqlDB.rawQuery("SELECT * FROM groupTBL;",null);

                String strNames = "그룹 이름" + "\r\n" + "_____"  + "\r\n";
                String strNumbers = "인원" + "\r\n" + "_____"  + "\r\n";

                while (cursor.moveToNext()){
                    strNames += cursor.getString(0) + "\r\n";
                    strNumbers += cursor.getString(1) + "\r\n";
                }
                edtNameResult.setText(strNames);
                edtNumResult.setText(strNumbers);

                cursor.close();
                sqlDB.close();
            }
        });

        //수정
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myHelper.getWritableDatabase();

                String query="";

                sqlDB.execSQL(" UPDATE groupTBL SET gNumber= "+edtNum.getText().toString()
                            + " WHERE gName= '"+edtName.getText().toString()+"';");

                sqlDB.close();
                Toast.makeText(getApplicationContext(),"수정됨",Toast.LENGTH_SHORT).show();
            }
        });


        //삭제
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myHelper.getWritableDatabase();
                sqlDB.execSQL("DELETE FROM groupTBL where gName ='"+edtName.getText().toString()+"';");
                sqlDB.close();
                Toast.makeText(getApplicationContext(),"삭제됨",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public class myDBHelper extends SQLiteOpenHelper{

        //1.생성자 -> 액티비티(context) 받아서, <DB이름> 설정
        public myDBHelper(Context context) {
            super(context, "groupDB1", null, 1);
        }

        //2.테이블 만들기 (DB이름 아님)
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE groupTBL(gName CHAR(20) PRIMARY KEY, gNumber INTEGER);");
        }

        //3.테이블 재생성
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS groupTBL");
            onCreate(db);
        }
    }
}