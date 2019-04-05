package com.test.boringviewlibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;



public class SoBoringView extends View {

    Paint mPaint;
    Rect mRect;
    int mSquareColor;
    int mCircleColor;


    public SoBoringView(Context context) {
        super(context);
        init(null);
    }

    public SoBoringView(Context context,  AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public SoBoringView(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public SoBoringView(Context context,  AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }


    private void init(@Nullable AttributeSet set){

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mRect = new Rect();

        if(set == null){
            return;
        }

        TypedArray ta = getContext().obtainStyledAttributes(set, R.styleable.MyCustomView);
        mSquareColor = ta.getColor(R.styleable.MyCustomView_square_color, Color.GREEN);
        mCircleColor = ta.getColor(R.styleable.MyCustomView_circle_color, Color.BLUE);
        mPaint.setColor(mSquareColor);
        ta.recycle();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mRect.left = 0;
        mRect.right = getWidth();
        mRect.top = 0;
        mRect.bottom = getHeight();

        canvas.drawRect(mRect, mPaint);

        mPaint.setColor(mCircleColor);
        canvas.drawCircle(getWidth()/2,getWidth()/2,getWidth()/2,mPaint);
    }


}
