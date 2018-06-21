package com.gapgram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;

import com.gapgram.realm.UserProfile;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmQuery;

public class EditProfile extends AppCompatActivity {

    private Intent intent;

    @BindView(R.id.btn_close)
    ImageView btn_close;

    @BindView(R.id.edt_name)AppCompatEditText edt_name;
    @BindView(R.id.edt_userName)AppCompatEditText edt_userName;
    @BindView(R.id.edt_website)AppCompatEditText edt_website;
    @BindView(R.id.edt_bio)AppCompatEditText edt_bio;
    @BindView(R.id.edt_email)AppCompatEditText edt_email;
    @BindView(R.id.edt_phoneNumber)AppCompatEditText edt_phoneNumber;
    @BindView(R.id.spi_gender)Spinner spi_gender;

    @BindView(R.id.icon_option)AppCompatImageView icon_option;

    String gender="";


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


        icon_option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Realm realm=Realm.getDefaultInstance();
                realm.beginTransaction();
                UserProfile userProfile = realm.createObject(UserProfile.class); // Create a new object
                //UserProfile userProfile=new UserProfile();

                userProfile.setName(edt_name.getText().toString());
                userProfile.setUserName(edt_userName.getText().toString());
                userProfile.setWebsite(edt_website.getText().toString());
                userProfile.setBio(edt_bio.getText().toString());
                userProfile.setEmail(edt_email.getText().toString());
                userProfile.setPhoneNumber(edt_phoneNumber.getText().toString());
                userProfile.setGender(gender);



              //  realm.copyFromRealm(UserProfile.class);
                realm.insert(userProfile);
                realm.commitTransaction();


                RealmQuery<UserProfile> query = realm.where(UserProfile.class);

                Log.e("",query.toString());

            }
        });

        spi_gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {


                if(position==1){
                    gender="Male";
                }
                else if(position==2) {
                    gender="FeMale";
                }
                else {
                    gender="Not Specified";
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
}
