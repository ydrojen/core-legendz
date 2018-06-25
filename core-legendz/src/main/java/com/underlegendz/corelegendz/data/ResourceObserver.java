/*
 * Created by Jose Fuentes on 25/06/18 23:26
 * Copyright (C) 2018
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

package com.underlegendz.corelegendz.data;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.underlegendz.corelegendz.mvp.BaseContract;

public abstract class ResourceObserver<T> implements Observer<Resource<T>> {

  BaseContract.LoadingView mView;

  public ResourceObserver() {
  }

  public ResourceObserver(BaseContract.LoadingView view) {
    mView = view;
  }

  public void setView(BaseContract.LoadingView view) {
    mView = view;
  }

  @Override
  public void onChanged(@Nullable Resource<T> resource) {
    if(resource != null){
      switch (resource.status) {
        case SUCCESS:
          if(mView != null){
            mView.setLoading(false);
          }
          onSuccess(resource.data);
          break;
        case ERROR:
          if(mView != null){
            mView.setLoading(false);
            mView.showErrorMessage(resource.message);
          }
          break;
        case LOADING:
          if(mView != null){
            mView.setLoading(true);
          }
          break;
      }
    }
  }

  public abstract void onSuccess(T data);
}
