package com.gapgram.serviceCaller;

import com.gapgram.model.IListResponse;
import com.gapgram.model.IResponse;
import com.gapgram.model.Posts;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WebserviceCaller {

    ApiInterface apiInterface;

    public WebserviceCaller(){
        apiInterface=ApiClient.getRetrofit().create(ApiInterface.class);
    }


    public void getPostCount(final IResponse iResponse){

        Call<ResponseBody> call=apiInterface.getPostCount();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                try {
                    iResponse.onSuccess(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

                iResponse.onFail();
            }
        });


    }


    public void getPosts(final IListResponse listResponse)throws Exception{

        Call<List<Posts>> call=apiInterface.getPosts();

        call.enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                listResponse.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {
                listResponse.onFail();
            }
        });

    }



}
