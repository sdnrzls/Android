package com.example.portfolio_2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.portfolio_2.NetWork.SeatInsert;


public class MovieActivity_2 extends AppCompatActivity {
    TextView tv1,time1,id;
    ImageView iv1;
    Intent intent;
    Button btnSeat;

    //좌석 배열값을 받을 배열생성
    String[] seatNumArr = new String[24];
    //배열 초기화 구분을위해 전체 값을 "-"로 설정
    public MovieActivity_2(){
        for(int i=0; i<seatNumArr.length; i++){
            seatNumArr[i] = "-";
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_seat);
        setTitle("좌석 정하기");
        //movie.xml의 위젯과 연결
        tv1 = (TextView)findViewById(R.id.tv1);
        time1 = (TextView)findViewById(R.id.time1);
        iv1 =(ImageView)findViewById(R.id.iv1);
        btnSeat = (Button)findViewById(R.id.btnSeat);
        id = (TextView)findViewById(R.id.id);
        //인텐트 받는 함수
        intent = getIntent();
        //변수에 인텐트로 받은 값들 지정
        tv1.setText(intent.getStringExtra("ImageName"));
        iv1.setImageResource(intent.getIntExtra("ImageDR",0));
        time1.setText(intent.getStringExtra("Time"));

        id.setText(intent.getStringExtra("id"));
        final String user = id.getText().toString();
        //그리드뷰 위젯 연결
        GridView gv = (GridView)findViewById(R.id.gridView1);
        //그리드뷰 생성(public class MyGridAdapter extends BaseAdapter)
        MyGridAdapter gAdapter = new MyGridAdapter(this);
        //그리드뷰 연결
        gv.setAdapter(gAdapter);

        //버튼 클릭시
        btnSeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View dialogView = (View) View.inflate(MovieActivity_2.this,R.layout.dialog,null);

                AlertDialog.Builder dlg = new AlertDialog.Builder(MovieActivity_2.this);
                String time = time1.getText().toString();
                String name = tv1.getText().toString();

                //좌석 배열 구분 을 위한 for 문 사용
                //String형의 공백 변수 생성 ("-"아닌 값을 받을)
                String strSeatNumArr = "";
                for(int i=0; i<seatNumArr.length; i++){
                    if(!seatNumArr[i].equals("-")){
                        //배열값이 "-"이 아니면 strSeatNumArr에 배열값 넣음
                        new SeatInsert().execute(name,time,seatNumArr[i]);

                        strSeatNumArr = strSeatNumArr+ " "+ seatNumArr[i];
                    }
                }

                dlg.setTitle(user+"님" +strSeatNumArr+"열 예매 하시겠습니까?");
                dlg.setView(dialogView);

                final String finalStrSeatNumArr = strSeatNumArr;
                dlg.setPositiveButton("예매", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        View dView = (View) View.inflate(MovieActivity_2.this,R.layout.check,null);
                        AlertDialog.Builder dlg2 = new AlertDialog.Builder(MovieActivity_2.this);

                        TextView tvlast1 = (TextView)dView.findViewById(R.id.tvlast1);
                        TextView tvlast2 = (TextView)dView.findViewById(R.id.tvlast2);

                        tvlast1.setText(intent.getStringExtra("Time"));
                        tvlast2.setText(user+"님"+ finalStrSeatNumArr +"열 좌석 예약 완료 되었습니다");

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

    }
    //BaseAdapter를 상속받는 MyGridAdapter class 생성
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

        //
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
            final ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(60,100));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(5,5,5,5);
            imageView.setImageResource(Seat[position]);
            //이미지뷰 클릭 리스너
            imageView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    //이미지 클릭시 색 변경
                    imageView.setColorFilter(Color.parseColor("#ffff0000"), PorterDuff.Mode.SRC_OVER);
                    //클릭한 이미지의 SeatNum배열값을 전역변수 seatNumArr에 대입
                    seatNumArr[position] = SeatNum[position];
                }
            });
            return imageView;
        }
    }
}
