package com.gapgram.utils;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.gapgram.R;

public class KeyboardActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);

        final EditText editText = (EditText) findViewById(R.id.commentText);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    Toast.makeText(getApplicationContext(), "Searching for " + editText.getText(), Toast.LENGTH_SHORT).show();
                    handled = true;
                }
                return handled;
            }
        });
    }
}
