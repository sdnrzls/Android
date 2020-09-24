package com.example.project11_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gallery gallery = (Gallery)findViewById(R.id.gallery1);

        MyGallertAdapter galAdapter = new MyGallertAdapter(this);
        gallery.setAdapter(galAdapter);
    }
    public class MyGallertAdapter extends BaseAdapter{
        Context context;
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

        public  MyGallertAdapter(Context c){
            context = c;
        }

        @Override
        public int getCount() {
            return posterID.length;
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
        public View getView(int position, View convertView, ViewGroup parent) {
            final ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new Gallery.LayoutParams(100,150));

            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(5,5,5,5);

            imageView.setImageResource(posterID[position]);

            final int pos = position;
            imageView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    ImageView ivPoster = (ImageView) findViewById(R.id.ivPoster);
                    ivPoster.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    ivPoster.setImageResource(posterID[pos]);

                    Toast toast = new Toast(getApplicationContext());
                    View toastView = View.inflate(getApplicationContext(),R.layout.toast1,null);

                    TextView tvToast = (TextView)toastView.findViewById(R.id.tvToast);
                    tvToast.setText(posterName[pos]);
                    toast.setView(toastView);

                    toast.show();


                    return false;
                }
            });
            return imageView;
        }
    }
}