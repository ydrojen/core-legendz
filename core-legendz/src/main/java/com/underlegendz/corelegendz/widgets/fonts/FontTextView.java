package com.underlegendz.corelegendz.widgets.fonts;
/*
 * Copyright (C) 2016 Jose Fuentes
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import com.underlegendz.corelegendz.R;
import com.underlegendz.corelegendz.utils.FontManager;

@Deprecated
public class FontTextView extends AppCompatTextView {
  public FontTextView(Context context) {
    this(context, null);
  }

  public FontTextView(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public FontTextView(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);

    if (isInEditMode())
      return;

    TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.FontName);

    if (ta != null) {
      String fontAsset = ta.getString(R.styleable.FontName_fontName);

      if (!TextUtils.isEmpty(fontAsset)) {
        Typeface tf = FontManager.getInstance(context).getFont(fontAsset);

        if (tf != null) {
          setTypeface(tf);
        } else {
          Log.d("FontText", String.format("Could not create a font from asset: %s", fontAsset));
        }
      }
      ta.recycle();
    }
  }
}
