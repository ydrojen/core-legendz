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

public class UseCaseError {
  public static final int CONECTION_ERROR = 1;
  public static final int INJECTION_ERROR = 2;

  String message;
  int errorType;

  public String getMessage() {
    return message;
  }

  public UseCaseError setMessage(String message) {
    this.message = message;
    return this;
  }

  public int getErrorType() {
    return errorType;
  }

  public UseCaseError setErrorType(int errorType) {
    this.errorType = errorType;
    return this;
  }

  public boolean connectionError(){
    return errorType == CONECTION_ERROR;
  }
}
