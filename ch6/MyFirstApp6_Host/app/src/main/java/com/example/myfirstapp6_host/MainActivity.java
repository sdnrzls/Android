package com.example.myfirstapp6_host;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.os.Bundle;
import android.text.style.TabStopSpan;
import android.widget.TabHost;

public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost = getTabHost();

        TabHost.TabSpec tabspecSong = tabHost.newTabSpec("SONG").setIndicator("음악별");
        tabspecSong.setContent(R.id.tabSong);
        tabHost.addTab(tabspecSong);

        TabHost.TabSpec tabspecArtist = tabHost.newTabSpec("ARTIST").setIndicator("가수별");
        tabspecArtist.setContent(R.id.tabArtist);
        tabHost.addTab(tabspecArtist);

        TabHost.TabSpec tabspecAlbum = tabHost.newTabSpec("ALBUM").setIndicator("앨범별");
        tabspecAlbum.setContent(R.id.tabAlbum);
        tabHost.addTab(tabspecAlbum);

        tabHost.setCurrentTab(0);

    }
}