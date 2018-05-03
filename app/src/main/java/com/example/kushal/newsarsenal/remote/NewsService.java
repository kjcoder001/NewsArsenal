package com.example.kushal.newsarsenal.remote;

import com.example.kushal.newsarsenal.models.Article;
import com.example.kushal.newsarsenal.models.Root;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by kushal on 17-04-2018.
 */

public interface NewsService {

    @GET("top-headlines?country=us&category=general&apiKey=22318c0edb3f412fb605062a091e4239")
    Call<Root> getWorldNews();
    @GET("everything?q=football AND premierleague&language=en&apiKey=22318c0edb3f412fb605062a091e4239")
    Call<Root> getSportsNews();
    //Call<List<Article>> getArticles();
    @GET("top-headlines?country=in&category=general&apiKey=22318c0edb3f412fb605062a091e4239")
    Call<Root> getIndiaNews();

    @GET("top-headlines?country=us&category=technology&apiKey=22318c0edb3f412fb605062a091e4239")
    Call<Root> getTechNews();


}
