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

import android.os.Handler;
import android.os.Looper;

public class LooperUtils {
  private LooperUtils(){

  }

  public static boolean isUi(){
    return Looper.myLooper() == Looper.getMainLooper();
  }

  public static void runOnUi(Runnable runnable){
    if(isUi()){
      runnable.run();
    }else{
      new Handler(Looper.getMainLooper()).post(runnable);
    }
  }

  public static void runOnUiDelayed(Runnable runnable, long millis){
    new Handler(Looper.getMainLooper()).postDelayed(runnable, millis);
  }

  public static void runInBackground(Runnable runnable){
    new Thread(runnable).start();
  }
}