package com.thg.acger.news;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.thg.acger.R;
import com.thg.acger.pic.ComicActivity;
import com.thg.acger.web.WebContentActivity;

import java.util.List;

/**
 * Created by 18814 on 2017/11/16.
 */

public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private String tag = "thg";
    private List<NewsModel.DataBean> newsData;
    private String type = "news";

    public NewsAdapter(Context context, List<NewsModel.DataBean> newsData, String type) {
        this.context = context;
        this.newsData = newsData;
        this.type = type;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = null;
        RecyclerView.ViewHolder holder = null;
        switch (viewType) {
            case NewsItemType.ONE_PIC:
                view = inflater.inflate(R.layout.news_one_pic_item, parent, false);
                holder = new OnePicViewHolder(view);
                break;
            case NewsItemType.THREE_PIC:
                view = inflater.inflate(R.layout.news_three_pic_item, parent, false);
                holder = new ThreePicViewHolder(view);
                break;
            case NewsItemType.BIG_PIC:
                view = inflater.inflate(R.layout.news_big_pic_item, parent, false);
                holder = new BigPicViewHolder(view);
                break;
        }
        return holder;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (newsData.size() == 0) {
            return;
        }
        switch (Integer.parseInt(newsData.get(position).getType())){
            case NewsItemType.ONE_PIC:
                ((OnePicViewHolder) holder).newsTitle.setText(newsData.get(position).getTitle());
                loadImageNet(newsData.get(position).getImage_url1(), ((OnePicViewHolder) holder).newsImage);
                break;
            case NewsItemType.THREE_PIC:
                ((ThreePicViewHolder) holder).newsTitle.setText(newsData.get(position).getTitle());
                loadImageNet(newsData.get(position).getImage_url1(), ((ThreePicViewHolder) holder).newsImage1);
                loadImageNet(newsData.get(position).getImage_url2(), ((ThreePicViewHolder) holder).newsImage2);
                loadImageNet(newsData.get(position).getImage_url3(), ((ThreePicViewHolder) holder).newsImage3);
                break;
            case NewsItemType.BIG_PIC:
                ((BigPicViewHolder) holder).newsTitle.setText(newsData.get(position).getTitle());
                loadImageNet(newsData.get(position).getImage_url1(), ((BigPicViewHolder) holder).newsImage);
                break;
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (newsData.size() == 0) {
            return 0;
        }
        return Integer.parseInt(newsData.get(position).getType());
    }

    @Override
    public int getItemCount() {
        return newsData.size();
    }

    class OnePicViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView newsTitle;
        TextView newsTime;
        ImageView newsImage;

        public OnePicViewHolder(View itemView) {
            super(itemView);
            newsTitle = itemView.findViewById(R.id.news_title);
            newsTime = itemView.findViewById(R.id.news_time);
            newsImage = itemView.findViewById(R.id.news_image);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = null;
            if(type.equals("comic")){
                intent = new Intent(context, ComicActivity.class);
            }else{
                intent = new Intent(context, WebContentActivity.class);
            }
            intent.putExtra("url", newsData.get(getAdapterPosition()).getUrl());
            context.startActivity(intent);
        }
    }

    class BigPicViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView newsTitle;
        TextView newsTime;
        ImageView newsImage;

        public BigPicViewHolder(View itemView) {
            super(itemView);
            newsTitle = itemView.findViewById(R.id.news_title);
            newsTime = itemView.findViewById(R.id.news_time);
            newsImage = itemView.findViewById(R.id.news_image);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            Intent intent = null;
            if(type.equals("comic")){
                intent = new Intent(context, ComicActivity.class);
            }else{
                intent = new Intent(context, WebContentActivity.class);
            }
            intent.putExtra("url", newsData.get(getAdapterPosition()).getUrl());
            context.startActivity(intent);
        }
    }

    class ThreePicViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView newsTitle;
        TextView newsTime;
        ImageView newsImage1;
        ImageView newsImage2;
        ImageView newsImage3;

        public ThreePicViewHolder(View itemView) {
            super(itemView);
            newsTitle = itemView.findViewById(R.id.news_title);
            newsTime = itemView.findViewById(R.id.news_time);
            newsImage1 = itemView.findViewById(R.id.news_image1);
            newsImage2 = itemView.findViewById(R.id.news_image2);
            newsImage3 = itemView.findViewById(R.id.news_image3);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            Intent intent = null;
            if(type.equals("comic")){
                intent = new Intent(context, ComicActivity.class);
            }else{
                intent = new Intent(context, WebContentActivity.class);
            }
            intent.putExtra("url", newsData.get(getAdapterPosition()).getUrl());
            context.startActivity(intent);
        }
    }

    public void loadImageNet(String url, ImageView imageView) {
        Glide.with(context).load(url).placeholder(R.drawable.beauty).error(R.drawable.ic_menu_share).into(imageView);
    }

}
