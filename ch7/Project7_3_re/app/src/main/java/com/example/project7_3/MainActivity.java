package com.example.project7_3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edName, edEmail;
    Button button1;
    EditText dlgEdtName, dlgEdtEmail;
    TextView toastText;
    View dialogView, toastView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("사용자 정보 입력");

        edName = (EditText) findViewById(R.id.edName);
        edEmail = (EditText) findViewById(R.id.edEmail);
        button1 = (Button)findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialogView = (View) View.inflate
                        (MainActivity.this, R.layout.dilog1,null);
                EditText a = dialogView.findViewById(R.id.dlgEdt1);
                EditText b = dialogView.findViewById(R.id.dlgEdt2);

                a.setText(edName.getText().toString());
                b.setText(edEmail.getText().toString());

                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("사용자 정보 입력");
                dlg.setIcon(R.drawable.ic_launcher_background);
                // 확장한(inflate) 뷰를 꽂는다.
                dlg.setView(dialogView);

                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dlgEdtName = (EditText) dialogView.findViewById(R.id.dlgEdt1);
                        dlgEdtEmail = (EditText) dialogView.findViewById(R.id.dlgEdt2);

                        edName.setText(dlgEdtName.getText().toString());
                        edEmail.setText(dlgEdtEmail.getText().toString());
                    }
                });
                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast toast = new Toast(MainActivity.this);

                        //뷰만들기
                        toastView = (View) View.inflate
                                (MainActivity.this,R.layout.toast1,null);
                        toastText = (TextView) toastView.findViewById(R.id.toastText1);
                        toastText.setText("취소했습니다");

                        Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
                        int xOffset =(int)(Math.random()*display.getWidth());
                        int yOffset =(int)(Math.random()*display.getHeight());

                        toast.setGravity(Gravity.TOP|Gravity.LEFT,xOffset,yOffset);

                        toast.setView(toastView);
                        toast.show();
                    }
                });
                dlg.show();
            }
        });
    }
}