package com.gapgram.dagger;

import com.gapgram.model.Contact;
import com.gapgram.model.User;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UserModule {


    @Provides
    @Singleton
    Contact provideContact() {
        return new Contact();
    }

    @Provides
    @Singleton
    User provideUser() {
        return new User(new Contact());
    }


}
