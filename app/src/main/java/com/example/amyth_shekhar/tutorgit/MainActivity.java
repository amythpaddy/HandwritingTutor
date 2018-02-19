package com.example.amyth_shekhar.tutorgit;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import com.devs.vectorchildfinder.VectorChildFinder;
import com.sdsmdg.harjot.vectormaster.VectorMasterView;
import com.sdsmdg.harjot.vectormaster.models.PathModel;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    float xi, yi;
    Path drawPath;
    Paint paint;
    Canvas canvas;
    A_View a;
    float viewLeft, viewTop;
    DisplayMetrics disp;
    Region r;
    int addtop;
    int addleft;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        a = new A_View(this);
//        a.setBackgroundColor(Color.WHITE);
        setContentView(R.layout.activity_main);

        a = findViewById(R.id.path_display);

        drawPath = new Path();
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);
        Bitmap b = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(b);
        disp = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(disp);
        testFunction();

//a.getViewTreeObserver().addOnDrawListener(new ViewTreeObserver.OnDrawListener() {
//    @Override
//    public void onDraw() {
//        a.getViewTreeObserver().removeOnDrawListener(this);
//        viewLeft = a.getLeft();
//        viewTop = a.getTop();
//        Log.d("Left: "+viewLeft,"Right: "+viewTop);
//    }
//});


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
//            drawPath.lineTo(event.getX(),event.getY());
            if (r.contains((int) event.getX()
                    -addleft, (int) event.getY()-addtop )){
            a.drawThePoint(event.getX()-(disp.widthPixels - a.getWidth()) , event.getY()-(disp.heightPixels-a.getHeight()));
//            Log.d("move","true");

            Log.d("Region ", "contains");}
        else{
            Log.d("Region ", "does not contain");
            a.resetDraw();
            }
        }
        return true;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return true;
    }
VectorMasterView vmv;
    RectF rect = new RectF();
    A_View a_view;
    Path tempPath;
    private void testFunction() {
//        VectorDrawable vd = new VectorDrawable();
//        vd.createFromPath(getString(R.string.a_path));
//        ((ImageView)findViewById(R.id.char_display)).setImageDrawable(vd);
//        r.setPath(new Path().)
r = new Region();
         vmv = findViewById(R.id.char_display);
        PathModel path = vmv.getPathModelByName("text");



float density=getResources().getDisplayMetrics().density;
         a_view = findViewById(R.id.path_display);
        Matrix scale = new Matrix();
        scale.setScale((1.22f*density),(1.22f*density),(a_view.getRight()+a_view.getLeft())/2 , (a_view.getBottom()+a_view.getTop()-300)/2);
//        scale.setScale((0.675f*density),(0.7f*density),(a_view.getRight()+a_view.getLeft())/2 , (a_view.getBottom()+a_view.getTop())/2);
         tempPath = path.getPath();
        tempPath.transform(scale);
        path.getPath().computeBounds(rect,true);
        Log.d("left",""+rect.left);
        Log.d("bottom",""+rect.bottom);
        Log.d("top",""+rect.top);
        Log.d("right",""+rect.right);
//        r.set( new Region((int)rect.left,(int)rect.top,(int)rect.right,(int)rect.bottom));
        a_view.setDrawPath(path.getPath());
        a_view.drawRect(rect);
        VectorChildFinder vcf = new VectorChildFinder(this , R.drawable.a , (ImageView)findViewById(R.id.image_view));
        vcf.findPathByName("text").getStrokeAlpha();
//        r = new Region(0, 0, vmv.getRight(), vmv.getBottom());
//        r.set(0, 0, vmv.getRight(), vmv.getBottom());
        boolean set = r.setPath(tempPath, new Region((int)rect.left+a_view.getLeft(),(int)rect.top+a_view.getTop(),(int)rect.right+a_view.getLeft(),(int)rect.bottom+a_view.getTop()));
//        Log.d("set", " " + set);
        vmv.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                vmv.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                int[] a=new int[2];
                vmv.getLocationInWindow(a);
                addtop = a[1];
                addleft = a[0];
                r.setPath(tempPath, new Region((int)rect.left,(int)rect.top,(int)rect.right,(int)rect.bottom));
//                r.setPath(tempPath, new Region((int)rect.left+a_view.getLeft(),(int)rect.top+a_view.getTop(),(int)rect.right+a_view.getLeft(),(int)rect.bottom+a_view.getTop()));
//                addtop = 0;
//                addleft = 0;
            }
        });
    }
}
