package com.thg.acger.website;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thg.acger.R;
import com.thg.acger.news.MyDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class WebsiteFragment extends Fragment {


    private RecyclerView websList;
    private List<WebsiteModel> websiteModelList;
    private WebListAdapter webListAdapter;
    public WebsiteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_website, container, false);
        websList = view.findViewById(R.id.webs_list);
        websiteModelList = new ArrayList<>();
        webListAdapter = new WebListAdapter(getActivity(),websiteModelList);
        websList.setLayoutManager(new GridLayoutManager(getActivity(),4));
        websList.setAdapter(webListAdapter);

        return view;
    }

}
