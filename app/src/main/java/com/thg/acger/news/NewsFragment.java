package com.thg.acger.news;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.thg.acger.R;
import com.thg.acger.network.JsonUtil;
import com.thg.acger.network.NetResultCode;
import com.thg.acger.network.NetworkUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {

    private SmartRefreshLayout refreshLayout;
    private RecyclerView newsList;
    private List<NewsModel.DataBean> newsData;
    private NewsAdapter newsAdapter;
    private String url= "http://120.78.202.104/NewsApi/getAllNews";
    protected String type = "news";
    private int page = 1;

    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        newsList = view.findViewById(R.id.news_list);
        refreshLayout = view.findViewById(R.id.news_refreshLayout);
        newsData = new ArrayList();
        setType();
        newsAdapter = new NewsAdapter(getActivity(), newsData, type);
        newsList.setLayoutManager(new LinearLayoutManager(getActivity()));
        newsList.setAdapter(newsAdapter);
        newsList.addItemDecoration(new MyDecoration(getActivity(),MyDecoration.VERTICAL_LIST));
        loadNetData();
        initEvent();
        return view;
    }

    public void initEvent(){
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                newsData.clear();
                page = 1;
                loadNetData();
            }
        });

        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
//                loadRankListData();
                page ++;
                loadNetData();
            }
        });
    }

    public void initNetworkData(String url) {
        NetworkUtil.post()
                .setUrl(url)
                .addParams("page",page+"")
                .execute(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("wuni","fail");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                NewsModel newsModel = (NewsModel) JsonUtil.getInstance().
                        decodeJsonObject(response.body().string(), NewsModel.class);
                if (response.code() == 200 && newsModel.getData() != null && newsModel.getCode() == 200) {
                    for (int i = 0; i < newsModel.getData().size(); i++) {
                        NewsModel.DataBean dataBean = newsModel.getData().get(i);
                        newsData.add(dataBean);
                    }
                    Log.i("wuni",newsData.size()+"size");


//                    Message message = new Message();
//                    message.what = NetResultCode.SUCCESS;
//                    uiHandler.sendMessage(message);
                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        newsAdapter.notifyDataSetChanged();
                        refreshLayout.finishRefresh();
                        refreshLayout.finishLoadmore();
                    }
                });
            }
        });
    }

//    public Handler uiHandler = new Handler(){
//        @Override
//        public void handleMessage(Message msg) {
//            switch (msg.what){
//                case NetResultCode.SUCCESS:
//                    newsAdapter.notifyDataSetChanged();
//                    break;
//            }
//        }
//    };
    protected void loadNetData(){
        initNetworkData(url);
    }
    protected void setType(){
    }

}
