/*
 * Main Page showing hash tag text.
 * 
 *  @auther Ramesh M Nair
 * 
 * */

package com.hashtagandroid;

import android.app.Activity;
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

public class MainActivity extends Activity implements TagClick {

	TextView mHashTagTextView, mHashTagTextViewTwo;

	TagSelectingTextview mTagSelectingTextview;

	String hastTagColorBlue = "#5BCFF2", hastTagColorRed = "#FF0000",
			hastTagColorYellow = "#FFFF00", hastTagColorGreen = "#014a01",
			testText, currentHashTagColor;

	public static int hashTagHyperLinkEnabled = 1;
	public static int hashTagHyperLinkDisabled = 0;
	int tempHyperlinkStatus;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mTagSelectingTextview = new TagSelectingTextview();// TagSelectingTextview
															// for
															// showing tag
															// without underline

		mHashTagTextView = (TextView) findViewById(R.id.hashtag_textview);
		CheckBox chkIos = (CheckBox) findViewById(R.id.checkBox1);

		testText = getResources().getString(R.string.test_word);

		mHashTagTextView.setMovementMethod(LinkMovementMethod.getInstance());

		// Initially we are setting hash tag color as blue and without
		// underlines to the hash tags
		setHashTag(hastTagColorBlue, hashTagHyperLinkDisabled);

		// Enable or Disable unbeline to a hash Tags

		chkIos.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// is chkIos checked?
				if (((CheckBox) v).isChecked()) {
					setHashTag(currentHashTagColor, hashTagHyperLinkEnabled);
				} else {
					setHashTag(currentHashTagColor, hashTagHyperLinkDisabled);

				}

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void red(View v) {
		// TODO Auto-generated method stub
		setHashTag(hastTagColorRed, tempHyperlinkStatus);
	}

	public void blue(View v) {
		// TODO Auto-generated method stub
		setHashTag(hastTagColorBlue, tempHyperlinkStatus);
	}

	public void green(View v) {
		// TODO Auto-generated method stub
		setHashTag(hastTagColorGreen, tempHyperlinkStatus);
	}

	public void yellow(View v) {
		// TODO Auto-generated method stub
		setHashTag(hastTagColorYellow, tempHyperlinkStatus);
	}

	@Override
	public void clickedTag(String tag) {
		// TODO Auto-generated method stub

		Toast.makeText(getApplicationContext(),
				"You have clicked on hash tag " + tag, 1).show();

	}

	public void setHashTag(String hashtagColor, int mhyperlickStatus) {
		/*
		 * Temp color code and undelinestatus used for showing Example
		 */
		currentHashTagColor = hashtagColor;
		tempHyperlinkStatus = mhyperlickStatus;

		/*
		 * Main Section where we set the hash tag for the textview
		 */
		mHashTagTextView.setText(mTagSelectingTextview.addClickablePart(
				testText, this, mhyperlickStatus, hashtagColor),
				BufferType.SPANNABLE);
	}

}
