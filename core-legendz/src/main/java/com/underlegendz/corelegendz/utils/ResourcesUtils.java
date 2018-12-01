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

import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.IntegerRes;
import androidx.annotation.RawRes;
import androidx.annotation.StringRes;
import com.underlegendz.corelegendz.CoreApplication;
import java.io.InputStream;

public class ResourcesUtils {
  public static String getString(@StringRes int stringResource){
    return CoreApplication.get().getString(stringResource);
  }

  public static String getString(@StringRes int stringResource, Object... formatArgs){
    return CoreApplication.get().getString(stringResource, formatArgs);
  }

  public static int getColor(@ColorRes int colorResource){
    return CoreApplication.get().getResources().getColor(colorResource);
  }

  public static float getDimen(@DimenRes int dimenResource){
    return CoreApplication.get().getResources().getDimension(dimenResource);
  }

  public static int getInteger(@IntegerRes int integerResource){
    return CoreApplication.get().getResources().getInteger(integerResource);
  }

  public static InputStream openRaw(@RawRes int rawResource){
    return CoreApplication.get().getResources().openRawResource(rawResource);
  }
}
