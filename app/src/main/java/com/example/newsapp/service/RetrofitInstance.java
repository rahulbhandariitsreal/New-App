package com.example.newsapp.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {


    private static Retrofit retrofit=null;

private static final String BASE_URL="https://newsapi.org/v2/";

    public static Newsservice getNewsservice(){

        if(retrofit==null){
            retrofit=new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build();
        }
return retrofit.create(Newsservice.class);
    }

}
