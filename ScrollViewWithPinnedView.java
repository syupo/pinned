package com.example.window;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

/**
 * ScrollViewWithPinnedView
 * 
 * @author lxp
 * @date 2013-8-7
 */
public class ScrollViewWithPinnedView extends ScrollView {
	private static final String TAG = "ScrollViewWithPinnedView";
	/** Pinned View */
	private View mPinnedView;
	/** The Width of Pinned View */
	private int mPinnedViewWidth;
	/** The Heigh of Pinned View */
	private int mPinnedViewHeight;
	/** The Top Position of Pinned View */
	private int mPinnedViewOriginalTop;

	/**
	 * 构造方法
	 * 
	 * @param context
	 */
	public ScrollViewWithPinnedView(Context context) {
		super(context);
	}

	/**
	 * 构造方法
	 * 
	 * @param context
	 * @param attrs
	 */
	public ScrollViewWithPinnedView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	/**
	 * @param view
	 */
	public void setPinnedView(View view) {
		this.mPinnedView = view;
		requestLayout();
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		Log.d(TAG, "onMeasure");
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		if (mPinnedView != null) {
			
			// 测量mPinnedView的尺寸大小
			measureChild(mPinnedView, widthMeasureSpec, heightMeasureSpec);
			mPinnedViewWidth = mPinnedView.getMeasuredWidth();
			mPinnedViewHeight = mPinnedView.getMeasuredHeight();
			
			// 计算mPinnedView距离它的父容器顶部距离
			mPinnedViewOriginalTop = mPinnedView.getTop();
		}
	}

	@Override
	protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
		Log.d(TAG, "onLayout");
		super.onLayout(changed, left, top, right, bottom);
	}

	@Override
	protected void dispatchDraw(Canvas canvas) {
		Log.d(TAG, "dispatchDraw");
		super.dispatchDraw(canvas);
	}

	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
		Log.d(TAG, "onScrollChanged");
		super.onScrollChanged(l, t, oldl, oldt);

		if (mPinnedView == null) {
			return;
		}

		if (mPinnedViewOriginalTop <= t) {
			mPinnedView.layout(0, t, mPinnedViewWidth, mPinnedViewHeight + t);
		} else {
			mPinnedView.layout(0, mPinnedViewOriginalTop, mPinnedViewWidth, mPinnedViewOriginalTop + mPinnedViewHeight);
		}
		
		mPinnedView.bringToFront();
	}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		return super.onTouchEvent(ev);
	}
};
