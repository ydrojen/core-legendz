package com.underlegendz.corelegendz.usecase;
/*
  Copyright (C) 2016 Jose Fuentes

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


import com.underlegendz.corelegendz.utils.LooperUtils;

public abstract class UseCaseUiCallback<R> implements UseCase.UseCaseCallback<R> {

  @Override
  public void onSuccess(final R response) {
    LooperUtils.runOnUi(new Runnable() {
      @Override
      public void run() {
        onUiSuccess(response);
      }
    });
  }

  protected abstract void onUiSuccess(R response);

  protected abstract void onUiError(UseCaseError useCaseError);

  @Override
  public void onError(final UseCaseError useCaseError) {
    LooperUtils.runOnUi(new Runnable() {
      @Override
      public void run() {
        onUiError(useCaseError);
      }
    });

  }
}