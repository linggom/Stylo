package com.stylo.fashion;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseFacebookUtils;

/**
 * Created by goman on 15/11/14.
 */
public class GlobalApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, "vcn3TgIC29UaMJfghDGyyqSC52CbIyrsfjezMz5r", "1TwSJjAW3oW5rK0Nu2Q5XqKAvJlkgjeUylv22Niv");
        ParseFacebookUtils.initialize("1516241068642254");

    }
}
