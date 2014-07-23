/*
 * Class handling the hash tags in a string.
 *  @auther Ramesh M Nair
 * 
 * */

package com.hashtagandroid;

import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.hashtagandroid.interfaces.TagClick;

public class TagSelectingTextview {

	String mhastTagColor;
	TagClick mTagClick;
	int mHypeLinkEnabled;

	public SpannableStringBuilder addClickablePart(String nTagString,
			TagClick TagClick, int hypeLinkEnabled, String hastTagColor) {

		this.mhastTagColor = hastTagColor;

		this.mHypeLinkEnabled = hypeLinkEnabled;

		this.mTagClick = TagClick;

		SpannableStringBuilder string = new SpannableStringBuilder(nTagString);

		int start = -1;
		for (int i = 0; i < nTagString.length(); i++) {
			if (nTagString.charAt(i) == '#') {
				start = i;
			} else if (nTagString.charAt(i) == ' '
					|| (i == nTagString.length() - 1 && start != -1)) {
				if (start != -1) {
					if (i == nTagString.length() - 1) {
						i++; // case for if hash is last word and there is no
								// space after word
					}

					final String tag = nTagString.substring(start, i);
					string.setSpan(new ClickableSpan() {

						@Override
						public void onClick(View widget) {
							
							// Click on each tag will get here
							
							Log.d("TAg--HAsh", String.format("Clicked", tag));
							mTagClick.clickedTag(tag);
						}

						@Override
						public void updateDrawState(TextPaint ds) {
							
							// color for the hash tag
							ds.setColor(Color.parseColor(mhastTagColor));
							
							if (mHypeLinkEnabled == 0) {
								ds.setUnderlineText(false);// Disable the
															// underline for
															// hash Tags.
							} else {
								ds.setUnderlineText(true);// Enables the
															// underline for
															// hash Tags.

							}
						}
					}, start, i, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
					start = -1;
				}
			}
		}

		return string;
	}

}
