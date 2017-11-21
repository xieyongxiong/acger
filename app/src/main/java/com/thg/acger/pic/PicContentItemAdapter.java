package com.thg.acger.pic;

/**
 * Created by 18814 on 2017/11/21.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.thg.acger.R;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 666 on 2017/1/3.
 * 首页分类
 */
public class PicContentItemAdapter extends RecyclerView.Adapter<PicContentItemAdapter.PicContentHolder> {

    private Context mContext;
    private LayoutInflater inflater;

    public PicContentItemAdapter(Context mContext) {
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public PicContentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PicContentHolder(inflater.inflate(R.layout.pic_content_item, null));
    }

    @Override
    public void onBindViewHolder(PicContentHolder holder, int position) {
        holder.picContentImage.setImageResource(R.drawable.beauty);
        holder.picContentTitle.setText("AAAAAAAAAAAAAAAAAAAAAAA");
        holder.picContentOther.setText("BBBBBBBBBBBBBBBBBBBBb");
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    //中间的四个type
    public class PicContentHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.pic_content_image)
        ImageView picContentImage;
        @Bind(R.id.pic_content_title)
        TextView picContentTitle;
        @Bind(R.id.pic_content_other)
        TextView picContentOther;

        public PicContentHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
