package com.example.amyth_shekhar.tutorgit;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import java.util.Stack;



/**
 * Created by AuthorName on Feb 7, 2018.
 * Copyright © 2018 CompanyName. All rights reserved.
 *
 * This code was generated by Trial version of PaintCode, therefore cannot be used for commercial purposes.
 * http://www.paintcodeapp.com
 *
 * @author AuthorName
 */
public class Pattern {
    
    
    // Resizing Behavior
    public enum ResizingBehavior {
        AspectFit, //!< The content is proportionally resized to fit into the target rectangle.
        AspectFill, //!< The content is proportionally resized to completely fill the target rectangle.
        Stretch, //!< The content is stretched to match the entire target rectangle.
        Center, //!< The content is centered in the target rectangle, but it is NOT resized.
    }
    
    // In Trial version of PaintCode, the code generation is limited to 3 canvases.
    
    // Canvas Drawings
    // Tab
    
    private static class CacheForCanvas1 {
        private static RectF originalFrame = new RectF(0f, 0f, 251f, 348f);
        private static RectF resizedFrame = new RectF();
        private static RectF textRect = new RectF();
        private static TextPaint textTextPaint = new TextPaint();
        private static PaintCodeStaticLayout textStaticLayout = new PaintCodeStaticLayout();
    }
    
    public static void drawCanvas1(Canvas canvas, Context context) {
        Pattern.drawCanvas1(canvas, context, new RectF(0f, 0f, 251f, 348f), ResizingBehavior.AspectFit);
    }
    
    public static void drawCanvas1(Canvas canvas, Context context, RectF targetFrame, ResizingBehavior resizing) {
        // Resize to Target Frame
        canvas.save();
        RectF resizedFrame = CacheForCanvas1.resizedFrame;
        Pattern.resizingBehaviorApply(resizing, CacheForCanvas1.originalFrame, targetFrame, resizedFrame);
        canvas.translate(resizedFrame.left, resizedFrame.top);
        canvas.scale(resizedFrame.width() / 251f, resizedFrame.height() / 348f);
        
        // Text
        RectF textRect = CacheForCanvas1.textRect;
        textRect.set(0f, 0f, 251f, 348f);
        TextPaint textTextPaint = CacheForCanvas1.textTextPaint;
        textTextPaint.reset();
        textTextPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        textTextPaint.setColor(Color.BLACK);
        textTextPaint.setTypeface(Typeface.create((String) null, Typeface.NORMAL));
        textTextPaint.setTextSize(400f);
        StaticLayout textStaticLayout = CacheForCanvas1.textStaticLayout.get((int) textRect.width(), Layout.Alignment.ALIGN_CENTER, "A", textTextPaint);
        canvas.save();
        canvas.clipRect(textRect);
        canvas.translate(textRect.left, textRect.top + (textRect.height() - textStaticLayout.getHeight()) / 2f);
        textStaticLayout.draw(canvas);
        canvas.restore();
        
        canvas.restore();
    }
    
    private static class CacheForCanvas2 {
        private static Paint paint = new Paint();
        private static RectF originalFrame = new RectF(0f, 0f, 291f, 353f);
        private static RectF resizedFrame = new RectF();
        private static RectF bezierRect = new RectF();
        private static Path bezierPath = new Path();
        private static RectF bezier2Rect = new RectF();
        private static Path bezier2Path = new Path();
        private static RectF bezier3Rect = new RectF();
        private static Path bezier3Path = new Path();
        private static RectF ovalRect = new RectF();
        private static Path ovalPath = new Path();
    }
    
    public static void drawCanvas2(Canvas canvas) {
        Pattern.drawCanvas2(canvas, new RectF(0f, 0f, 291f, 353f), ResizingBehavior.AspectFit);
    }
    
