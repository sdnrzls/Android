package com.example.project6_3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;
@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost = getTabHost();

        TabHost.TabSpec tabspec1 = tabHost.newTabSpec("ID1").setIndicator("고양이");
        tabspec1.setContent(R.id.tabcat);
        tabHost.addTab(tabspec1);

        TabHost.TabSpec tabspec2 = tabHost.newTabSpec("ID2").setIndicator("강아지");
        tabspec2.setContent(R.id.tabdog);
        tabHost.addTab(tabspec2);

        TabHost.TabSpec tabspec3 = tabHost.newTabSpec("ID3").setIndicator("말");
        tabspec3.setContent(R.id.tabhorse);
        tabHost.addTab(tabspec3);

        TabHost.TabSpec tabspec4 = tabHost.newTabSpec("ID4").setIndicator("토끼");
        tabspec4.setContent(R.id.tabrabbit);
        tabHost.addTab(tabspec4);

        tabHost.setCurrentTab(0);

    }
}