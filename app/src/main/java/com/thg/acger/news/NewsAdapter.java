package com.thg.acger.news;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.thg.acger.R;

import java.util.List;

/**
 * Created by 18814 on 2017/11/16.
 */

public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private String tag = "thg";
    private List<NewsModel.DataBean> newsData;

    public NewsAdapter(Context context, List<NewsModel.DataBean> newsData) {
        this.context = context;
        this.newsData = newsData;
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
                loadImageNet(newsData.get(position).getImage_url().get(0), ((OnePicViewHolder) holder).newsImage);
                break;
            case NewsItemType.THREE_PIC:
                ((ThreePicViewHolder) holder).newsTitle.setText(newsData.get(position).getTitle());
//                loadImageNet(newsData.get(position).getImage_url().get(0), ((ThreePicViewHolder) holder).newsImage1);
//                loadImageNet(newsData.get(position).getImage_url().get(1), ((ThreePicViewHolder) holder).newsImage1);
//                loadImageNet(newsData.get(position).getImage_url().get(2), ((ThreePicViewHolder) holder).newsImage1);
                break;
            case NewsItemType.BIG_PIC:
                ((BigPicViewHolder) holder).newsTitle.setText(newsData.get(position).getTitle());
                loadImageNet(newsData.get(position).getImage_url().get(0), ((BigPicViewHolder) holder).newsImage);
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
            Intent intent = new Intent(context, NewsContentActivity.class);
            intent.putExtra("url", newsData.get(getAdapterPosition()).getUrl());
            context.startActivity(intent);
        }
    }

    class BigPicViewHolder extends RecyclerView.ViewHolder {

        TextView newsTitle;
        TextView newsTime;
        ImageView newsImage;

        public BigPicViewHolder(View itemView) {
            super(itemView);
            newsTitle = itemView.findViewById(R.id.news_title);
            newsTime = itemView.findViewById(R.id.news_time);
            newsImage = itemView.findViewById(R.id.news_image);
        }
    }

    class ThreePicViewHolder extends RecyclerView.ViewHolder {

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
        }
    }

    public void loadImageNet(String url, ImageView imageView) {
        Glide.with(context).load(url).placeholder(R.drawable.beauty).error(R.drawable.ic_menu_share).into(imageView);
    }

}
