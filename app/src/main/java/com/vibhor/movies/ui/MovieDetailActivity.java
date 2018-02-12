package com.vibhor.movies.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.vibhor.movies.R;
import com.vibhor.movies.model.Movie;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by vbharadwaj on 2/11/18.
 */

public class MovieDetailActivity extends AppCompatActivity {

    public static final String EXTRAS_MOVIE = "extras_movie";
    private Movie movie;

    @BindView(R.id.ivPoster)
    ImageView poster;

    @BindView(R.id.tvRating)
    TextView ratings;

    @BindView(R.id.tvDesc)
    TextView description;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        ButterKnife.bind(this);
        final Intent extras = getIntent();
        movie = Parcels.unwrap(extras.getParcelableExtra(EXTRAS_MOVIE));
        setTitle(movie.getTitle());
        setupUI();
    }

    private void setupUI() {
        Glide.with(this).load(getPosterImage(movie.getBackdropPath())).fitCenter().into(poster);
        ratings.setText(getString(R.string.ratings, movie.getReleaseDate()));
        description.setText(movie.getOverview());
    }

    private String getPosterImage(String posterPath) {
        return "https://image.tmdb.org/t/p/w500/" + posterPath;
    }
}
