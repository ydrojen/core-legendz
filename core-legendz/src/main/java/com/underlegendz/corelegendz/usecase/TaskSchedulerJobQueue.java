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

import com.birbit.android.jobqueue.JobManager;

public class TaskSchedulerJobQueue implements UseCaseScheduler {
  private final JobManager jobManager;

  public TaskSchedulerJobQueue(JobManager jobManager) {
    this.jobManager = jobManager;
    this.jobManager.start();
  }

  @Override
  public <Q extends UseCase.RequestValues, R extends UseCase.ResponseValue> void execute(
      UseCase<Q, R> useCase, Q requestValues, UseCase.UseCaseCallback<R> callback) {
    jobManager.addJobInBackground(new UseCaseWrapperJob<Q, R>(useCase, requestValues, callback));
  }
}
