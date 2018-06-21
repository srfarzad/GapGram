package com.gapgram.serviceCaller;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final String BASE_URL = "http://mymvc.ir/api/ApiPostTablesApi/";
    public static final String ImagePath = "http://mymvc.ir";

    private static Retrofit retrofit = null;


    public static Retrofit getRetrofit() {

        if (retrofit == null) {

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;

    }

}
