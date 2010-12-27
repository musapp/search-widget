package ru.j2ee.moskvin;


import java.lang.ref.WeakReference;
import java.util.ArrayList;

import ru.j2ee.moskvin.exception.SearchException;
import ru.j2ee.moskvin.widget.SearchPanel;
import ru.j2ee.moskvin.widget.SearchPanel.SearchListener;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

public class SearchDemo extends Activity implements SearchListener {
	private static final String TAG = "SearchDemo";

	private SearchPanel searchPanel;
	private ArrayAdapter<String> searchAdapter = null;
	private ArrayList<String> suggestions = new ArrayList<String>();
	private WeakReference<SearchTask> searchTaskReference;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		searchPanel = (SearchPanel) findViewById(R.id.search_panel);
		try {
			searchPanel.setSearchTag("tag_search");
			searchPanel.setSearchListener(this);
			searchAdapter = new SuggestionArrayAdapter(this, R.layout.search_list_item, suggestions);
			searchPanel.setSearchAdapter(searchAdapter);
		} catch (SearchException e) {
			Log.e(TAG, "Init search widget failed", e);
			finish();
		}
	}

	/**
	 * @see ru.j2ee.moskvin.widget.SearchPanel.SearchListener#onAutoSuggestion(java.lang.String)
	 */
	@Override
	public void onAutoSuggestion(String query) {
		SearchTask task = new SearchTask(query);
		task.execute();
		searchTaskReference = new WeakReference<SearchTask>(task);
	}

	/**
	 * @see ru.j2ee.moskvin.widget.SearchPanel.SearchListener#onClear()
	 */
	@Override
	public void onClear() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see ru.j2ee.moskvin.widget.SearchPanel.SearchListener#onClickSearchResult(java.lang.String)
	 */
	@Override
	public void onClickSearchResult(String query) {
		// TODO Auto-generated method stub
		
	}

	private class SearchTask extends AsyncTask<Void, Void, Void> {
		private final String query;

		/**
		 * Default constructor
		 */
		public SearchTask(String query) {
			super();
			this.query = query;
		}

		@Override
		protected void onPostExecute(Void result) {
			searchAdapter.add("item1");
			searchAdapter.add("item2");
			searchAdapter.add("item3");
			searchAdapter.add("item4");
			searchPanel.hideSearchForLabel(true);
			super.onPostExecute(result);
		}

		@Override
		protected void onPreExecute() {
			if (searchPanel != null) {
				searchPanel.hideSearchForLabel(false);
				searchPanel.setTextSearchResult(getResources().getString(R.string.search_for) + " \"" + query + "\"");
				searchPanel.beforeShowResult();
			}
			searchAdapter.clear();
			suggestions.clear();
			super.onPreExecute();
		}

		@Override
		protected Void doInBackground(Void... params) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
			}
			return null;
		}
		
	}
}