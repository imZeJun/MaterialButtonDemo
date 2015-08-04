package com.demo.myapplication.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.ImageButton;

import com.demo.myapplication.R;

public class MaterialButton extends ImageButton {

	private MaterialButtonDrawable mMaterialButtonDrawable;
	private int mColor;
	private int mDuration;

	public MaterialButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context, attrs);
	}

	public MaterialButton(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init(context, attrs);
	}

	private void init(Context context, AttributeSet attrs) {
		TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MaterialButton);
		mColor = typedArray.getColor(R.styleable.MaterialButton_init_color, Color.BLACK);
		mDuration = typedArray.getColor(R.styleable.MaterialButton_init_duration, 0);
		typedArray.recycle();
		mMaterialButtonDrawable = new MaterialButtonDrawable(mColor);
		mMaterialButtonDrawable.setDuration(mDuration);
		setBackground(mMaterialButtonDrawable);
	}

	public void changeColor(int color) {
		mMaterialButtonDrawable.changeColor(color);
	}
}
