package com.thg.acger.news;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.thg.acger.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MusicFragment extends NewsFragment {
    @Override
    protected void loadNetData() {
        initNetworkData("http://120.78.202.104/NewsApi/getAllMusic");
    }

    @Override
    protected void setType() {
        type = "music";
    }
}
