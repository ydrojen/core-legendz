package com.underlegendz.corelegendz;
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

import android.app.Application;

public class CoreApplication extends Application {
  private static CoreApplication sApplication;

  @Override
  public void onCreate() {
    super.onCreate();

    setApplication(this);
  }

  private static void setApplication(CoreApplication app){
    sApplication = app;
  }

  public static Application get(){
    return sApplication;
  }
}
