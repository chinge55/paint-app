package com.lumen.mnsa_practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class TouchAppView extends View {
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private float x, y;
    private boolean touching, drawingTouch;
    Bitmap drawingBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.download);
    int drawingpic_x = 0, drawingpic_y = 0;
    int drawingPicWidh = drawingBitmap.getWidth();
    int drawingPicHeight = drawingBitmap.getHeight();
    int drawingPicOffset_x = 0, drawingPicOffset_y = 0;
    public TouchAppView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(drawingBitmap, drawingpic_x, drawingpic_y, paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), MeasureSpec.getSize(heightMeasureSpec));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action)
        {
            case MotionEvent.ACTION_DOWN:
                x = event.getX();
                y = event.getY();
                touching = true;
                if((x>drawingpic_x) && (x<drawingpic_x + drawingPicWidh) && (y>drawingpic_y) && (y<drawingpic_y + drawingPicHeight))
                {
                    drawingPicOffset_x = (int)x-drawingpic_x;
                    drawingPicOffset_y = (int)y-drawingpic_y;
                    drawingTouch = true;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                x = event.getX();
                y = event.getY();
                touching = true;
                if(drawingTouch)
                {
                    drawingpic_x = (int)x-drawingPicOffset_x;
                    drawingpic_y = (int)x-drawingPicOffset_y;
                }
                break;
            case MotionEvent.ACTION_UP:

            default:
                drawingTouch = false;
                touching = false;
        }
        invalidate();
        return true;

    }
}
