/*
 * Created by Jose Fuentes on 25/06/18 23:21
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

package com.underlegendz.corelegendz.vm;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.underlegendz.corelegendz.mvp.BaseContract;
import java.lang.reflect.Field;

import static android.content.ContentValues.TAG;

public abstract class VMFragment extends Fragment implements BaseContract.DialogView,
    BaseContract.LoadingView {


  @LayoutRes
  protected abstract int getLayoutResource();

  protected abstract void initializeView();

  protected <T extends ViewModel> T getViewModel(Class<T> cls){
    return ViewModelProviders.of(getActivity()).get(cls); // ViewModel scoped to the activity
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.setHasOptionsMenu(true);
    this.setRetainInstance(true);
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return inflater.inflate(getLayoutResource(), container, false);
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    initializeView();
  }

  // Arbitrary value; set it to some reasonable default
  private static final int DEFAULT_CHILD_ANIMATION_DURATION = 400;

  @Override
  public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
    final Fragment parent = getParentFragment();

    // Apply the workaround only if this is a child fragment, and the parent
    // is being removed.
    if (!enter && parent != null && parent.isRemoving()) {
      // This is a workaround for the bug where child fragments disappear when
      // the parent is removed (as all children are first removed from the parent)
      // See https://code.google.com/p/android/issues/detail?id=55228
      Animation doNothingAnim = new AlphaAnimation(1, 1);
      doNothingAnim.setDuration(getNextAnimationDuration(parent, DEFAULT_CHILD_ANIMATION_DURATION));
      return doNothingAnim;
    } else {
      return super.onCreateAnimation(transit, enter, nextAnim);
    }
  }

  private static long getNextAnimationDuration(Fragment fragment, long defValue) {
    try {
      // Attempt to get the resource ID of the next animation that
      // will be applied to the given fragment.
      Field nextAnimField = Fragment.class.getDeclaredField("mNextAnim");
      nextAnimField.setAccessible(true);
      int nextAnimResource = nextAnimField.getInt(fragment);
      Animation nextAnim = AnimationUtils.loadAnimation(fragment.getActivity(), nextAnimResource);

      // ...and if it can be loaded, return that animation's duration
      return (nextAnim == null) ? defValue : nextAnim.getDuration();
    } catch (NoSuchFieldException | IllegalAccessException | Resources.NotFoundException ex) {
      Log.w(TAG, "Unable to load next animation from parent.", ex);
      return defValue;
    }
  }

  // DIALOG VIEW

  @Override
  public void showDialog(@StringRes int title, @StringRes int text, @StringRes int ok,
      @StringRes int cancel, View.OnClickListener okAction, View.OnClickListener cancelAction) {
    if (getActivity() instanceof BaseContract.DialogView) {
      ((BaseContract.DialogView) getActivity()).showDialog(title, text, ok, cancel, okAction,
          cancelAction);
    }
  }

  @Override
  public void showDialog(String title, String text, String ok, String cancel,
      View.OnClickListener okAction, View.OnClickListener cancelAction) {
    if (getActivity() instanceof BaseContract.DialogView) {
      ((BaseContract.DialogView) getActivity()).showDialog(title, text, ok, cancel, okAction,
          cancelAction);
    }
  }

  @Override
  public void hideDialog() {
    if (getActivity() instanceof BaseContract.DialogView) {
      ((BaseContract.DialogView) getActivity()).hideDialog();
    }
  }

  // LOADING VIEW

  @Override
  public void setLoading(boolean loading) {
    if(getActivity() != null
        && getActivity() instanceof BaseContract.LoadingView){

      ((BaseContract.LoadingView) getActivity()).setLoading(loading);
    }
  }

  @Override
  public void setLoadingText(String text) {
    if(getActivity() != null
        && getActivity() instanceof BaseContract.LoadingView){

      ((BaseContract.LoadingView) getActivity()).setLoadingText(text);
    }
  }

  @Override
  public void setLoadingText(@StringRes int textResource) {
    if(getActivity() != null
        && getActivity() instanceof BaseContract.LoadingView){

      ((BaseContract.LoadingView) getActivity()).setLoadingText(textResource);
    }
  }

  @Override
  public void showErrorMessage(String text) {
    if(getActivity() != null
        && getActivity() instanceof BaseContract.LoadingView){

      ((BaseContract.LoadingView) getActivity()).showErrorMessage(text);
    }
  }

  @Override
  public void showErrorMessage(@StringRes int textResource) {
    if(getActivity() != null
        && getActivity() instanceof BaseContract.LoadingView){

      ((BaseContract.LoadingView) getActivity()).showErrorMessage(textResource);
    }
  }

}
