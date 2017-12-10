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

/**
 * Runs {@link UseCase}s using a {@link UseCaseScheduler}.
 */
public class UseCaseHandler {

  private final UseCaseScheduler mUseCaseScheduler;

  public UseCaseHandler(UseCaseScheduler useCaseScheduler) {
    mUseCaseScheduler = useCaseScheduler;
  }

  public <T extends UseCase.RequestValues, R extends UseCase.ResponseValue> void execute(
      final UseCase<T, R> useCase, T values, UseCase.UseCaseCallback<R> callback) {

    mUseCaseScheduler.execute(useCase, values, callback);
  }

  public <T extends UseCase.RequestValues, R extends UseCase.ResponseValue> void execute(
      final UseCase<T, R> useCase, final T values, final UseCase.UseCaseCallback<R> callback, long delay) {

    LooperUtils.runOnUiDelayed(new Runnable() {
      @Override
      public void run() {
        mUseCaseScheduler.execute(useCase, values, callback);
      }
    }, delay);
  }
}