package com.example.portfolio;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MovieActivity extends AppCompatActivity {
    TextView tv1,time1;
    ImageView iv1;
    Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie);
        setTitle("좌석 정하기");

        tv1 = (TextView)findViewById(R.id.tv1);
        time1 = (TextView)findViewById(R.id.time1);
        iv1 =(ImageView)findViewById(R.id.iv1);

        intent = getIntent();
        tv1.setText(intent.getStringExtra("ImageName"));
        iv1.setImageResource(intent.getIntExtra("ImageDR",0));
        time1.setText(intent.getStringExtra("Time"));

        GridView gv = (GridView)findViewById(R.id.gridView1);
        MyGridAdapter gAdapter = new MyGridAdapter(this);
        gv.setAdapter(gAdapter);

    }

    public class MyGridAdapter extends BaseAdapter{
        Context context;
        //이미지파일
        Integer[] Seat ={   R.drawable.seat1,R.drawable.seat2,R.drawable.seat3,R.drawable.seat4,
                            R.drawable.seat5,R.drawable.seat6,R.drawable.seat7,R.drawable.seat8,
                            R.drawable.seat1,R.drawable.seat2,R.drawable.seat3,R.drawable.seat4,
                            R.drawable.seat5,R.drawable.seat6,R.drawable.seat7,R.drawable.seat8,
                            R.drawable.seat1,R.drawable.seat2,R.drawable.seat3,R.drawable.seat4,
                            R.drawable.seat5,R.drawable.seat6,R.drawable.seat7,R.drawable.seat8};
        //좌석이름
        String[] SeatNum = {"A1","A2","A3","A4","A5","A6","A7","A8",
                            "B1","B2","B3","B4","B5","B6","B7","B8",
                            "C1","C2","C3","C4","C5","C6","C7","C8"};


        public MyGridAdapter(Context c){
            context = c;
        }

        @Override
        public int getCount() {
            return SeatNum.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(60,100));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(5,5,5,5);
            imageView.setImageResource(Seat[position]);


            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    View dialogView = (View) View.inflate(MovieActivity.this,R.layout.dialog,null);

                    AlertDialog.Builder dlg = new AlertDialog.Builder(MovieActivity.this);
                    dlg.setTitle(SeatNum[position]+"열 예매 하시겠습니까?");
                    dlg.setView(dialogView);
                    dlg.setPositiveButton("예매", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            View dView = (View) View.inflate(MovieActivity.this,R.layout.check,null);
                            AlertDialog.Builder dlg2 = new AlertDialog.Builder(MovieActivity.this);

                            TextView tvlast1 = (TextView)dView.findViewById(R.id.tvlast1);
                            TextView tvlast2 = (TextView)dView.findViewById(R.id.tvlast2);

                            tvlast1.setText(intent.getStringExtra("Time"));
                            tvlast2.setText(SeatNum[position]+"열 좌석 예약 완료 되었습니다");

                            ImageView ivlast = (ImageView)dView.findViewById(R.id.ivlast);
                            ivlast.setImageResource(intent.getIntExtra("ImageDR",0));

                            dlg2.setTitle("예매 완료");
                            dlg2.setView(dView);
                            dlg2.setNegativeButton("닫기",null);
                            dlg2.show();
                        }
                    });
                    dlg.setNegativeButton("닫기",null);
                    dlg.show();

                }
            });

            return imageView;
        }
    }
}
