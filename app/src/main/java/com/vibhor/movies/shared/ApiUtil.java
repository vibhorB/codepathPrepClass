package com.vibhor.movies.shared;

import com.vibhor.movies.service.MoviesService;
import com.vibhor.movies.service.RetrofitClient;

/**
 * Created by vbharadwaj on 2/11/18.
 */

public class ApiUtil {

    public static final String MOVIES_BASE_URL = "https://api.themoviedb.org/3/movie/";
    public static final String MOVIES_API_KEY = "a07e22bc18f5cb106bfe4cc1f83ad8ed";

    public static MoviesService getMoviesApi() {
        return RetrofitClient.getClient(MOVIES_BASE_URL).create(MoviesService.class);
    }
}
