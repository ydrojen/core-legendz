package com.underlegendz.corelegendz.mvp.view;
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

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.underlegendz.corelegendz.mvp.BaseContract;

public abstract class MVPFragment extends Fragment implements BaseContract.LoadingView {

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
    if (getPresenter() != null) {
      if(getPresenter() instanceof BaseContract.StatePresenter){
        BaseContract.State state = ((BaseContract.StatePresenter) getPresenter()).getState();
        if(savedInstanceState != null){
          state.readFromBundle(savedInstanceState);
        }else{
          Bundle bundle = getArguments();
          if(bundle == null){
            bundle = new Bundle();
          }
          state.readFromBundle(bundle);
        }
      }
      getPresenter().bindView(this);
    }
  }

  @Override
  public void onResume() {
    super.onResume();
    if (getPresenter() != null) {
      getPresenter().onResume();
    }
  }

  @Override
  public void onPause() {
    super.onPause();
    if (getPresenter() != null) {
      getPresenter().onPause();
    }
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    if(getPresenter() != null){
      getPresenter().unbindView(this);
    }
  }

  @Override
  public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    if(getPresenter() != null && getPresenter() instanceof BaseContract.StatePresenter){
      ((BaseContract.StatePresenter) getPresenter()).getState().writeToBundle(outState);
    }
  }

  @LayoutRes
  protected abstract int getLayoutResource();

  protected abstract BaseContract.Presenter getPresenter();

  protected abstract void initializeView();

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