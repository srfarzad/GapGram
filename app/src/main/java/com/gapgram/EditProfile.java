package com.gapgram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EditProfile extends AppCompatActivity {

    private Intent intent;

    @BindView(R.id.btn_close)
    ImageView btn_close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        ButterKnife.bind(this);

        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent = new Intent(EditProfile.this,ProfileActivity.class);
                startActivity(intent);
            }
        });
    }
}
