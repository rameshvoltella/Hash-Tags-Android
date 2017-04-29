Hash-Tags-Android
=================

This is a sample of handling hash tags that contain in a text,the tags are clickable and user can do specifc actions for the corresponding hash tags.In this example we can change color and also can give underline to hash tags  according to the usecase.

Hash-Tags: how to use
------------------------


1. Set Hash Tag Handler
  
    ```java
       TagSelectingTextview mTagSelectingTextview=new TagSelectingTextview();
```


2. Set Hash Tag Handler
 
  ```java

      mHashTagTextView = (TextView) findViewById(R.id.hashtag_textview);
     mHashTagTextView.setMovementMethod(LinkMovementMethod.getInstance());
     	mHashTagTextView.setText(mTagSelectingTextview.addClickablePart(
     testText, this, mHyperlinkStatus, hashTagColor),
     BufferType.SPANNABLE)

```


3. For setting data form html content
 
  ```java

      mHashTagTextView.setText(mTagSelectingTextview.addClickablePart(
                        Html.fromHtml(testText).toString(), this, mhyperlickStatus, hashtagColor),
				BufferType.SPANNABLE);

```				



## VIDEO ([SAMPLE](https://www.youtube.com/watch?v=Bp7aiqxKhv0&feature=youtu.be)) 






## License

    The MIT License (MIT)

    Copyright (c) 2014 Ramesh M Nair
 
     Permission is hereby granted, free of charge, to any person obtaining a copy
     of this software and associated documentation files (the "Software"), to deal
     in the Software without restriction, including without limitation the rights
     to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
     copies of the Software, and to permit persons to whom the Software is
     furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

     THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.




