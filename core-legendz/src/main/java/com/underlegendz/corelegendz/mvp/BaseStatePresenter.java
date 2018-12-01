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

package com.underlegendz.corelegendz.mvp;

import androidx.annotation.NonNull;

public abstract class BaseStatePresenter<V extends BaseContract.View, S extends BaseContract.State>
    extends BasePresenter<V> implements BaseContract.StatePresenter<V, S> {

  protected S state;

  @NonNull
  @Override
  public S getState() {
    if(state == null){
      state = createDefaultState();
    }
    return state;
  }

  protected abstract S createDefaultState();
}
