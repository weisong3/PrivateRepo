package com.sns_sample.custom_views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class SquareRelativeLayout extends RelativeLayout {

	public SquareRelativeLayout(Context context) {
		super(context);
	}

	public SquareRelativeLayout(Context context, AttributeSet attrs,
			int defStyle) {
		super(context, attrs, defStyle);
	}

	public SquareRelativeLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
	    super.onMeasure(widthMeasureSpec, widthMeasureSpec);
	}
}