package com.lhf.test.movetextviewtest;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * com.lhf.test.movetextviewtest
 * Created by zeratel3000
 * on 2016 07 16/7/18 15 35
 * description
 */
public class MoneyProgress extends View {

    private Context mContext;
    private Paint fillPaint;
    private Paint backgroundPaint;
    private int textColor = 0xffffffff;

    private int x = 0;
    private String text = "";
    private ValueAnimator animator;
    private int durationTime = 1500;
    private int textSize = 20;
    private int rectHeight = 30;
    private int viewWidth = 0;
    private int viewHeight = 0;
    private float percentWidth = 0;
    private float rate;
    private int startColor = 0xfffb3a24;
    private int endColor = 0xfffb6049;
    private int showNumber = 0;
//    private int startColor = 0xff000000;
//    private int endColor = 0xffffffff;

    public MoneyProgress(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public MoneyProgress(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    public MoneyProgress(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
    }

    private void init() {
        fillPaint = new Paint();
        fillPaint.setAntiAlias(true);

//        LinearGradient shader = new LinearGradient(
//                0, 0,
//                0, h,
//                colors,
//                positions,
//                Shader.TileMode.MIRROR);
//        fillPaint.setShader(shader);

        backgroundPaint = new Paint();
        backgroundPaint.setColor(textColor);
        backgroundPaint.setAntiAlias(true);
        backgroundPaint.setTextSize(DimenUtil.dp2px(mContext, textSize));

        animator = ValueAnimator.ofInt(1, 100);
        animator.setDuration(durationTime);
        animator.setInterpolator(new LinearInterpolator());//线性效果变化
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Integer integer = (Integer) animator.getAnimatedValue();

                //1到100需要转换下

//                x = DimenUtil.dp2px(mContext, integer);
                x = (int) ((float) integer * percentWidth);

                fillPaint.setShader(new LinearGradient(0, 0, x, 0, startColor, endColor, Shader.TileMode.CLAMP));
                text = String.valueOf(x);
                invalidate();

            }
        });
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                text = String.valueOf(showNumber);
                invalidate();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

    }

    public MoneyProgress setNumber(int number, int maxNumber) {

        showNumber = number;

        //比例
        rate = (float) number / (float) maxNumber;

        return this;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

//        Log.i("LHF", "widthMeasureSpec:" + getMeasuredWidth() + ",heightMeasureSpec:" + getMeasuredHeight());
        viewWidth = getMeasuredWidth();
        viewHeight = getMeasuredHeight();

        //应该显示的宽度
        float showWidth = (float) viewWidth * rate;

        //每次应该显示的数量
        percentWidth = showWidth / (float) 100;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawRect(0, 0, 1 + x, DimenUtil.dp2px(mContext, rectHeight), fillPaint);
        canvas.drawText("￥" + text, x - (DimenUtil.dp2px(mContext, 15)) * (text.length() + 1), DimenUtil.dp2px(mContext, (rectHeight - textSize) / 4 + textSize), backgroundPaint);
    }

    public void start() {
        if (animator != null) {
            animator.start();
        }
    }
}
