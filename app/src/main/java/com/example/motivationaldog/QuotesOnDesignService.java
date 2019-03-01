package com.example.motivationaldog;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface QuotesOnDesignService {
    @GET("wp-json/posts")
    Call<List<QuotesOnDesignResults>> findQuote(
            @Query("filter[orderby]") String order,
            @Query("filter[posts_per_page]") int posts);
}
