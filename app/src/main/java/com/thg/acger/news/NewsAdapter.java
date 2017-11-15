package com.thg.acger.news;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.thg.acger.R;

/**
 * Created by 18814 on 2017/11/16.
 */

public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    String tag = "thg";
    public NewsAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = null;
        RecyclerView.ViewHolder holder = null;
        switch (viewType){
            case NewsItemType.ONE_PIC:
                view = inflater.inflate(R.layout.news_one_pic_item,parent,false);
                holder = new OnePicViewHolder(view);
                break;
            case NewsItemType.THREE_PIC:
                view = inflater.inflate(R.layout.news_three_pic_item,parent,false);
                holder = new OnePicViewHolder(view);
                break;
            case NewsItemType.BIG_PIC:
                view = inflater.inflate(R.layout.news_big_pic_item,parent,false);
                holder = new OnePicViewHolder(view);
                break;
        }
        return holder;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if(holder instanceof OnePicViewHolder){
            Log.i(tag, NewsItemType.ONE_PIC+"");
        }else if(holder instanceof ThreePicViewHolder){
            Log.i(tag, NewsItemType.THREE_PIC+"");
        }else if(holder instanceof BigPicViewHolder){
            Log.i(tag, NewsItemType.BIG_PIC+"");
        }

    }

    @Override
    public int getItemViewType(int position) {
        return position%3;
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    class OnePicViewHolder extends RecyclerView.ViewHolder{

        TextView newsTitle;
        TextView newsTime;
        ImageView newsImage;
        public OnePicViewHolder(View itemView) {
            super(itemView);
            newsTitle = itemView.findViewById(R.id.news_title);
            newsTime = itemView.findViewById(R.id.news_time);
            newsImage = itemView.findViewById(R.id.news_image);
        }
    }

    class BigPicViewHolder extends RecyclerView.ViewHolder{

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

    class ThreePicViewHolder extends RecyclerView.ViewHolder{

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


}
