package com.example.amyth_shekhar.tutorgit;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;


/**
 * Created by mac on 05/01/18.
 */

public class A_View extends View {
    private Canvas canvas;
    private Path path;
    private Paint paint;
    private Paint drawPaint;
    private int[][] a1 = GlobalPathPoints.a_path;
    private int[][] a2 = GlobalPathPoints.a_part2;
    private float xi, xf, yi, yf;
    private Path drawPath;
    private Paint alpha_paint;
    private Path charPath;
    int i = 0;
    private Paint redPaint;
    private Paint blackPaint;
    private Path blackPoint;
    private Path redPoint;
    private Path tempPath;
    int chkPoint =0;

    int[][] point = {{200,800},{365,325},{530,800},{280,555},{360,555},{440,555}};

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
        tempPath = new Path();
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(3f);
        paint.setStyle(Paint.Style.STROKE);

        drawPath = new Path();
        alpha_paint = new Paint();
        alpha_paint.setColor(Color.RED);
        alpha_paint.setStrokeWidth(5);
        alpha_paint.setStyle(Paint.Style.STROKE);

        drawPaint = new Paint();
        drawPaint.setColor(Color.RED);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);
        drawPaint.setAntiAlias(true);
        drawPaint.setStrokeWidth(55);
        drawPaint.setStyle(Paint.Style.STROKE);

        redPaint = new Paint();
        redPaint.setColor(Color.RED);
        redPaint.setStrokeWidth(50);
        redPaint.setStrokeCap(Paint.Cap.ROUND);
        redPaint.setStyle(Paint.Style.FILL_AND_STROKE);

        blackPaint = new Paint();
        blackPaint.setColor(Color.BLACK);
        blackPaint.setStrokeWidth(40);
        blackPaint.setStrokeCap(Paint.Cap.ROUND);
        blackPaint.setStyle(Paint.Style.FILL_AND_STROKE);

        blackPoint = new Path();
        blackPoint.moveTo(point[0][0],point[0][1]);

    }

    public void setDrawPath(Path path){
        charPath = path;
        invalidate();
    }

    public void moveToPoint(float x, float y) {
        if(tempPath == null)
            tempPath = new Path();
        tempPath.moveTo(x, y);
    }

    public void drawThePoint(float x, float y) {

if(tempPath !=null) {
    tempPath.lineTo(x, y);
    try {
        if ((x - 20 < point[chkPoint][0] && x + 20 > point[chkPoint][0]) && (y - 20 < point[chkPoint][1] && y + 20 > point[chkPoint][1])) {
            chkPoint++;
            drawPath.addPath(tempPath);
            tempPath = new Path();
            tempPath.moveTo(x, y);
//        if(chkPoint == 5)
//            Toast.makeText(getContext(), "Yaay!!!!", Toast.LENGTH_SHORT).show();
        }
    }catch(Exception e){}
    invalidate();
}


    }

    RectF rect=null;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.canvas = canvas;
        try {
            canvas.drawPoint(point[chkPoint][0], point[chkPoint][1], redPaint);
            if (chkPoint != 0)
                canvas.drawPoint(point[chkPoint - 1][0], point[chkPoint - 1][1], blackPaint);
            canvas.drawPath(drawPath, drawPaint);
            if (tempPath != null)
                canvas.drawPath(tempPath, drawPaint);
            if (rect != null)
                canvas.drawRect(rect, alpha_paint);

            if (charPath != null)
                canvas.drawPath(charPath, alpha_paint);
        }catch(Exception ew){}

    }

    public void drawRect(RectF rect) {
        this.rect = rect;
    }

    public void resetDraw() {
        tempPath = null;
        if(chkPoint!=0 && tempPath !=null)
        chkPoint--;
        invalidate();
    }


}
