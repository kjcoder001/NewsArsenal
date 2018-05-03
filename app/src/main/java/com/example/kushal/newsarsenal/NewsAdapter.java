package com.example.kushal.newsarsenal;

import android.content.ClipData;
import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kushal.newsarsenal.models.Article;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by kushal on 17-04-2018.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ArticleHolder> {

    List<Article> articles;
    Context context;

    public NewsAdapter(List<Article> articles,Context context)
    {
        this.context = context;
        this.articles = articles;
    }
    @Override
    public ArticleHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View rootView = LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.list_item,parent,false);

        ArticleHolder holder = new ArticleHolder(rootView);
        return holder;

    }

    @Override
    public void onBindViewHolder(ArticleHolder holder, int position) {

        if(articles.get(position).getUrlToImage()!=null) {
            if(articles.get(position).getDescription()!=null) {
                holder.summary.setText(articles.get(position).getDescription().toString());
            }else
            {
                holder.summary.setText("Summary text");
            }
            Picasso.with(context)
                    .load(Uri.parse(articles.get(position).getUrlToImage().toString()))
                    .into(holder.imageView);

        }
        else{
            holder.imageView.setImageResource(R.drawable.ic_launcher_background);
        }

    }

    @Override
    public int getItemCount() {
        return articles.size();
    }


    public void updateArticles(List<Article> articles) {
        this.articles = articles;
        notifyDataSetChanged();
    }

    public class ArticleHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public CardView cardView;
        public ImageView imageView;
        public TextView summary;

       // ItemListener listener;

        public ArticleHolder(View itemView)
        {
            super(itemView);
            cardView = (CardView)itemView.findViewById(R.id.cardView);
            imageView = (ImageView)itemView.findViewById(R.id.imageView);
            summary = (TextView)itemView.findViewById(R.id.summary_text);

           // this.listener = listener;
           // itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
           // Article article =
        }
    }


//    public interface ItemListener{
//
//        void onItemClick(long id);
//    }

}
