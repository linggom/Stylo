package com.stylo.fashion.helper;

import com.stylo.fashion.util.http.UICallback;

/**
 * Created by goman on 15/11/14.
 */
public class SearchHelper {

    private SearchPresenter mPresenter;
    private UICallback mCallback;

    public static interface SearchPresenter{

    }

    public SearchHelper(UICallback callback, SearchPresenter presenter) {
        this.mCallback = callback;
        this.mPresenter = presenter;
    }
}
