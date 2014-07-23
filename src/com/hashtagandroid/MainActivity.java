/*
 * Main Page showing hash tag text.
 * 
 *  @auther Ramesh M Nair
 * 
 * */

package com.hashtagandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import android.widget.Toast;

import com.hashtagandroid.interfaces.TagClick;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}

	public void exampleActivity(View v) {
		startActivity(new Intent(getApplicationContext(), HashTagActivity.class));
	}

	public void exampleListview(View v) {
		startActivity(new Intent(getApplicationContext(), ListViewHashTag.class));

	}

}
