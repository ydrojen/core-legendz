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

package com.underlegendz.corelegendz.data;

import android.content.SharedPreferences;
import android.util.Log;
import java.util.TreeMap;

public class SessionData {
  private SharedPreferences mSharedPreferences;
  private static final String TAG = "SessionData";

  private TreeMap<String, Object> session = new TreeMap<>();

  public SessionData(SharedPreferences sharedPreferences) {
    mSharedPreferences = sharedPreferences;
  }

  public <T> T getData(String key, Class<T> clazz) {
    T data = (T) session.get(key);
    if (data == null && mSharedPreferences.contains(key)) {
      try {
        if (clazz.equals(String.class)) {
          data = clazz.cast(mSharedPreferences.getString(key, null));
        } else if (clazz.equals(Boolean.class)) {
          data = clazz.cast(mSharedPreferences.getBoolean(key, false));
        } else if (clazz.equals(Integer.class)) {
          data = clazz.cast(mSharedPreferences.getInt(key, 0));
        } else if (clazz.equals(Long.class)) {
          data = clazz.cast(mSharedPreferences.getLong(key, 0));
        } else if (clazz.equals(Float.class)) {
          data = clazz.cast(mSharedPreferences.getFloat(key, 0));
        }
        setData(key, data);
      } catch (Exception e) {
        Log.e(TAG, "getData error", e);
      }
    }
    return data;
  }

  public void setData(String key, Object data) {
    session.put(key, data);
  }

  public void setDataPersist(String key, Object data) {
    setData(key, data);

    SharedPreferences.Editor editor = mSharedPreferences.edit();
    if (data instanceof String) {
      editor.putString(key, (String) data);
    } else if (data instanceof Boolean) {
      editor.putBoolean(key, (Boolean) data);
    } else if (data instanceof Integer) {
      editor.putInt(key, (Integer) data);
    } else if (data instanceof Long) {
      editor.putLong(key, (Long) data);
    } else if (data instanceof Float) {
      editor.putFloat(key, (Float) data);
    }
    editor.apply();
  }

  public void clearData(String key) {
    session.remove(key);
    SharedPreferences.Editor editor = mSharedPreferences.edit();
    editor.remove(key);
    editor.apply();
  }

  public boolean containsKey(String key){
    return session.containsKey(key) || mSharedPreferences.contains(key);
  }

  public Long getLong(String key) {
    return getData(key, Long.class);
  }

  public Boolean getBoolean(String key) {
    return getData(key, Boolean.class);
  }

  public String getString(String key) {
    return getData(key, String.class);
  }

  public Integer getInteger(String key) {
    return getData(key, Integer.class);
  }
}
