package com.vibhor.movies.service;

import com.vibhor.movies.model.MoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by vbharadwaj on 2/11/18.
 */

public interface MoviesService {

    @GET("now_playing")
    Call<MoviesResponse> getMovies(@Query("api_key") String apiKey);
}
