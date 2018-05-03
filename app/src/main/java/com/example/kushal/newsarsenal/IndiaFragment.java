package com.example.kushal.newsarsenal;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kushal.newsarsenal.models.Article;
import com.example.kushal.newsarsenal.models.Root;
import com.example.kushal.newsarsenal.remote.ApiUtils;
import com.example.kushal.newsarsenal.remote.NewsService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class IndiaFragment extends Fragment {
    private NewsAdapter adapter;
    private RecyclerView recyclerView;
    private NewsService service;

    public IndiaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.india_fragment,container,false);
        service = ApiUtils.getService();
        recyclerView = (RecyclerView)rootView.findViewById(R.id.IndiaRecyclerView);
        adapter = new NewsAdapter(new ArrayList<Article>(0),getActivity());

        RecyclerView.LayoutManager layoutManager =new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        recyclerView.setHasFixedSize(true);
        loadArticles();
        return rootView;
    }
    public void loadArticles()
    {
        service.getIndiaNews().enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
                adapter.updateArticles(response.body().getArticles());
            }
            @Override
            public void onFailure(Call<Root> call, Throwable t) {
            }
        });
    }

}
