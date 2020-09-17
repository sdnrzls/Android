package com.example.myappfirst6_actionbar;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

    public class MyTabFragment extends Fragment {

    String tabName;

    //1) 프래그먼트 생성 메소드
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //안드로이드 운영체제(OS)와 통신하기 위해 연결
        Bundle bundle = getArguments();
        tabName = bundle.getString("tabName");
    }

    //2)프래그먼트 안에 들어가는 뷰 생성 메소드
    //뷰를 디자인을 만든다 activity_main.xml과 같은 역할
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //레이아웃과 위젯으로 구성
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        LinearLayout baseLayout = new LinearLayout(super.getActivity()); //생성자 매개변수 ->(위치->액티비티)
        baseLayout.setOrientation(LinearLayout.VERTICAL);
        baseLayout.setLayoutParams(params);

        if (tabName == "음악별") baseLayout.setBackgroundColor(Color.RED);
        if (tabName == "가수별") baseLayout.setBackgroundColor(Color.GRAY);
        if (tabName == "앨범별") baseLayout.setBackgroundColor(Color.BLUE);
        if (tabName == "순위별") baseLayout.setBackgroundColor(Color.YELLOW);

        return baseLayout;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }
}

