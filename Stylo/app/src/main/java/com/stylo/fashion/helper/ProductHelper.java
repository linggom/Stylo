package com.stylo.fashion.helper;

import com.stylo.fashion.util.http.UICallback;

/**
 * Created by goman on 15/11/14.
 */
public class ProductHelper {
    private ProductPresenter mPresenter;
    private UICallback mCallback;

    public static interface ProductPresenter{

    }

    public ProductHelper(UICallback callback, ProductPresenter presenter) {
        this.mCallback = callback;
        this.mPresenter = presenter;
    }
}
