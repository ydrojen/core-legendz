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

package com.underlegendz.corelegendz.usecase;
/**
 * Use cases are the entry points to the domain layer.
 *
 * @param <Q> the request type
 * @param <R> the response type
 */
public abstract class UseCase<Q extends UseCase.RequestValues, R extends UseCase.ResponseValue> {

  public abstract void executeUseCase(Q requestValues, UseCaseCallback<R> callback);

  /**
   * Data passed to a request.
   */
  public interface RequestValues {
  }

  /**
   * Data received from a request.
   */
  public interface ResponseValue {
  }

  public interface UseCaseCallback<R> {
    void onSuccess(R response);

    void onError(UseCaseError useCaseError);
  }
}
