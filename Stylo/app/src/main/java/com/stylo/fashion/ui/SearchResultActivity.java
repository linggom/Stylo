package com.stylo.fashion.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;

import com.stylo.fashion.R;

/**
 * Created by goman on 15/11/14.
 */
public class SearchResultActivity extends ActionBarActivity {
    private ActionBar mActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        mActionBar = getSupportActionBar();
        mActionBar.setDisplayHomeAsUpEnabled(true);
        mActionBar.setDisplayShowHomeEnabled(true);
        mActionBar.setTitle("Search Result");
        getFragmentManager()
                .beginTransaction().
                replace(R.id.fl_search_result, new DiscoverProductFragment())
                .commit();
    }
}
