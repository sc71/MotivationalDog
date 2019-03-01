package com.example.motivationaldog;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ShibeService {
    @GET("api/shibes")
    Call<String> findDog(
            @Query("count") int numResults);
}
