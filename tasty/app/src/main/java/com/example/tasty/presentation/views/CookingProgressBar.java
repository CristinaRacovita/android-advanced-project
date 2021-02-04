package com.example.tasty.presentation.views;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import androidx.annotation.Nullable;

import com.example.tasty.R;

public class CookingProgressBar extends View {
    private Paint mPaint;
    private RectF mRect;
    private float mIndeterminateSweep;
    private float mStartAngle;

    public CookingProgressBar(Context context) {
        super(context);
        init(context);
    }

    public CookingProgressBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CookingProgressBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(context.getColor(R.color.accentColor));
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(8f);
        mPaint.setStrokeCap(Paint.Cap.BUTT);
        mRect = new RectF(200, 200, 800, 800);
        mIndeterminateSweep = 10f;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) { //randarea componentei la layout
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int xPad = getPaddingLeft() + getPaddingRight();
        int yPad = getPaddingTop() + getPaddingBottom();
        int width = getMeasuredWidth() - xPad;
        int height = getMeasuredHeight() - yPad;
        int mSize = Math.min(width, height);
        setMeasuredDimension(mSize + xPad, mSize + yPad);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) { //assign a size to all of its children
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) { // desenarea efectiva pe un canvas
        super.onDraw(canvas);
        canvas.drawArc(mRect, mStartAngle, mIndeterminateSweep, false, mPaint);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        animateArch();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    private void animateArch() {
        final ValueAnimator frontEndExtend = ValueAnimator.ofFloat(0, 360);
        frontEndExtend.setDuration(5000);
        frontEndExtend.setInterpolator(new LinearInterpolator());
        frontEndExtend.addUpdateListener(animation -> {
            mStartAngle = (Float) animation.getAnimatedValue();
            mIndeterminateSweep += 2;
            if (mIndeterminateSweep > 360)
                mIndeterminateSweep = 15f;
            invalidate();
        });
        frontEndExtend.start();
        frontEndExtend.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                animateArch();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }
}
