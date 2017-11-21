package com.thg.acger.pic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.thg.acger.R;

public class PicActivity extends AppCompatActivity {

    private RecyclerView picList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic);
        picList = (RecyclerView)findViewById(R.id.pic_list);
        picList.setLayoutManager(new LinearLayoutManager(this));
        picList.setAdapter(new PiclistAdapter(this));
        initData();
    }
    public void initData(){

    }
}
