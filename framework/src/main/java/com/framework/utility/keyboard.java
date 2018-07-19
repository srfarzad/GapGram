package com.framework.utility;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class keyboard {

    public void hideKeyboard(Context activityContext) {

        InputMethodManager imm = (InputMethodManager)
                activityContext.getSystemService(Context.INPUT_METHOD_SERVICE);

        //android.R.id.content ( http://stackoverflow.com/a/12887919/2077479 )
        View rootView = ((Activity) activityContext)
                .findViewById(android.R.id.content).getRootView();

        imm.hideSoftInputFromWindow(rootView.getWindowToken(), 0);
    }

    public void showKeyboard(Context activityContext, final EditText editText) {


        final InputMethodManager imm = (InputMethodManager)
                activityContext.getSystemService(Context.INPUT_METHOD_SERVICE);

        if (!editText.hasFocus()) {
            editText.requestFocus();
        }

        editText.post(new Runnable() {
            @Override
            public void run() {
                imm.showSoftInput(editText, InputMethodManager.SHOW_FORCED);
            }
        });


    }
}
