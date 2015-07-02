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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagSelectingTextview {

	String mhastTagColor;
	TagClick mTagClick;
	int mHypeLinkEnabled;

	public SpannableStringBuilder addClickablePart(String nTagString,
			TagClick TagClick, int hypeLinkEnabled, String hastTagColor) {

		this.mhastTagColor = hastTagColor;

		this.mHypeLinkEnabled = hypeLinkEnabled;

		this.mTagClick = TagClick;

        // Pattern for getting the hash tags from a string


        Pattern hashTagsPattern = Pattern.compile("(#[a-zA-Z0-9_-]+)");

		SpannableStringBuilder string = new SpannableStringBuilder(nTagString);

        CharSequence spanText;
        int start;
        int end;

        // Matching the pattern with the existing string

        Matcher m = hashTagsPattern.matcher(nTagString);

        while (m.find()) {

            start = m.start();
             end = m.end();

            spanText = nTagString.subSequence(start, end);


            final CharSequence mLastTextSpan = spanText;
            
            string.setSpan(new ClickableSpan() {

                @Override
                public void onClick(View widget) {

                    // Click on each tag will get here

                    Log.d("TAg--HAsh", String.format("Clicked", mLastTextSpan));
                    mTagClick.clickedTag(mLastTextSpan);
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
            }, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);


        }



		return string;
	}

}
