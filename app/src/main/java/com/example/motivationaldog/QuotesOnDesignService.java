package com.example.motivationaldog;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface QuotesOnDesignService {
    @GET("wp-json/wp/v2/posts/")
    Call<QuotesOnDesignResults[]> findQuote(
            @Query("orderby") String orderby);
}
