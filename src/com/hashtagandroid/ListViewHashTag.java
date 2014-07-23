package com.hashtagandroid;

import com.hashtagandroid.adaptors.HashTagAdaptor;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class ListViewHashTag extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hashtag_listview);

		ListView lv = (ListView) findViewById(R.id.list);
		lv.setAdapter(new HashTagAdaptor(ListViewHashTag.this));
	}

}
