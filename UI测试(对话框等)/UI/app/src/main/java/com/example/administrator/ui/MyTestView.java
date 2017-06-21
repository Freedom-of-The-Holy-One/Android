package com.example.administrator.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2016/10/11 0011.
 */

public class MyTestView extends View {

    private Paint mPaint;
    private Path mPath;
    private float mFloat_x;
    private float mFloat_y;

    public MyTestView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint=new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);

        mPath=new Path();

//        mPaintBezier = new Paint(Paint.ANTI_ALIAS_FLAG);
//        mPaintBezier.setStyle(Paint.Style.STROKE);
//        mPaintBezier.setStrokeWidth(8)
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
//        canvas.drawCircle(200,200,200,mPaint);
//        canvas.drawLine(100,100,300,300,mPaint);
//          canvas.drawRect(150, 75, 250, 120,mPaint);
//        mPath.moveTo(20,30);
//        mPath.lineTo(30,30);
//        mPath.lineTo(40,30);
//        mPath.lineTo(20,60);
//        mPath.close();
//        canvas.drawPath(mPath,mPaint);

//          mPath.moveTo(100,100);
//          mPath.quadTo(100,150,200,300);
//          mPath.close();
//          canvas.drawPath(mPath,mPaint);
            canvas.drawPath(mPath,mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mFloat_x=event.getX();
        mFloat_y=event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                mPath.moveTo(mFloat_x,mFloat_y);
                return true;
            case MotionEvent.ACTION_MOVE:
                mPath.lineTo(mFloat_x,mFloat_y);
                break;
        }
        postInvalidate();
        return false;
    }
}
