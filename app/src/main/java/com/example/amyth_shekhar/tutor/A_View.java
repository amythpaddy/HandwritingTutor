package com.example.amyth_shekhar.tutor;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Toast;


/**
 * Created by mac on 05/01/18.
 */

public class A_View extends View {
    private Canvas canvas;
    private Path path;
    private Paint paint;
    private int[][] a = GlobalPathPoints.a_path;
    private float xi, xf, yi, yf;
    private Path drawPath;
    private Paint drawPaint;
    int i = 0;

    public A_View(Context context) {
        super(context);
        initView(context);
    }

    public A_View(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public A_View(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        path = new Path();
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(3f);
        paint.setStyle(Paint.Style.STROKE);

        drawPath = new Path();
        drawPaint = new Paint();
        drawPaint.setColor(Color.RED);
        drawPaint.setStrokeWidth(100);
        drawPaint.setStyle(Paint.Style.STROKE);

        path.moveTo(a[0][0], a[0][1]);
        path.lineTo(a[1][0], a[1][1]);
        path.lineTo(a[2][0], a[2][1]);
        path.lineTo(a[3][0], a[3][1]);
        path.lineTo(a[4][0], a[4][1]);
        path.lineTo(a[5][0], a[5][1]);
        path.lineTo(a[6][0], a[6][1]);
        path.lineTo(a[7][0], a[7][1]);
        path.lineTo(a[8][0], a[8][1]);
        path.moveTo(a[9][0], a[9][1]);
        path.lineTo(a[10][0], a[10][1]);
        path.lineTo(a[11][0], a[11][1]);
        path.lineTo(a[12][0], a[12][1]);
        path.lineTo(a[13][0], a[13][1]);

    }

    public void moveToPoint(float x, float y) {
        drawPath.moveTo(x, y);
    }

    public void drawThePoint(float x, float y) {
        boolean flag = false;
        for(int[] point : GlobalPathPoints.points){
            if (y > point[1] - 100 && point[1] + 100 > y) {
                if(x > point[0] - 100 && point[0] + 100 > x) {
                    drawPath.lineTo(x, y);
                    i++;


                    Log.d("Point to reach", GlobalPathPoints.points[i][0] + "---" + GlobalPathPoints.points[i][1]);
                    Log.d("Current Point", x + "---" + y);
                    flag = true;
                    break;
                }
            }
        }
        /*if (y > GlobalPathPoints.points[i][1] - 100 && GlobalPathPoints.points[i][1] + 100 > y) {
            drawPath.lineTo(x, y);
            i++;


            Log.d("Point to reach",GlobalPathPoints.points[i][0]+"---"+GlobalPathPoints.points[i][1]);
            Log.d("Current Point",x+"---"+y);

        }*/ if(!flag) {


            Log.d("wrong Point to reach",GlobalPathPoints.points[i][0]+"---"+GlobalPathPoints.points[i][1]);
            Log.d("wrong Current Point",x+"---"+y);

            drawPath = new Path();
            i = 0;
        }

        invalidate();
        if(i == 8) {
            Toast.makeText(getContext(), "Yaay!!!", Toast.LENGTH_SHORT).show();
            i=0;
            drawPath = new Path();
        }

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.canvas = canvas;

        canvas.drawPath(path, paint);
        canvas.drawPath(drawPath, drawPaint);

    }

   /* @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("Action",event.getAction()+"");
        if(event.getAction() == MotionEvent.ACTION_DOWN)
        {
            xi = event.getX();
            yi = event.getY();
            drawPath.moveTo(xi,yi);
            Log.d("Down","true");
        }else if(event.getAction() == MotionEvent.ACTION_MOVE){
            Log.d(""+event.getX(),""+event.getY());
            drawPath.lineTo(event.getX(),event.getY());
            canvas.drawPath(drawPath , paint);
            invalidate();
            Log.d("move","true");
        }
        return false;
    }*/
}