    public static void drawCanvas2(Canvas canvas, RectF targetFrame, ResizingBehavior resizing) {
        // General Declarations
        Stack<Matrix> currentTransformation = new Stack<Matrix>();
        currentTransformation.push(new Matrix());
        Paint paint = CacheForCanvas2.paint;
        
        // Local Colors
        int color3 = Color.argb(255, 0, 0, 0);
        
        // Resize to Target Frame
        canvas.save();
        RectF resizedFrame = CacheForCanvas2.resizedFrame;
        Pattern.resizingBehaviorApply(resizing, CacheForCanvas2.originalFrame, targetFrame, resizedFrame);
        canvas.translate(resizedFrame.left, resizedFrame.top);
        canvas.scale(resizedFrame.width() / 291f, resizedFrame.height() / 353f);
        
        // Bezier
        canvas.save();
        canvas.translate(78.35f, 168.06f);
        currentTransformation.peek().postTranslate(78.35f, 168.06f);
        canvas.rotate(20.79f);
        currentTransformation.peek().postRotate(20.79f);
        RectF bezierRect = CacheForCanvas2.bezierRect;
        bezierRect.set(-17f, -157.21f, 17f, 132f);
        Path bezierPath = CacheForCanvas2.bezierPath;
        bezierPath.reset();
        bezierPath.moveTo(-17f, -157.21f);
        bezierPath.lineTo(-17f, 132f);
        bezierPath.lineTo(17f, 132f);
        bezierPath.lineTo(17f, -157.21f);
        bezierPath.lineTo(-17f, -157.21f);
        bezierPath.close();
        
        paint.reset();
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);
        canvas.drawPath(bezierPath, paint);
        
