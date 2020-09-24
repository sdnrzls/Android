package com.example.project11_1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("그리드뷰 영화 포스터");

        final GridView gv = (GridView)findViewById(R.id.gridView1);

        //30행에서 정의한 MyGridAdapter 변수를 생성한 후 main.xml의 그리드뷰에 적용
        MyGridAdapter gAdapter = new MyGridAdapter(this);
        gv.setAdapter(gAdapter);

    }
    //BaseAdapter의 상속을 받는  MyGridAdapter 정의
    public class MyGridAdapter extends BaseAdapter{
        // Context 변수 선언
        Context context;

        public MyGridAdapter(Context c){
            context = c;
        }

        //1.멤버변수(필드)
        // 이미지파일의 아이디를 배열로 지정
        Integer[] posterID = {R.drawable.mov01,R.drawable.mov02,R.drawable.mov03,R.drawable.mov04,
                              R.drawable.mov05,R.drawable.mov06,R.drawable.mov07,R.drawable.mov08,
                              R.drawable.mov09,R.drawable.mov10, R.drawable.mov11,R.drawable.mov12,
                              R.drawable.mov13,R.drawable.mov14,R.drawable.mov15,R.drawable.mov16,
                              R.drawable.mov17,R.drawable.mov18,R.drawable.mov19,R.drawable.mov20,
                              R.drawable.mov21,R.drawable.mov22,R.drawable.mov23,R.drawable.mov24,
                              R.drawable.mov25,R.drawable.mov26,R.drawable.mov27,R.drawable.mov28,
                              R.drawable.mov29,R.drawable.mov30, R.drawable.mov31,R.drawable.mov32,
                              R.drawable.mov33,R.drawable.mov34,R.drawable.mov35,R.drawable.mov36,
                              R.drawable.mov37,R.drawable.mov38,R.drawable.mov39,R.drawable.mov40};
        //영화 제목을 배열로 지정
        String [] posterName = {"써니","완득이","괴물","라디오스타","비열한거리","왕의남자","아일랜드",
                                "웰컴투 동막골","헬보이","백 투더 퓨처","여인희 향기","쥬라기공원",
                                "포레스트 검프"," ","혹성탈출","아름다운 비행","내이름은 칸",
                                "해리포터 죽은자의 성물","마더", "킹콩을 들다","쿵푸팬더2",
                                "짱구는 못말려","아저씨","아바타","대부","국가대표","토이스토리",
                                "마당에 나온 암닭", "죽은시인의 사회","서유쌍기","킹콩","반지의제왕",
                                "클래식","미녀는 괴로워","나홀로집에","파이란", "더록","로마의휴일",
                                "매트릭스","가위손"};

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        public int getCount(){
            //영화 포스터의 갯수를 반환
            return posterID.length;
        }

        public View getView(int position, View convertView, ViewGroup parent){
            ImageView imageview = new ImageView(context);
            imageview.setLayoutParams(new GridView.LayoutParams(100,150));
            imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageview.setPadding(5,5,5,5);

            imageview.setImageResource(posterID[position]);

            final int pos = position;
            imageview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //inflate 로 연결 ( 사용할 context,디자인,null)
                    View dialogView = (View) View.inflate(MainActivity.this,R.layout.dialog,null);

                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    //inflate 로 연결한 dialogView의 이미지 뷰 대입
                    ImageView ivPoster =(ImageView) dialogView.findViewById(R.id.ivPoster);
                    ivPoster.setImageResource(posterID[pos]);

                    dlg.setTitle(posterName[pos]);
                    dlg.setIcon(R.drawable.movie_icon);
                    dlg.setView(dialogView);
                    dlg.setNegativeButton("닫기",null);
                    dlg.show();
                }
            });
            return imageview;
        }

    }


}