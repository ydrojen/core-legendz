/*
 * Created by Jose Fuentes on 10/12/17 16:40
 * Copyright (C) 2017
 *
 * Licensed under the Apache License, Version 2.0 (the "License"),
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

package com.underlegendz.corelegendz.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class FontManager {
  private static FontManager instance;

  private AssetManager mgr;

  private Map<String, Typeface> fonts;

  private FontManager(AssetManager _mgr) {
    mgr = _mgr;
    fonts = new HashMap<>();
  }

  public static void init(AssetManager mgr) {
    instance = new FontManager(mgr);
  }

  public static FontManager getInstance(Context context) {
    if(instance == null){
      init(context.getAssets());
    }
    return instance;
  }

  public Typeface getFont(String asset) {
    asset = "fonts/" + asset;
    if (fonts.containsKey(asset)) {
      return fonts.get(asset);
    }

    Typeface font = null;

    try {
      font = Typeface.createFromAsset(mgr, asset);
      fonts.put(asset, font);
    } catch (Exception e) {

    }

    if (font == null) {
      try {
        String fixedAsset = fixAssetFilename(asset);
        font = Typeface.createFromAsset(mgr, fixedAsset);
        fonts.put(asset, font);
        fonts.put(fixedAsset, font);
      } catch (Exception e) {

      }
    }

    return font;
  }

  private String fixAssetFilename(String asset) {
    // Empty font filename?
    // Just return it. We can't help.
    if (TextUtils.isEmpty(asset)) {
      return asset;
    }

    // Make sure that the font ends in '.ttf' or '.ttc'
    if ((!asset.endsWith(".ttf")) && (!asset.endsWith(".ttc"))) {
      asset = String.format("%s.ttf", asset);
    }

    return asset;
  }
}