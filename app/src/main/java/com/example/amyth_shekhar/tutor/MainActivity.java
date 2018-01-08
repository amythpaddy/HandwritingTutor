package com.example.amyth_shekhar.tutor;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener{

    float xi,yi;
    Path drawPath;
    Paint paint;
    Canvas canvas;
    A_View a;
    float viewLeft , viewTop;
    DisplayMetrics disp;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        a = new A_View(this);
        a.setBackgroundColor(Color.WHITE);
        setContentView(a);

        drawPath = new Path();
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);
        Bitmap b = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(b);
         disp = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(disp);

a.getViewTreeObserver().addOnDrawListener(new ViewTreeObserver.OnDrawListener() {
    @Override
    public void onDraw() {
        a.getViewTreeObserver().removeOnDrawListener(this);
        viewLeft = a.getLeft();
        viewTop = a.getTop();
        Log.d("Left: "+viewLeft,"Right: "+viewTop);
    }
});


//        a.setOnTouchListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if(event.getAction() == MotionEvent.ACTION_DOWN)
        {
            a.moveToPoint(event.getX()-(disp.widthPixels - a.getWidth()) , event.getY()-(disp.heightPixels-a.getHeight()));
            Log.d("Down","true");
        }else if(event.getAction() == MotionEvent.ACTION_MOVE){
            Log.d(""+event.getX(),""+event.getY());
            drawPath.lineTo(event.getX(),event.getY());
            a.drawThePoint(event.getX()-(disp.widthPixels - a.getWidth()) , event.getY()-(disp.heightPixels-a.getHeight()));
            Log.d("move","true");
        }
        return true;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return true;
    }
}
