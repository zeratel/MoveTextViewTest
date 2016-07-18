package com.lhf.test.movetextviewtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private MoneyProgress mp;
    private MoneyProgress mp2;
    private MoneyProgress mp3;
    private MoneyProgress mp4;
    private MoneyProgress mp5;
    private MoneyProgress mp6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp = (MoneyProgress) findViewById(R.id.mp);
        mp2 = (MoneyProgress) findViewById(R.id.mp2);
        mp3 = (MoneyProgress) findViewById(R.id.mp3);
        mp4 = (MoneyProgress) findViewById(R.id.mp4);
        mp5 = (MoneyProgress) findViewById(R.id.mp5);
        mp6 = (MoneyProgress) findViewById(R.id.mp6);

        mp.setNumber(500,1000);
        mp2.setNumber(300,1000);
        mp3.setNumber(400,1000);
        mp4.setNumber(600,1000);
        mp5.setNumber(700,1000);
        mp6.setNumber(800,1000);

        ((Button)findViewById(R.id.bt)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                mp2.start();
                mp3.start();
                mp4.start();
                mp5.start();
                mp6.start();
            }
        });

//        final RelativeLayout rl = (RelativeLayout) findViewById(R.id.rl);
//        final TextView tv = (TextView) findViewById(R.id.tv);
//        final RelativeLayout rl2 = (RelativeLayout) findViewById(R.id.rl2);
//        final TextView tv2 = (TextView) findViewById(R.id.tv2);
//        final RelativeLayout rl3 = (RelativeLayout) findViewById(R.id.rl3);
//        final TextView tv3 = (TextView) findViewById(R.id.tv3);
//        final RelativeLayout rl4 = (RelativeLayout) findViewById(R.id.rl4);
//        final TextView tv4 = (TextView) findViewById(R.id.tv4);
//        final RelativeLayout rl5 = (RelativeLayout) findViewById(R.id.rl5);
//        final TextView tv5 = (TextView) findViewById(R.id.tv5);
//        final RelativeLayout rl6 = (RelativeLayout) findViewById(R.id.rl6);
//        final TextView tv6 = (TextView) findViewById(R.id.tv6);
//        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(DimenUtil.dp2px(MainActivity.this,1),DimenUtil.dp2px(MainActivity.this,20));
//
//
//        final ValueAnimator animator = ValueAnimator.ofInt(1, 300);
//        animator.setDuration(5000);
//        animator.setInterpolator(new LinearInterpolator());//线性效果变化
//        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator valueAnimator) {
//                Integer integer = (Integer) animator.getAnimatedValue();
////                button.setText("" + integer);
//                tv.setText(String.valueOf(integer));
//                rl.setLayoutParams(layoutParams.);
////                rl.invalidate();
//
//                tv2.setText(String.valueOf(integer));
//                rl2.setLayoutParams(new LinearLayout.LayoutParams(DimenUtil.dp2px(MainActivity.this,integer),DimenUtil.dp2px(MainActivity.this,20)));
////                rl2.invalidate();
//
//                tv3.setText(String.valueOf(integer));
//                rl3.setLayoutParams(new LinearLayout.LayoutParams(DimenUtil.dp2px(MainActivity.this,integer),DimenUtil.dp2px(MainActivity.this,20)));
////                rl3.invalidate();
//
//                tv4.setText(String.valueOf(integer));
//                rl4.setLayoutParams(new LinearLayout.LayoutParams(DimenUtil.dp2px(MainActivity.this,integer),DimenUtil.dp2px(MainActivity.this,20)));
////                rl4.invalidate();
//
//                tv5.setText(String.valueOf(integer));
//                rl5.setLayoutParams(new LinearLayout.LayoutParams(DimenUtil.dp2px(MainActivity.this,integer),DimenUtil.dp2px(MainActivity.this,20)));
////                rl5.invalidate();
//
//                tv6.setText(String.valueOf(integer));
//                rl6.setLayoutParams(new LinearLayout.LayoutParams(DimenUtil.dp2px(MainActivity.this,integer),DimenUtil.dp2px(MainActivity.this,20)));
////                rl6.invalidate();
//            }
//        });
//        animator.start();

    }
}
