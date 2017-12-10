package com.underlegendz.corelegendz.utils;
/*
  Copyright (C) 2017 Jose Fuentes

  Licensed under the Apache License, Version 2.0 (the "License"),
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
 */

import android.graphics.Color;

public class ColorUtils {

  public static boolean isColorDark(int color) {
    double darkness = 1
        - (0.299 * Color.red(color) + 0.587 * Color.green(color) + 0.114 * Color.blue(color)) / 255;
    if (darkness < 0.5) {
      return false; // It's a light color
    } else {
      return true; // It's a dark color
    }
  }
}