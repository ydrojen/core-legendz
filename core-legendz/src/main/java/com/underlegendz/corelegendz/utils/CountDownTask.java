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
package com.underlegendz.corelegendz.utils;

import android.os.Handler;
import android.util.Log;

public abstract class CountDownTask {
  private long millisInFuture;
  private long countDownInterval;
  private boolean isCancel = false;

  public CountDownTask(long millisInFuture, long countDownInterval) {
    this.millisInFuture = millisInFuture;
    this.countDownInterval = countDownInterval;
  }

  public void start() {
    final Handler handler = new Handler();
    final Runnable counter = new Runnable() {

      public void run() {
        if (!isCancel) {
          if (millisInFuture <= 0) {
            onFinish();
          } else {
            millisInFuture -= countDownInterval;
            onInterval(millisInFuture);
            handler.postDelayed(this, countDownInterval);
          }
        }
      }
    };

    handler.postDelayed(counter, countDownInterval);
  }

  public void cancel(){
    isCancel = true;
  }

  public void reduceTime(long timeToReduceInMillis) {
    this.millisInFuture -= timeToReduceInMillis;
  }

  protected abstract void onFinish();
  protected abstract void onInterval(long millisLeft);
}
