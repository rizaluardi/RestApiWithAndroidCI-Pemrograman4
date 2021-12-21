package com.yola.uasyola.rest;

import com.yola.uasyola.model.GetRuangan;
import com.yola.uasyola.model.PostPutDelRuangan;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.DELETE;

public interface ApiInterfaceRuangan {
    @GET("ruangan_android")
    Call<GetRuangan> getRuangan();

    @FormUrlEncoded
    @POST("ruangan")
    Call<PostPutDelRuangan> postRuangan(@Field("ruangan") String ruangan,
                                        @Field("nomor") String nomor);

    @FormUrlEncoded
    @PUT("ruangan")
    Call<PostPutDelRuangan> putRuangan(@Field("id_ruangan") String id_ruangan,
                                       @Field("ruangan") String ruangan,
                                       @Field("nomor") String nomor);

    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "ruangan", hasBody = true)
    @DELETE("ruangan")
    Call<PostPutDelRuangan> deleteRuangan(@Field("id_ruangan") String id_ruangan);
}