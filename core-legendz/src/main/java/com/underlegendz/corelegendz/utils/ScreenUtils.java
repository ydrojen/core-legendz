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
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import com.underlegendz.corelegendz.CoreApplication;
import java.lang.reflect.InvocationTargetException;

public class ScreenUtils {

  private ScreenUtils() {
  }

  public static int dpToPx(int dp) {
    Resources r = CoreApplication.get().getResources();
    return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics());
  }

  public static float width() {
    DisplayMetrics displayMetrics = CoreApplication.get().getResources().getDisplayMetrics();
    return displayMetrics.widthPixels;
  }

  public static float height() {
    DisplayMetrics displayMetrics = CoreApplication.get().getResources().getDisplayMetrics();
    float height = displayMetrics.heightPixels;
    height = height - getNavigationBarSize(CoreApplication.get()).y;
    return height;
  }

  public static Point getNavigationBarSize(Context context) {
    Point appUsableSize = getAppUsableScreenSize(context);
    Point realScreenSize = getRealScreenSize(context);

    // navigation bar on the right
    if (appUsableSize.x < realScreenSize.x) {
      return new Point(realScreenSize.x - appUsableSize.x, 0);
    }

    // navigation bar at the bottom
    if (appUsableSize.y < realScreenSize.y) {
      return new Point(0, realScreenSize.y - appUsableSize.y);
    }

    // navigation bar is not present
    return new Point();
  }

  public static Point getAppUsableScreenSize(Context context) {
    WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
    Display display = windowManager.getDefaultDisplay();
    Point size = new Point();
    display.getSize(size);
    return size;
  }

  public static Point getRealScreenSize(Context context) {
    WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
    Display display = windowManager.getDefaultDisplay();
    Point size = new Point();

    if (Build.VERSION.SDK_INT >= 17) {
      display.getRealSize(size);
    } else if (Build.VERSION.SDK_INT >= 14) {
      try {
        size.x = (Integer) Display.class.getMethod("getRawWidth").invoke(display);
        size.y = (Integer) Display.class.getMethod("getRawHeight").invoke(display);
      } catch (IllegalAccessException e) {} catch (InvocationTargetException e) {} catch (NoSuchMethodException e) {}
    }

    return size;
  }
}
