package com.gapgram.serviceCaller;

import com.gapgram.model.GetUserAllPost;
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

    @GET("GetUserAllPosts?userID=dd2eccb2-6da8-48f1-b107-cd8558c89b5c")
    Call<List<GetUserAllPost>> getUserAllPosts();


}
