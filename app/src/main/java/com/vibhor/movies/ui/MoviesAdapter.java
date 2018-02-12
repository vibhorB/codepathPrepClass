package com.vibhor.movies.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.vibhor.movies.R;
import com.vibhor.movies.model.Movie;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by vbharadwaj on 2/11/18.
 */

public class MoviesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Movie> movies;
    private Context context;
    private OnItemClickListener listener;

    public MoviesAdapter(Context context, List<Movie> movies) {
        this.movies = movies;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(context);
        viewHolder = new MoviesAdapter.ViewHolder(inflater.inflate(R.layout.item_movie_portrait, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder vh = (MoviesAdapter.ViewHolder) holder;
        configureViewHolderImage(vh, position);
    }

    private void configureViewHolderImage(ViewHolder vh, int position) {
        Movie movie = movies.get(position);
        if(movie != null) {
            vh.tvTitle.setText(movie.getTitle());
            vh.tvOverview.setText(movie.getOverview());
            Glide.with(context).load(getPosterImage(movie)).fitCenter().into(vh.ivImage);
        }
    }

    private String getPosterImage(final Movie movie) {
        final String baseImage = "https://image.tmdb.org/t/p/";
        if(context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            return baseImage + "/w200" + movie.getPosterPath();
        }
        else {
            return baseImage + "/w500" + movie.getBackdropPath();
        }
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ivImage) ImageView ivImage;
        @BindView(R.id.tvTitle) TextView tvTitle;
        @BindView(R.id.tvOverview) TextView tvOverview;

        public ViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(itemView, position);
                        }
                    }
                }
            });
        }
    }

    public void updateArticles(List<Movie> items) {
        movies = items;
        notifyDataSetChanged();
    }
}
