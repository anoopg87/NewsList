package com.assesment.interfaces;
import com.assesment.model.Facts;

import retrofit2.Call;
import retrofit2.http.GET;



public interface NewsServiceAPI {

    @GET("/s/2iodh4vg0eortkl/facts.json")
    Call<Facts> getFacts();
}
