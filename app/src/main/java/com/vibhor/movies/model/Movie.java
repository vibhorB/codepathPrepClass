package com.vibhor.movies.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.List;

/**
 * Created by vbharadwaj on 2/11/18.
 */

@Parcel
public class Movie {

    @SerializedName("vote_count")
    @Expose
    int voteCount;

    @SerializedName("id")
    @Expose
    int id;

    @SerializedName("video")
    @Expose
    boolean video;

    @SerializedName("vote_average")
    @Expose
    double voteAverage;

    @SerializedName("title")
    @Expose
    String title;

    @SerializedName("popularity")
    @Expose
    double popularity;

    @SerializedName("poster_path")
    @Expose
    String posterPath;

    @SerializedName("original_language")
    @Expose
    String originalLanguage;

    @SerializedName("original_title")
    @Expose
    String originalTitle;

    @SerializedName("genre_ids")
    @Expose
    List<Integer> genreIds;

    @SerializedName("backdrop_path")
    @Expose
    String backdropPath;

    @SerializedName("adult")
    @Expose
    boolean adult;

    @SerializedName("overview")
    @Expose
    String overview;

    @SerializedName("release_date")
    @Expose
    String releaseDate;

    public Movie() {}

    public Movie(int voteCount, int id, boolean video, double voteAverage, String title, double popularity, String posterPath, String originalLanguage, String originalTitle, List<Integer> genreIds, String backdropPath, boolean adult, String overview, String releaseDate) {
        this.voteCount = voteCount;
        this.id = id;
        this.video = video;
        this.voteAverage = voteAverage;
        this.title = title;
        this.popularity = popularity;
        this.posterPath = posterPath;
        this.originalLanguage = originalLanguage;
        this.originalTitle = originalTitle;
        this.genreIds = genreIds;
        this.backdropPath = backdropPath;
        this.adult = adult;
        this.overview = overview;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public String getOverview() {
        return overview;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public double getPopularity() {
        return popularity;
    }

    public String getReleaseDate() {
        return releaseDate;
    }
}
