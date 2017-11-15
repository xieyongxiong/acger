package com.thg.acger.news;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thg.acger.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {

    private RecyclerView newsList;
    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        newsList = view.findViewById(R.id.news_list);
        NewsAdapter newsAdapter = new NewsAdapter(getActivity());
        newsList.setLayoutManager(new LinearLayoutManager(getActivity()));
        newsList.setAdapter(newsAdapter);
        return view;
    }

}
