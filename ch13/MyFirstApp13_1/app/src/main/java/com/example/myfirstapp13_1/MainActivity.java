package com.example.myfirstapp13_1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MediaPlayer mPlayer;
        mPlayer = MediaPlayer.create(this,R.raw.song1);
        final ProgressBar pb1 = (ProgressBar)findViewById(R.id.pb1);
        final Switch switch1 = (Switch)findViewById(R.id.switch1);

        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pb1.setVisibility(View.VISIBLE);
                if(switch1.isChecked()==true){

                    new Thread(){
                        public void run(){
                            for(int i=pb1.getProgress(); i<100; i=i+2){
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        pb1.setProgress(pb1.getProgress()+2);
                                    }
                                });
                                SystemClock.sleep(1000);
                            }
                        }
                    }.start();
                    mPlayer.start();

                }else{
                    mPlayer.stop();
                }
            }
        });
    }
}