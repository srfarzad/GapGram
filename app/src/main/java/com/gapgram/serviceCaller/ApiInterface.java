package com.gapgram.serviceCaller;

import com.gapgram.model.Posts;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("GetPostCount")
    Call<ResponseBody> getPostCount();

    @GET("GetAllPost")
    Call<List<Posts>> getPosts();








}
