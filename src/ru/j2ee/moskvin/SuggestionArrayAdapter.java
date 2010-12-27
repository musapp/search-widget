/**
 * 
 */
package ru.j2ee.moskvin;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


/**
 * @author Nikolay Moskvin <moskvin@j2ee.ru>
 * @date 01.11.2010
 *
 */
public class SuggestionArrayAdapter extends ArrayAdapter<String> {
	private Context context;
	private List<String> suggestions;

	/**
	 * @param context
	 * @param textViewResourceId
	 * @param objects
	 */
	public SuggestionArrayAdapter(Context context, int textViewResourceId,
			List<String> objects) {
		super(context, textViewResourceId, objects);
		this.context = context;
		this.suggestions = objects;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = convertView;
		if (view == null) {
			view = View.inflate(context, R.layout.search_list_item, null);
		}
		String suggestion = suggestions.get(position);
		if (null != suggestion) {
			TextView textView = (TextView) view.findViewById(R.id.search_list_item_text);
			if (textView != null) {
				textView.setText(suggestion);
			}
		}
		return view;
	}

	
}
