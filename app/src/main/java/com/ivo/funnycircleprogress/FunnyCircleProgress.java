package com.ivo.funnycircleprogress;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;

public class FunnyCircleProgress extends CircleProgress {


    // ====================== FunnyCircleProgress ======================

    public FunnyCircleProgress(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    // ====================== 动画 ======================

    public void show() {
        ValueAnimator animator = ValueAnimator.ofFloat(100, -100);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                progress = (Float) animation.getAnimatedValue();
                startAngle += startAngleIncrement;
                invalidate();
                if (animation.getAnimatedFraction() == 1 && getVisibility() == VISIBLE) {
                    startAngle += arcAngle;
                    show();
                }
            }
        });
        animator.setDuration(duration);
        animator.start();
        setVisibility(VISIBLE);
    }

    public void hide() {
        setVisibility(INVISIBLE);
    }


    // ====================== duration & startAngleIncrement ======================

    private long duration = 5000;
    private float startAngleIncrement = -3;

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public void setStartAngleIncrement(float startAngleIncrement) {
        this.startAngleIncrement = startAngleIncrement;
    }


}

