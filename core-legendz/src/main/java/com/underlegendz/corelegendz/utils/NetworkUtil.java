package com.underlegendz.corelegendz.utils;
/*
  Copyright (C) 2017 Jose Fuentes

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

import android.content.Context;
import com.birbit.android.jobqueue.network.NetworkUtilImpl;
import java.lang.ref.WeakReference;

public class NetworkUtil extends NetworkUtilImpl {
  WeakReference<Context> mContextWR;

  public NetworkUtil(Context context) {
    super(context);
    mContextWR = new WeakReference<>(context);
  }

  public boolean isConnected(){
    if(mContextWR.get() != null){
      return getNetworkStatus(mContextWR.get()) != DISCONNECTED;
    }else{
      throw new IllegalStateException("NetworkUtil: Context cannot be null");
    }
  }
}
