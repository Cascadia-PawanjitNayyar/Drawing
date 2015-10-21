package edu.cascadia.brianb.mydrawing;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Edited by Brian Bansenauer on 10/18/15.
 */
public class SimplyDrawnView extends View {

    private Paint mPaint;
    private Path mPath;
    private RectF mOval;
    private float mWidth, mHeight;

    public SimplyDrawnView(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
        mPaint = new Paint();
        mPath = new Path();
    }
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE); //draw background

        //Draw line
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(2);
        canvas.drawLine(mWidth, 0, 200, mHeight, mPaint);

        //Draw red line
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(10);
        canvas.drawLine(275, 850, 600, 1200, mPaint);

        //Draw green lines


        mPaint.setColor(Color.GREEN);
        mPaint.setStrokeWidth(30);
        canvas.drawLine(0, 100, 900, 100, mPaint);

        mPaint.setAlpha(200);
        canvas.drawLine(0, 250, 900, 250, mPaint);


        mPaint.setAlpha(150);
        canvas.drawLine(0, 400, 900, 400, mPaint);

        mPaint.setAlpha(100);
        canvas.drawLine(0, 550, 900, 550, mPaint);

        mPaint.setAlpha(50);
        canvas.drawLine(0, 700, 900, 700, mPaint);

        //Draw Text
        mPaint.setColor(Color.BLACK);
        mPaint.setTextSize(24);
        canvas.drawText("I am drawing", 10, 800, mPaint);

        //Draw Text on a Path
        mPaint.setColor(Color.CYAN);
        mPaint.setTextSize(26);
       // mPath.addCircle(275, 850, 110, Path.Direction.CW);
        mOval = new RectF();
        mOval.set(0,0,mWidth,mWidth);
        mPath.addArc(mOval, 180,0 );
        canvas.drawTextOnPath("drawing on a path can be lots of fun", mPath, 400, -10, mPaint);


        //Draw filled, opaque, and open ovals

        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        canvas.drawCircle(275, 850, 100, mPaint);

       mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAlpha(50);
        canvas.drawCircle(275, 850, 98, mPaint);
        mPaint.setColor(Color.RED);
        canvas.drawCircle(275,850,10,mPaint);


        //Draw bee bitmap
        Drawable b = getResources().getDrawable(R.drawable.bee,null);
        int x=50, y = 200;

    }
}
