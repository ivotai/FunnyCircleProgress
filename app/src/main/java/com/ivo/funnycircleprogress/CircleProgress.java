package com.ivo.funnycircleprogress;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.ColorInt;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

public class CircleProgress extends View {


    // ====================== CircleProgress ======================

    public CircleProgress(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        int defaultProgressColor = ContextCompat.getColor(context, R.color.md_teal_200);
        paint.setColor(defaultProgressColor);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(strokeWidth);
        paint.setStrokeCap(Paint.Cap.ROUND);
    }


    // ====================== fields ======================

    private final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final RectF strokeRect = new RectF();
    protected float strokeWidth = 30f;
    protected float progress = 100f;
    protected float startAngle = -90f;
    protected float arcAngle = 90f;


    // ====================== onSizeChanged ======================

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        updateStrokeRect();
    }

    private void updateStrokeRect() {
        float delta = strokeWidth / 2;
        strokeRect.set(delta, delta, getWidth() - delta, getHeight() - delta);
    }


    // ====================== onDraw ======================

    @Override
    protected void onDraw(Canvas canvas) {
        drawProgress(canvas);
    }

    private void drawProgress(Canvas canvas) {
        float sweepAngle = (progress / 100) * (360 - arcAngle);
        drawArcPath(canvas, startAngle, sweepAngle, paint);
    }

    private void drawArcPath(Canvas canvas, float startAngle, float sweepAngle, Paint paint) {
        Path temp = new Path();
        temp.addArc(strokeRect, startAngle, sweepAngle);
        canvas.drawPath(temp, paint);
    }


    // ====================== setter ======================

    public void setStartAngle(float startAngle) {
        this.startAngle = startAngle;
        invalidate();
    }

    public void setArcAngle(float arcAngle) {
        this.arcAngle = arcAngle;
        invalidate();
    }

    public void setStrokeWidth(float strokeWidth) {
        this.strokeWidth = strokeWidth;
        onStrokeWidthChange();
    }

    private void onStrokeWidthChange() {
        updateStrokeRect();
        paint.setStrokeWidth(strokeWidth);
        invalidate();
    }

    public void setProgressColor(@ColorInt int progressColor) {
        paint.setColor(progressColor);
        invalidate();
    }

    public void setProgress(float progress) {
        this.progress = progress;
        invalidate();
    }


}
