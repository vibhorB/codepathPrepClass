package com.vibhor.movies.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by vbharadwaj on 2/11/18.
 */

public class MoviesResponse {

    @SerializedName("results")
    @Expose
    private List<Movie> results;

    @SerializedName("page")
    @Expose
    private int page;

    @SerializedName("total_results")
    @Expose
    private int totalResults;

    @SerializedName("dates")
    @Expose
    private Dates dates;

    @SerializedName("total_pages")
    @Expose
    private int totalPages;

    public List<Movie> getResults() {
        return results;
    }
}
