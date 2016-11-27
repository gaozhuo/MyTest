package com.example.retrofittest;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by gaozhuo on 2016/8/31.
 */
public interface ApiService {
    @GET("users/{user}")
    Call<ResponseBody> getUser(@Path("user") String user);

    @GET("users/{user}")
    Call<User> getUser2(@Path("user") String user);

    @GET("users/{user}")
    Observable<User> getUser3(@Path("user") String user);
}
