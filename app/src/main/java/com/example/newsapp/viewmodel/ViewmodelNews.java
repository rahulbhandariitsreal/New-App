package com.example.newsapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.newsapp.model.News;
import com.example.newsapp.model.RepositoryNews;

import java.util.ArrayList;
import java.util.List;

public class ViewmodelNews extends AndroidViewModel {



    private RepositoryNews repository;

    public ViewmodelNews(@NonNull Application application) {
        super(application);
        repository=new RepositoryNews(application);
    }

    public LiveData<List<News>> getListLiveDatanews(String cat){

        return  repository.getMutableLiveDatanews(cat);
    }
}
