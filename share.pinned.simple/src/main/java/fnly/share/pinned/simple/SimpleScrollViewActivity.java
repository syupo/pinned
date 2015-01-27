package fnly.share.pinned.simple;

import fnly.share.pinned.ScrollViewPinnedImpl;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;

public class SimpleScrollViewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_simple_scrollview);

		ScrollViewPinnedImpl scroller = (ScrollViewPinnedImpl) findViewById(R.id.main_scroll);
		View pinned = LayoutInflater.from(this).inflate(R.layout.view_pinned, scroller.getPinnedViewContainer(), false);
		scroller.setPinnedView(pinned);
		scroller.markPinnedViewStartLocationRef(R.id.pinned);
		// scroller.markPinnedViewStartLocation(0,30);

		findViewById(R.id.hideme).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				v.setVisibility(View.GONE);
			}
		});
		findViewById(R.id.hideme_2).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				v.setVisibility(View.GONE);
			}
		});
	}

}
