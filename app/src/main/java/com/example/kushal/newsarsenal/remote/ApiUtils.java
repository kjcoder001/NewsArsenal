package com.example.kushal.newsarsenal.remote;

/**
 * Created by kushal on 17-04-2018.
 */

public class ApiUtils {

    public static  final String BASE_URL = "https://newsapi.org/v2/";

    public static NewsService getService()
    {
        return RetrofitClient.getClient(BASE_URL).create(NewsService.class);
    }


}
