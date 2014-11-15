package com.stylo.fashion.util.http;

/**
 * Created by goman on 15/11/14.
 */
public interface UICallback {
    public void preLoad();
    public void postLoad();
    public void empty();
    public void failed();
}
