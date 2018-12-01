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

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import android.view.View;

public interface BaseContract {

  // VIEWS
  interface View {
    Activity getActivity();
  }

  interface DialogView extends View {
    void showDialog(@StringRes int title, @StringRes int text, @StringRes int ok,
        @StringRes int cancel, android.view.View.OnClickListener okAction,
        android.view.View.OnClickListener cancelAction);
    void showDialog(String title, String text, String ok,
        String cancel, android.view.View.OnClickListener okAction,
        android.view.View.OnClickListener cancelAction);
    void hideDialog();
  }

  interface LoadingView extends View {
    void setLoading(boolean loading);
    void setLoadingText(@NonNull String text);
    void setLoadingText(@StringRes int textResource);
    void showErrorMessage(@NonNull String text);
    void showErrorMessage(@StringRes int textResource);
  }

  // PRESENTERS
  interface Presenter<V extends View> {
    void bindView(@NonNull V view);
    void onResume();
    void onPause();
    void unbindView(@NonNull V view);
  }

  interface StatePresenter<V extends View, S extends State> extends Presenter<V> {
    @NonNull
    S getState();
  }

  // STATE
  interface State {
    void writeToBundle(Bundle bundle);
    void readFromBundle(Bundle bundle);
  }
}
