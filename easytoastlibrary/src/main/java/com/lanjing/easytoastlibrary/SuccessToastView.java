package com.lanjing.easytoastlibrary;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * Created by rahul on 22/7/16.
 */
public class SuccessToastView extends View {

    RectF rectF = new RectF();//矩形区域
    ValueAnimator valueAnimator;//传值动画
    float mAnimatedValue = 0f;//动画参数值
    private Paint mPaint;//画笔
    private float mWidth = 0f;
    private float mEyeWidth = 0f;
    private float mPadding = 0f;
    private float endAngle = 0f;
    private boolean isSmileLeft = false;
    private boolean isSmileRight = false;

    public SuccessToastView(Context context) {
        super(context);
    }

    public SuccessToastView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SuccessToastView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //测量控件大小  设置画笔   和  矩形区域
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        initPaint();
        initRect();
        mWidth = getMeasuredWidth();//获取自定义控件宽度
        mPadding = dip2px(10);//填充区域大小
        mEyeWidth = dip2px(3);//眼睛大小
    }

    private void initPaint() {
        mPaint = new Paint();
        // setAntiAlias() 绘画抗锯齿   true   为开启   setDither()  绘画防抖动    true   为开启
        mPaint.setAntiAlias(true);
        //FILL：填充内容；STROKE：描边；FILL_AND_STROKE：填充内容并描边。
        mPaint.setStyle(Paint.Style.STROKE);
        //设置画笔颜色
        mPaint.setColor(Color.parseColor("#5cb85c"));
        //描边线条宽度
        mPaint.setStrokeWidth(dip2px(2));
    }

    private void initRect() {
        // RectF（float left,float top,float right,float bottom）构造一个指定了4个参数的矩形
        rectF = new RectF(mPadding, mPadding, mWidth - mPadding, mWidth - mPadding);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 描边
        mPaint.setStyle(Paint.Style.STROKE);
        //drawArc(float left, float top, float right, float bottom, float startAngle, float sweepAngle, boolean useCenter, Paint paint)
        //当左 上 右 下 这个参数一致时可以用一个值代替，如下面的rectF  startAngle
        // 表示绘画的开始值  ednAngle  表示绘画的结束值 180  就是一个半圆  useCenter 是否连接圆心   Paint  使用画笔

        canvas.drawArc(rectF, 180, endAngle, false, mPaint);
        //填充内容
        mPaint.setStyle(Paint.Style.FILL);
        if (isSmileLeft) {
            canvas.drawCircle(mPadding + mEyeWidth + mEyeWidth / 2, mWidth / 3, mEyeWidth, mPaint);
        }
        if (isSmileRight) {
            canvas.drawCircle(mWidth - mPadding - mEyeWidth - mEyeWidth / 2, mWidth / 3, mEyeWidth, mPaint);
        }
    }

    public int dip2px(float dpValue) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public void startAnim() {
        stopAnim();
        startViewAnim(0f, 1f, 2000);
    }

    public void stopAnim() {
        if (valueAnimator != null) {
            clearAnimation();
            isSmileLeft = false;
            isSmileRight = false;
            mAnimatedValue = 0f;
            valueAnimator.end();
        }
    }

    private ValueAnimator startViewAnim(float startF, final float endF, long time) {
        valueAnimator = ValueAnimator.ofFloat(startF, endF);
        valueAnimator.setDuration(time);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {

                mAnimatedValue = (float) valueAnimator.getAnimatedValue();
                if (mAnimatedValue < 0.5) {
                    isSmileLeft = false;
                    isSmileRight = false;
                    endAngle = -360 * (mAnimatedValue);
                } else if (mAnimatedValue > 0.55 && mAnimatedValue < 0.7) {
                    endAngle = -180;
                    isSmileLeft = true;
                    isSmileRight = false;
                } else {
                    endAngle = -180;
                    isSmileLeft = true;
                    isSmileRight = true;
                }

                postInvalidate();
            }
        });

        if (!valueAnimator.isRunning()) {
            valueAnimator.start();

        }
        return valueAnimator;
    }
}