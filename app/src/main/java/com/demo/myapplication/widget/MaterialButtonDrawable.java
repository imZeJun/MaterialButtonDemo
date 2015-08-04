package com.demo.myapplication.widget;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.Shape;

public class MaterialButtonDrawable extends ShapeDrawable {

	private Paint mPaint;
	private int mDuration;

	public MaterialButtonDrawable(int color) {
		mPaint = new Paint();
		mPaint.setColor(color);
		mPaint.setAntiAlias(true);
		setShape(new OvalShape());
	}

	@Override
	protected void onDraw(Shape shape, Canvas canvas, Paint paint) {
		canvas.drawCircle(canvas.getWidth() / 2, canvas.getHeight() / 2, canvas.getHeight() / 2, mPaint);
	}

	public void setDuration(int duration) {
		mDuration = duration;
	}

	public int getDuration() {
		return mDuration;
	}

	public void changeColor(int color) {
		ValueAnimator valueAnimator = ValueAnimator.ofArgb(mPaint.getColor(), color); //ÐèÒªAPI21¡£
		valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				int color = (int) animation.getAnimatedValue();
				mPaint.setColor(color);
				invalidateSelf();
			}
		});
		if (mDuration != 0) {
			valueAnimator.setDuration(mDuration);
			valueAnimator.start();
		}
	}
}
