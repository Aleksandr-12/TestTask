package com.test.testtask.server;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitApi {
    @GET("/{IMEI}/form/users/")
    Call<List<ListUsers>> getListUsers(@Path("IMEI") int IMEI);

    @GET("/{IMEI}/authentication/")
    Call<List<Reponse>> getReponse(@Path("IMEI") int IMEI,
                             @Query("pass") String pass,
                             @Query("uid") String uid,
                             @Query("copyFromDevice") Boolean copyFromDevice,
                             @Query("nfc") String nfc);
}
