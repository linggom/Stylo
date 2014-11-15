package com.stylo.fashion.helper;

import com.stylo.fashion.util.http.UICallback;

/**
 * Created by goman on 15/11/14.
 */
public class LoginHelper {
    private LoginPresenter mPresenter;
    private UICallback mUiCallback;


    public static interface LoginPresenter{

    }

    public LoginHelper(UICallback uiCallback, LoginPresenter presenter) {
        this.mPresenter = presenter;
        this.mUiCallback = uiCallback;
    }
}
