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

import android.support.annotation.Nullable;
import com.birbit.android.jobqueue.Job;
import com.birbit.android.jobqueue.Params;
import com.birbit.android.jobqueue.RetryConstraint;

/**
 * Job extension created to be able to execute a use case using android-priority-job-queue.
 */
class UseCaseWrapperJob<Q extends UseCase.RequestValues, R extends UseCase.ResponseValue> extends
    Job {
  private static final int PRIORITY_NORMAL = 3;
  private final UseCase<Q, R> useCase;
  private final Q requestValues;
  private final UseCase.UseCaseCallback<R> callback;

  public UseCaseWrapperJob(UseCase<Q,R> useCase, Q requestValues, UseCase.UseCaseCallback<R> callback) {
    super(new Params(PRIORITY_NORMAL));
    this.useCase = useCase;
    this.requestValues = requestValues;
    this.callback = callback;
  }

  @Override
  public void onAdded() {

  }

  @Override
  public void onRun() throws Throwable {
    useCase.executeUseCase(requestValues, callback);
  }

  @Override
  protected void onCancel(int cancelReason, @Nullable Throwable throwable) {

  }

  @Override
  protected RetryConstraint shouldReRunOnThrowable(Throwable throwable, int runCount, int maxRunCount) {
    return RetryConstraint.CANCEL;
  }
}