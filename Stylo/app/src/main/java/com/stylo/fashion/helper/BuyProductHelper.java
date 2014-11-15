package com.stylo.fashion.helper;

import com.stylo.fashion.util.http.UICallback;

/**
 * Created by goman on 15/11/14.
 */
public class BuyProductHelper {
    private BuyProductPresenter mPresenter;
    private UICallback mUiCallback;


    public static interface BuyProductPresenter{

    }

    public BuyProductHelper(UICallback uiCallback, BuyProductPresenter presenter) {
        this.mPresenter = presenter;
        this.mUiCallback = uiCallback;
    }
}
