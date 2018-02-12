package com.vibhor.movies.shared;

import android.util.Log;

import com.vibhor.movies.model.MoviesResponse;
import com.vibhor.movies.service.MoviesService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by vbharadwaj on 2/11/18.
 */

public class MoviesPresenter implements MoviesContract.Presenter {

    private MoviesService moviesService;
    private MoviesContract.View view;

    public MoviesPresenter(final MoviesService service, final MoviesContract.View view) {
        this.moviesService = service;
        this.view = view;
    }

    @Override
    public void getMovies() {
        moviesService.getMovies(ApiUtil.MOVIES_API_KEY)
                .enqueue(new Callback<MoviesResponse>() {
                    @Override
                    public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                        if(response.isSuccessful()) {
                            view.setMoviesToView(response.body().getResults());
                        }
                    }

                    @Override
                    public void onFailure(Call<MoviesResponse> call, Throwable t) {
                        Log.e("movies","failed :" + t.getLocalizedMessage());
                        view.onFailure();
                    }
                });
    }
}