package com.stylo.fashion.ui;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.stylo.fashion.R;
import com.stylo.fashion.model.Product;

import java.util.ArrayList;


public class TrendingProductFragment extends Fragment{
    private ListView mListProduct;
    private ProductAdapter mAdapter;
    private Activity mActivity;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = activity;

    }

    AdapterView.OnItemClickListener mItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent i = new Intent(mActivity, DetailProductActivity.class);
            i.putExtra(DetailProductActivity.APP_PRODUCT_TITLE,
                    "product");
            i.putExtra(DetailProductActivity.APP_PRODUCT_IMAGE,
                    "http://cdn11.lbstatic.nu/files/looks/medium/2014/11/15/4150082_image.jpg?1416047828");
            startActivity(i);
        }
    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home, container, false);
        mListProduct = (ListView) view.findViewById(R.id.list_product);
        mAdapter = new ProductAdapter(mActivity);
        mAdapter.setData(new ArrayList<Product>());
        mListProduct.setAdapter(mAdapter);
        mActivity.setTitle("Trending");
        mListProduct.setOnItemClickListener(mItemClickListener);
        return view;
    }




}
