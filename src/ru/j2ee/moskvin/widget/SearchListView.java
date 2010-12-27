/**
 * 
 */
package ru.j2ee.moskvin.widget;

import ru.j2ee.moskvin.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

/**
 * @author Nikolay Moskvin <moskvin@j2ee.ru>
 * @date 02.12.2010
 *
 */
public class SearchListView extends RelativeLayout {

	/**
	 * @param context
	 * @param attrs
	 * @param defStyle
	 */
	public SearchListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context);
	}

	/**
	 * @param context
	 * @param attrs
	 */
	public SearchListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	/**
	 * @param context
	 */
	public SearchListView(Context context) {
		super(context);
		init(context);
	}

	/**
	 * Inflate search_list_view.xml and 
	 * configuration all view
	 * @param context is current context of activity 
	 */
	private void init(Context context) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.search_list_view, this, true);
		setClickable(true);
		setFocusable(true);
	}


}
