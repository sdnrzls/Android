package com.example.portfolio_2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.portfolio_2.NetWork.NetworkGet;
import com.example.portfolio_2.NetWork.NetworkInsert;

public class MainActivity extends AppCompatActivity {
    Button loginbtn,canclebtn,joinbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("CGV");
        loginbtn = (Button)findViewById(R.id.loginBtn);
        canclebtn = (Button)findViewById(R.id.cancleBtn);
        joinbtn = (Button)findViewById(R.id.joinBtn);

        joinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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

                        new NetworkInsert(MainActivity.this).execute(id,name,password,phone,email);
                    }
                });
                dg_2.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                dg_2.show();


            }
        });

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,MovieActivity.class);
                String id = ((EditText)findViewById(R.id.edtLoginID)).getText().toString();
                String password = ((EditText)findViewById(R.id.edtLoginpassword)).getText().toString();

//                intent.putExtra("userid",id);

                if(id.length() == 0 || password.length() == 0){
                    Toast toast = Toast.makeText(MainActivity.this,"아이디와 비밀번호를 입력해주세요",Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }

                new NetworkGet(MainActivity.this).execute(id,password);

//                startActivity(intent);
            }

        });
    }
}