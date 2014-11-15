package com.stylo.fashion.ui;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.stylo.fashion.R;
import com.stylo.fashion.model.Product;

import java.util.ArrayList;


public class TrendingProductFragment extends Fragment {

    private ListView mListProduct;
    private ProductAdapter mAdapter;
    private Activity mActivity;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = activity;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home, container, false);
        mListProduct = (ListView) view.findViewById(R.id.list_product);
        mAdapter = new ProductAdapter(mActivity);
        mAdapter.setData(new ArrayList<Product>());
        mListProduct.setAdapter(mAdapter);
        mActivity.setTitle("Trending");
        return view;
    }




}
