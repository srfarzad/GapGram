package com.gapgram.customView;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class PersianTextView extends AppCompatTextView {
    public PersianTextView(Context context) {
        super(context);
        setFont(context);
    }

    public PersianTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont(context);
    }

    public PersianTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFont(context);
    }

    public void setFont(Context context){

        Typeface typeface=Typeface.createFromAsset(context.getAssets(),"fonts/iranian-sans-light.ttf");

        setTypeface(typeface);

    }
}
