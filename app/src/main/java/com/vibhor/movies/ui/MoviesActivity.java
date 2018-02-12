package com.vibhor.movies.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.vibhor.movies.R;
import com.vibhor.movies.model.Movie;
import com.vibhor.movies.service.MoviesService;
import com.vibhor.movies.shared.ApiUtil;
import com.vibhor.movies.shared.MoviesContract;
import com.vibhor.movies.shared.MoviesPresenter;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

public class MoviesActivity extends AppCompatActivity implements MoviesContract.View {

    private MoviesService moviesService;
    private RecyclerView recyclerView;
    private MoviesAdapter moviesAdapter;
    private MoviesContract.Presenter presenter;
    private List<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        moviesService = ApiUtil.getMoviesApi();
        setupUI();
        initPresenter();
        loadMovies();
    }

    private void setupUI() {
        recyclerView = (RecyclerView) findViewById(R.id.movies_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        moviesAdapter = new MoviesAdapter(this, new ArrayList<Movie>());
        recyclerView.setAdapter(moviesAdapter);

        moviesAdapter.setOnItemClickListener(new MoviesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                final Movie movie = movies.get(position);

                Context context = MoviesActivity.this;
                Intent it = new Intent(context, MovieDetailActivity.class);
                it.putExtra(MovieDetailActivity.EXTRAS_MOVIE, Parcels.wrap(movie));
                context.startActivity(it);
            }
        });
    }

    private void initPresenter() {
        presenter = new MoviesPresenter(moviesService, this);
    }

    private void loadMovies() {
        presenter.getMovies();
    }

    @Override
    public void setMoviesToView(List<Movie> movies) {
        this.movies = movies;
        moviesAdapter.updateArticles(this.movies);
    }

    @Override
    public void onFailure() {

    }
}
