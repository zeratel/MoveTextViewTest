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
    private int textColor = 0xff000000;

    private int x = 0;
    private String text = "";
    private ValueAnimator animator;
//    private int durationTime = 1500;
    private int durationTime = 0;
    private int textSize = 16;
    private int rectHeight = 28;
    private int viewWidth = 0;
    private int viewHeight = 0;
    private float percentWidth = 0;
    private float rate;
    private int startColor = 0xfffb3a24;
    private int endColor = 0xfffb6049;
    private int showNumber = 0;
    private String periods = "1";
    private int wordWidth;
    private int wordH;
    private int tempRectHeight;
    private String time = "2018-7-2";
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

//        wordWidth = DimenUtil.dp2px(mContext, textSize);
        wordWidth = (int) backgroundPaint.measureText("第");
        wordH = (int) (-backgroundPaint.ascent());
        tempRectHeight = DimenUtil.dp2px(mContext, rectHeight);
    }

    public MoneyProgress setPeriods(String periods) {
        this.periods = periods;
        return this;
    }

    public MoneyProgress setTime(String time) {
        this.time = time;
        return this;
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
        viewWidth = (int) (getMeasuredWidth() - wordWidth * 6);
        viewHeight = getMeasuredHeight();

        //应该显示的宽度
        float showWidth = (float) viewWidth * rate;

        //每次应该显示的数量
        percentWidth = showWidth / (float) 100;

        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), DimenUtil.dp2px(mContext, rectHeight));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //前
        canvas.drawText("第" + periods + "期",
                0,
                (tempRectHeight - wordH) / 2 + wordH,
                backgroundPaint);

        //方块
        canvas.drawRect((float) (wordWidth * 2.6),
                0,
                x + wordWidth * 3,
                tempRectHeight, fillPaint);

        //日期
        canvas.drawText("" + time,
                (float) (wordWidth * 2.6) + wordWidth / 5,
                (tempRectHeight - wordH) / 2 + wordH,
                backgroundPaint);

        //后
        canvas.drawText("" + showNumber,
                x + wordWidth * 3 + wordWidth / 5,
                (tempRectHeight - wordH) / 2 + wordH,
                backgroundPaint);
    }

    public void start() {
        if (animator != null) {
            animator.start();
        }
    }
}
