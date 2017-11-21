package com.thg.acger.pic;


import android.content.Context;
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
 * Created by 666 on 2017/1/3.
 * 首页分类
 */
public class TypeCategoryAdapter extends RecyclerView.Adapter<TypeCategoryAdapter.TypetypeHolder> {

    private Context mContext;
    private LayoutInflater inflater;
    private String[] typeTitles = {"漫画","同人","COS","美图"};

    public TypeCategoryAdapter(Context mContext) {
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public TypetypeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TypetypeHolder(inflater.inflate(R.layout.pic_type_top_item, null));
    }

    @Override
    public void onBindViewHolder(TypetypeHolder holder, int position) {
        holder.typeImage.setImageResource(R.drawable.ic_menu_camera);
        holder.typetext.setText(typeTitles[0]);
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    //中间的四个type
    public class TypetypeHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.pic_type_image)
        ImageView typeImage;
        @Bind(R.id.pic_type_text)
        TextView typetext;

        public TypetypeHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