        paint.reset();
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);
        paint.setStrokeWidth(1f);
        paint.setStrokeMiter(10f);
        canvas.save();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        canvas.drawPath(bezierPath, paint);
        canvas.restore();
        canvas.restore();
        
        // Bezier 2
        canvas.save();
        canvas.translate(200.84f, 167.52f);
        currentTransformation.peek().postTranslate(200.84f, 167.52f);
        canvas.rotate(-21.62f);
        currentTransformation.peek().postRotate(-21.62f);
        RectF bezier2Rect = CacheForCanvas2.bezier2Rect;
        bezier2Rect.set(-17f, -157.11f, 17f, 132f);
        Path bezier2Path = CacheForCanvas2.bezier2Path;
        bezier2Path.reset();
        bezier2Path.moveTo(-17f, -157.11f);
        bezier2Path.lineTo(-17f, 132f);
        bezier2Path.lineTo(17f, 132f);
        bezier2Path.lineTo(17f, -157.11f);
        bezier2Path.lineTo(-17f, -157.11f);
        bezier2Path.close();
        
        paint.reset();
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);
        canvas.drawPath(bezier2Path, paint);
        
        paint.reset();
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);
        paint.setStrokeWidth(1f);
        paint.setStrokeMiter(10f);
        canvas.save();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        canvas.drawPath(bezier2Path, paint);
        canvas.restore();
        canvas.restore();
        
        // Group
        {
            // Bezier 3
            canvas.save();
            canvas.translate(142.08f, 185.21f);
            currentTransformation.peek().postTranslate(142.08f, 185.21f);
            canvas.rotate(90f);
            currentTransformation.peek().postRotate(90f);
            RectF bezier3Rect = CacheForCanvas2.bezier3Rect;
            bezier3Rect.set(-17f, -76.56f, 17f, 80.58f);
            Path bezier3Path = CacheForCanvas2.bezier3Path;
            bezier3Path.reset();
            bezier3Path.moveTo(-17f, -76.56f);
            bezier3Path.lineTo(-17f, 80.58f);
            bezier3Path.lineTo(17f, 80.58f);
            bezier3Path.lineTo(17f, -76.56f);
            bezier3Path.lineTo(-17f, -76.56f);
            bezier3Path.close();
            
            paint.reset();
            paint.setFlags(Paint.ANTI_ALIAS_FLAG);
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.BLACK);
            canvas.drawPath(bezier3Path, paint);
            
            paint.reset();
            paint.setFlags(Paint.ANTI_ALIAS_FLAG);
            paint.setStrokeWidth(1f);
            paint.setStrokeMiter(10f);
            canvas.save();
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(Color.BLACK);
            canvas.drawPath(bezier3Path, paint);
            canvas.restore();
            canvas.restore();
        }
        
        // Oval
        RectF ovalRect = CacheForCanvas2.ovalRect;
        ovalRect.set(115f, 5f, 162f, 45f);
        Path ovalPath = CacheForCanvas2.ovalPath;
        ovalPath.reset();
        ovalPath.addOval(ovalRect, Path.Direction.CW);
        
        paint.reset();
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(color3);
        canvas.drawPath(ovalPath, paint);
        
        canvas.restore();
    }
    
    private static class CacheForCanvas3 {
        private static RectF originalFrame = new RectF(0f, 0f, 219f, 297f);
        private static RectF resizedFrame = new RectF();
        private static RectF textRect = new RectF();
        private static TextPaint textTextPaint = new TextPaint();
        private static PaintCodeStaticLayout textStaticLayout = new PaintCodeStaticLayout();
    }
    
    public static void drawCanvas3(Canvas canvas, Context context) {
        Pattern.drawCanvas3(canvas, context, new RectF(0f, 0f, 219f, 297f), ResizingBehavior.AspectFit);
    }
    
    public static void drawCanvas3(Canvas canvas, Context context, RectF targetFrame, ResizingBehavior resizing) {
        // Resize to Target Frame
        canvas.save();
        RectF resizedFrame = CacheForCanvas3.resizedFrame;
        Pattern.resizingBehaviorApply(resizing, CacheForCanvas3.originalFrame, targetFrame, resizedFrame);
        canvas.translate(resizedFrame.left, resizedFrame.top);
        canvas.scale(resizedFrame.width() / 219f, resizedFrame.height() / 297f);
        
        // Text
        RectF textRect = CacheForCanvas3.textRect;
        textRect.set(13f, 0f, 232f, 297f);
        TextPaint textTextPaint = CacheForCanvas3.textTextPaint;
        textTextPaint.reset();
        textTextPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        textTextPaint.setColor(Color.BLACK);
        textTextPaint.setTypeface(Typeface.createFromAsset(context.getAssets(), "HelveticaNeue.ttc"));
        textTextPaint.setTextSize(300f);
        StaticLayout textStaticLayout = CacheForCanvas3.textStaticLayout.get((int) textRect.width(), Layout.Alignment.ALIGN_NORMAL, "A", textTextPaint);
        canvas.save();
        canvas.clipRect(textRect);
        canvas.translate(textRect.left, textRect.top + (textRect.height() - textStaticLayout.getHeight()) / 2f);
        textStaticLayout.draw(canvas);
        canvas.restore();
        
        canvas.restore();
    }
    
    
    // Resizing Behavior
    public static void resizingBehaviorApply(ResizingBehavior behavior, RectF rect, RectF target, RectF result) {
        if (rect.equals(target) || target == null) {
            result.set(rect);
            return;
        }
        
        if (behavior == ResizingBehavior.Stretch) {
            result.set(target);
            return;
        }
        
        float xRatio = Math.abs(target.width() / rect.width());
        float yRatio = Math.abs(target.height() / rect.height());
        float scale = 0f;
        
        switch (behavior) {
            case AspectFit: {
                scale = Math.min(xRatio, yRatio);
                break;
            }
            case AspectFill: {
                scale = Math.max(xRatio, yRatio);
                break;
            }
            case Center: {
                scale = 1f;
                break;
            }
        }
        
        float newWidth = Math.abs(rect.width() * scale);
        float newHeight = Math.abs(rect.height() * scale);
        result.set(target.centerX() - newWidth / 2,
            target.centerY() - newHeight / 2,
            target.centerX() + newWidth / 2,
            target.centerY() + newHeight / 2);
    }
    
    
}

class PaintCodeStaticLayout {
    private StaticLayout layout;
    private int width;
    private Layout.Alignment alignment;
    private CharSequence source;
    private TextPaint paint;
    
    StaticLayout get(int width, Layout.Alignment alignment, CharSequence source, TextPaint paint) {
        if (this.layout == null || this.width != width || this.alignment != alignment || !this.source.equals(source) || !this.paint.equals(paint)) {
            this.width = width;
            this.alignment = alignment;
            this.source = source;
            this.paint = paint;
            this.layout = new StaticLayout(source, paint, width, alignment, 1, 0, false);
        }
        return this.layout;
    }
}
