package com.example.project9_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.EmbossMaskFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    ImageButton ibZoomin, ibZoomout, ibRotate, ibBright, ibDark, idBlur, idEmboss;
    MyGraphicView graphicView;
    static float scaleX = 1, scaleY = 1;
    static float angle = 0;
   // static float color = 1;
    static float satur = 1;
    static boolean bBlur = false;
    static boolean bEmboss = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("미니 포토샵");

        //리니어 레이아웃에 그래픽뷰 를 연결
        LinearLayout pictureLayout = (LinearLayout) findViewById(R.id.pictureLayout);
        graphicView = (MyGraphicView) new MyGraphicView(this);
        pictureLayout.addView(graphicView);

        clickIcons();

    }

    private void clickIcons() {
        ibZoomin = (ImageButton) findViewById(R.id.ibZoomin);
        ibZoomin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scaleX = scaleX + 0.2f;
                scaleY = scaleY + 0.2f;
                graphicView.invalidate();
            }
        });

        ibZoomout = (ImageButton) findViewById(R.id.ibZoomout);
        ibZoomout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scaleX = scaleX - 0.2f;
                scaleY = scaleY - 0.2f;
                graphicView.invalidate();
            }
        });

        ibRotate = (ImageButton) findViewById(R.id.ibRotate);
        ibRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                angle = angle + 20;
                graphicView.invalidate();
            }
        });

        ibBright = (ImageButton) findViewById(R.id.ibBright);
        ibBright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //color = color + 0.2f;
                satur = satur + 20.0f;
                graphicView.invalidate();
            }
        });

        ibDark = (ImageButton) findViewById(R.id.ibDark);
        ibDark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //color = color - 0.2f;
                satur = satur - 20.0f;
                graphicView.invalidate();
            }
        });

        idBlur = (ImageButton)findViewById(R.id.ibBlur);
        idBlur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bBlur==true){
                    bBlur = false;
                }else if(bBlur==false){
                    bBlur =true;
                }
                graphicView.invalidate();
            }
        });

        idEmboss = (ImageButton)findViewById(R.id.ibEmboss);
        idEmboss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bEmboss==true){
                    bEmboss = false;
                }else if(bEmboss==false){
                    bEmboss =true;
                }
                graphicView.invalidate();
            }
        });


    }

    private static class MyGraphicView extends View {

        public MyGraphicView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            int cenX = this.getWidth() / 2;
            int cenY = this.getHeight() / 2;
            canvas.scale(scaleX, scaleY, cenX, cenY);
            canvas.rotate(angle, cenX, cenY);

            Paint paint = new Paint();

           /* float[] array = {color, 0, 0, 0, 0,
                    0, color, 0, 0, 0,
                    0, 0, color, 0, 0,
                    0, 0, 0, 1, 0};*/
           /* ColorMatrix cm = new ColorMatrix(array);*/
            ColorMatrix cm = new ColorMatrix();
            cm.setSaturation(satur);
            paint.setColorFilter(new ColorMatrixColorFilter(cm));


            //1.Blur 필터
            if(bBlur){
                BlurMaskFilter blurMask;
                blurMask = new BlurMaskFilter(30, BlurMaskFilter.Blur.NORMAL);
                paint.setMaskFilter(blurMask);
            }
            //2.Embossing 필터
            if(bEmboss){
                EmbossMaskFilter embossMask;
                float direction[] = new float[]{3.0f,3.0f,3.0f};
                embossMask = new EmbossMaskFilter(direction,0.5f,5,10);
                paint.setMaskFilter(embossMask);
            }



            Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.pici_icon);
            int picX = (this.getWidth() - picture.getWidth()) / 2;
            int picY = (this.getHeight() - picture.getHeight()) / 2;


            canvas.drawBitmap(picture, picX, picY, null);
            canvas.drawBitmap(picture, picX, picY, paint);
            picture.recycle();
        }
    }
}