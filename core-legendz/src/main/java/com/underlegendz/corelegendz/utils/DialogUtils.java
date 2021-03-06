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

package com.underlegendz.corelegendz.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import androidx.annotation.ColorRes;
import androidx.annotation.StringRes;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AlertDialog;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.underlegendz.corelegendz.R;

public class DialogUtils {
  private DialogUtils(){
    // No instance
  }

  public static AlertDialog getDialog(Activity activity, @StringRes Integer messageText,
      @StringRes Integer positiveText, DialogInterface.OnClickListener positiveAction,
      @StringRes Integer negativeText, DialogInterface.OnClickListener negativeAction,
      boolean cancelable){

    AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.DialogTheme);
    builder.setMessage(messageText)
        .setPositiveButton(positiveText,positiveAction)
        .setCancelable(cancelable);

    if(negativeText != null){
      builder.setNegativeButton(negativeText,negativeAction);
    }

    return builder.create();
  }

  public static AlertDialog getAlertDialog(Activity activity, @StringRes Integer messageText,
      @StringRes Integer buttonText, DialogInterface.OnClickListener buttonAction){
    return getDialog(activity, messageText, buttonText, buttonAction, null, null, false);
  }

  public static Snackbar createErrorSnackbar(View v){
    return createSnackbar(v, R.color.red, R.color.white, R.color.white);
  }

  public static Snackbar createSnackbar(View v, @ColorRes int backgroundColorResource,
      @ColorRes int textColorResource, @ColorRes int actionTextColorResource) {

    Snackbar snackbar = Snackbar.make(v, "", Snackbar.LENGTH_LONG);
    snackbar.setActionTextColor(v.getResources().getColor(actionTextColorResource));

    View snackbarView = snackbar.getView();
    int snackbarTextId = com.google.android.material.R.id.snackbar_text;

    TextView textView = snackbarView.findViewById(snackbarTextId);
    textView.setTextColor(v.getResources().getColor(textColorResource));

    snackbarView.setBackgroundColor(v.getResources().getColor(backgroundColorResource));
    return snackbar;
  }

  public static void showToast(Context context, String text){
    Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
  }

}
