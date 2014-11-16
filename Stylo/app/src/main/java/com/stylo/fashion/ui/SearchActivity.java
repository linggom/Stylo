package com.stylo.fashion.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.facebook.internal.Utility;
import com.stylo.fashion.R;
import com.stylo.fashion.util.GenerelHelper;
import com.stylo.fashion.util.StyleHelper;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by goman on 15/11/14.
 */
public class SearchActivity extends ActionBarActivity {
    SuggestionAdapter mAdapter;
    EditText mTextQuery;
    ListView listSuggestion;
    ActionBar mActionBar;
    String mKeyword;
    String [] mSuggestion = new String[]{
            "Style by \"%s\"",
            "Trend style from \"%s\"",
            "New \"%s\" style",
            "What \"%s\" used",
            "Recommendation \"%s\"",
            "New Prouct \"%s\"",



    };
    private AdapterView.OnItemClickListener mItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent i = new Intent(SearchActivity.this, SearchResultActivity.class);
            i.putExtra(Intent.ACTION_SEARCH, mKeyword);
            startActivity(i);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        mTextQuery = (EditText) findViewById(R.id.inputSearch);
        StyleHelper.applyTypeFace(this, StyleHelper.Font.FontType.ProximaNovaRegular, mTextQuery);

        listSuggestion = (ListView) findViewById(R.id.list_suggestion);
        mActionBar = getSupportActionBar();
        mActionBar.setDisplayHomeAsUpEnabled(true);
        mActionBar.setDisplayShowHomeEnabled(true);

        mAdapter = new SuggestionAdapter(this);
        listSuggestion.setAdapter(mAdapter);
        listSuggestion.setOnItemClickListener(mItemClickListener);
        mTextQuery.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().trim().length() > 0){
                    mAdapter.setData(mSuggestion);
                }
                else{
                    mAdapter.setData(null);
                }
                mKeyword = s.toString();
                mAdapter.updateKeyword(mKeyword);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    static class SuggestionAdapter extends BaseAdapter{

        private Context mContext;
        private LayoutInflater mInflater;
        private String mKeyword = "";
        private String [] mSuggestion;

        private SuggestionAdapter() {
        }

        public SuggestionAdapter(Context context) {
            this.mContext = context;
            mInflater = LayoutInflater.from(mContext);

        }

        public void setData(String [] suggestion){
            this.mSuggestion = suggestion;
            notifyDataSetChanged();

        }

        public void updateKeyword(String keyword){
            this.mKeyword = keyword;
            notifyDataSetChanged();;
        }

        @Override
        public int getCount() {
            return GenerelHelper.isListNullOrEmpty(mSuggestion)?0 : mSuggestion.length;
        }

        @Override
        public String getItem(int position) {
            return GenerelHelper.isListNullOrEmpty(mSuggestion)? null : mSuggestion[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textSuggestion = null;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.simple_list_item, parent, false);
            }
            textSuggestion = (TextView) convertView.findViewById(R.id.text1);
            StyleHelper.applyTypeFace(mContext, StyleHelper.Font.FontType.ProximaNovaRegular, textSuggestion);
            textSuggestion.setText(String.format(getItem(position), mKeyword));

            return convertView;
        }
    }
}