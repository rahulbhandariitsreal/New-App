package com.example.newsapp.service;

import com.example.newsapp.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Newsservice {

    //url base url
    //https://api.themoviedb.org/3/
    //api request
    //https://api.themoviedb.org/3/movie/popular?api_key=4f850891919eee94d6015385e2464b3d
    //movie/popular->get part
    //base url-> https://newsapi.org/v2/
    // back end point ->  top-headlines?
    //query-> ("sources=techcrunch&apiKey")=
    // api key-> e4f350a68227443aaf9734efa9ca8c94
    //back end point url
    //https://newsapi.org/v2/top-headlines?sources=techcrunch&api_key=4f850891919eee94d6015385e2464b3d
    //movie/popular?api_key=4f850891919eee94d6015385e2464b3d
//=techcrunch&apikey
  //  @GET("movie/popular")
//    Call<Result> getPopularmovies(@Query("api_key")String apiKey);

    @GET("top-headlines")
    Call<Result> getResult(@Query("category") String country,@Query("apiKey") String apiKey);

}
