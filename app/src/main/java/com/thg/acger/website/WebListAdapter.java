package com.thg.acger.website;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.thg.acger.R;

import java.util.List;

/**
 * Created by xieyongxiong on 2017/11/17.
 */

public class WebListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private List<WebsiteModel> data;

    public WebListAdapter(Context context, List<WebsiteModel> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.website_item, parent, false);
        WebsiteViewholer websiteViewholer = new WebsiteViewholer(view);
        return websiteViewholer;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((WebsiteViewholer)holder).webName.setText("酷站"+position);
        Glide.with(context).load(R.drawable.ic_menu_camera);

    }

    @Override
    public int getItemCount() {
        return 16;
    }
    class WebsiteViewholer extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView webName;
        ImageView webIcon;
        public WebsiteViewholer(View itemView) {
            super(itemView);
            webName = itemView.findViewById(R.id.web_name);
            webIcon = itemView.findViewById(R.id.web_icon);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }

}
