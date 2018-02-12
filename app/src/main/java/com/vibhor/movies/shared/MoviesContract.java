package com.vibhor.movies.shared;


import com.vibhor.movies.model.Movie;

import java.util.List;

/**
 * Created by vbharadwaj on 2/11/18.
 */

public interface MoviesContract {

    interface Presenter {
        void getMovies();
    }

    interface View {
        void setMoviesToView(List<Movie> movies);

        void onFailure();
    }
}
