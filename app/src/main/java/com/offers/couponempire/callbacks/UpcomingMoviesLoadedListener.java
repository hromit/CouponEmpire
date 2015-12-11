package com.offers.couponempire.callbacks;

import java.util.ArrayList;

import com.offers.couponempire.pojo.Movie;

/**
 * Created by Windows on 13-04-2015.
 */
public interface UpcomingMoviesLoadedListener {
    public void onUpcomingMoviesLoaded(ArrayList<Movie> listMovies);
}
