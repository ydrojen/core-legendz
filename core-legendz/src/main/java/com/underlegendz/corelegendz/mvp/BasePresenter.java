package com.underlegendz.corelegendz.mvp;
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

import android.support.annotation.CallSuper;

public abstract class BasePresenter<V extends BaseContract.View> implements BaseContract.Presenter<V> {

  private boolean active;
  protected V view;

  @Override
  public final void bindView(V view) {
    if(this.view != view){
      this.view = view;
      onBindView();
    }
  }

  @Override
  public void unbindView(V view) {
    if(this.view != null && this.view.equals(view)){
      this.view = null;
    }
  }

  protected abstract void onBindView();

  @Override
  @CallSuper
  public void onResume() {
    active = true;
  }

  @Override
  @CallSuper
  public void onPause() {
    active = false;
  }

  protected boolean isActive() {
    return active && view != null;
  }
}
