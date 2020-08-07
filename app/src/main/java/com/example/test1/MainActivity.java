package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(new MyView(this));

        imageView = findViewById(R.id.imageView);

//        new MyView(this);
    }
    public class MyView extends View {
        private Bitmap image1,image2,image3;

        public MyView(Context context) {
            super(context);
            setBackgroundColor(Color.LTGRAY);

            Resources r = context.getResources();
            image1 = BitmapFactory.decodeResource(r, R.drawable.kakao);
            image2 = BitmapFactory.decodeResource(r, R.drawable.bubble);
            image3 = BitmapFactory.decodeResource(r, R.drawable.bubble);

        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawBitmap(image1, 0, 0, null);

            int w = image2.getWidth();
            int h = image2.getHeight();
            //Rect src = new Rect(0, 0, w, h);
            Rect dst = new Rect(400, 800, 400 + w / 2, 800 + h / 2);
            canvas.drawBitmap(image2, null, dst, null);

            w = image3.getWidth();
            h = image3.getHeight();
            //src = new Rect(0, 0, w, h);
            dst = new Rect(400, 1200, 400 + w / 2, 1200 + h / 2);
            canvas.drawBitmap(image3, null, dst, null);

            super.onDraw(canvas);
        }
    }


}
