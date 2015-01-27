package fnly.share.pinned;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.ScrollView;

/**
 * ScrollViewPinnedImpl
 * <p>
 * ScrollViewPinnedImpl is a special scroll view that can pinned a custom view
 * on screen at a position when you scroll the screen use a {@link ScrollView}.
 * </p>
 * 
 */
public class ScrollViewPinnedImpl extends ScrollView {
	private static final String TAG = "ScrollViewPinnedImpl";

	private View mPinnedView;
	private FrameLayout mPinnedViewParent;
	private View mPinnedViewRefView;
	private int[] mPinnedViewLocation;

	/**
	 * @param context
	 */
	public ScrollViewPinnedImpl(Context context) {
		this(context, null);
	}

	/**
	 * @param context
	 * @param attrs
	 */
	public ScrollViewPinnedImpl(Context context, AttributeSet attrs) {
		this(context, attrs, android.R.attr.scrollViewStyle);
	}

	/**
	 * @param context
	 * @param attrs
	 * @param defStyle
	 */
	public ScrollViewPinnedImpl(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
			public void onGlobalLayout() {
				if (needComputePinnerLocation()) {
					computePinnerLocation(mPinnedViewRefView);
				}
				int offY = getScrollY();
				int top = mPinnedViewLocation[0];
				int left = mPinnedViewLocation[1];
				pinned(mPinnedView, left, Math.max(offY, top));
			}
		});
	}

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		if (getChildCount() > 0) {
			View root = getChildAt(0);
			if (!(root instanceof FrameLayout)) {
				throw new RuntimeException("first layout should be frameLayout.");
			}
			mPinnedViewParent = (FrameLayout) root;
		}
	}

	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
		super.onScrollChanged(l, t, oldl, oldt);
		if (needComputePinnerLocation()) {
			computePinnerLocation(mPinnedViewRefView);
		}
		int top = mPinnedViewLocation[0];
		int left = mPinnedViewLocation[1];

		int offY = t;

		Log.d(TAG, "scroll y:" + offY);

		if (oldt - t < 0) {
			// scroll up
			if (top <= offY) {
				pinned(mPinnedView, left, Math.max(offY, top));
				mPinnedView.setVisibility(View.VISIBLE);
			}
		} else if (oldt - t > 0) {
			// scroll down
			if (top >= offY) {
				pinned(mPinnedView, left, 0);
				mPinnedView.setVisibility(View.INVISIBLE);
			} else {
				pinned(mPinnedView, left, Math.max(offY, top));
				mPinnedView.setVisibility(View.VISIBLE);
			}
		}
	}

	private boolean needComputePinnerLocation() {
		return mPinnedViewRefView != null;
	}

	private void computePinnerLocation(View refView) {
		int top = refView.getTop();
		if (mPinnedViewLocation[0] != top) {
			mPinnedViewLocation[0] = top;
		}
		int left = refView.getLeft();
		if (mPinnedViewLocation[1] != left) {
			mPinnedViewLocation[1] = left;
		}
	}

	/**
	 * pinned the view on screen's location.
	 * 
	 * @param view
	 *            a view to be pinned.
	 * @param left
	 *            left position, relative to parent
	 * @param top
	 *            top position, relative to parent
	 */
	private void pinned(View view, int left, int top) {
		int width = view.getMeasuredWidth();
		int height = view.getMeasuredHeight();
		view.layout(left, top, left + width, top + height);

		Log.d(TAG, "pinned location top:" + top);
		Log.d(TAG, "pinned location left:" + left);
	}

	/**
	 * get pinned view's parent. (should be first child of scroll view.)
	 * 
	 * @return container
	 */
	public FrameLayout getPinnerContainer() {
		return mPinnedViewParent;
	}

	/**
	 * attach a view to scroll view(actually, the first child of scroll view).
	 * it will be pinned a location when you scroll screen.
	 * 
	 * @param view
	 *            a view that will be fixed a location.
	 * @return this instance
	 */
	public ScrollViewPinnedImpl setPinner(View view) {
		mPinnedViewParent.addView(view);
		view.setVisibility(View.INVISIBLE);
		mPinnedView = view;
		return this;
	}

	/**
	 * mark the location that the view will be pinned, when you scroll the
	 * screen.
	 * 
	 * @param left
	 *            a left position, relative to parent
	 * @param top
	 *            a top position, relative to parent
	 * @return this instance
	 */
	public ScrollViewPinnedImpl markPinnerStartLocation(int left, int top) {
		mPinnedViewLocation = new int[2];
		mPinnedViewLocation[0] = top;
		mPinnedViewLocation[1] = left;
		mPinnedViewRefView = null;
		return this;
	}

	/**
	 * mark the location use a reference location of specific view.
	 * 
	 * @param id
	 *            a child of scroll view'id
	 * @return this instance
	 */
	public ScrollViewPinnedImpl markPinnerStartLocationRef(int id) {
		mPinnedViewRefView = mPinnedViewParent.findViewById(id);
		mPinnedViewLocation = new int[2];
		return this;
	}
}
