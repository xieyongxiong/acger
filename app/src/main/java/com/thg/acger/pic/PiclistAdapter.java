package com.thg.acger.pic;

import android.content.ClipData;
import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.thg.acger.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xieyongxiong on 2017/11/21.
 */

public class PiclistAdapter extends RecyclerView.Adapter {
    private Context context;
    private LayoutInflater inflater;
    private String[] typeTitles = {"漫画","同人","COS","美图"};

    public PiclistAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == ItemType.topType){
            View view = inflater.inflate(R.layout.pic_type_top, parent, false);
            return new TypeTopHolder(view);
        }else if(viewType == ItemType.typeItem){
            View view = inflater.inflate(R.layout.pic_type_item, parent, false);
            return new TypeItemHolder(view);
        }else {
            View view = inflater.inflate(R.layout.pic_item_content, parent, false);
            return new TypeContentHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof TypeTopHolder){
            ((TypeTopHolder) holder).topTypeList.setLayoutManager(new GridLayoutManager(context, 4));
            ((TypeTopHolder) holder).topTypeList.setAdapter(new TypeCategoryAdapter(context));
        }else if(holder instanceof TypeItemHolder){
            ((TypeItemHolder) holder).typeTitle.setText(typeTitles[(position-1)/2]);
        }else if(holder instanceof TypeContentHolder){

        }

    }

    @Override
    public int getItemCount() {
        return 9;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return ItemType.topType;
        } else if (position % 2 == 0) {
            return ItemType.typeItem;
        }else {
            return ItemType.typeContent;
        }
    }



    public class TypeTopHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.pic_type_top)
        RecyclerView topTypeList;

        public TypeTopHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public class TypeItemHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.type_item_image)
        ImageView typeImage;

        @Bind(R.id.type_item_title)
        TextView typeTitle;

        @Bind(R.id.type_item_button)
        TextView typeButton;

        public TypeItemHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public class TypeContentHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.pic_content_list)
        RecyclerView picContent;

        public TypeContentHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public static class ItemType {
        public static int topType = 0;
        public static int typeItem = 1;
        public static int typeContent = 2;
    }
}
