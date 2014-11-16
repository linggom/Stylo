package com.stylo.fashion.util.Session;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.stylo.fashion.ui.NavigationDrawerFragment;
import com.stylo.fashion.util.GenerelHelper;
import com.stylo.fashion.util.contract.AppConstant;

/**
 * Created by goman on 15/11/14.
 */
public class SessionManager {

    private static volatile SessionManager mSessionManager;
    private Context mContext;
    private SharedPreferences mPreferences;

    public static SessionManager getInstance(Context context){
        if (mSessionManager == null){
            synchronized (SessionManager.class){
                if (mSessionManager == null){
                    mSessionManager = new SessionManager(context);
                }
            }
        }
        return mSessionManager;
    }

    public boolean isLogin(){
        String sessionId = mPreferences.getString(AppConstant.APP_SESSION_TOKEN, null);
        boolean isLogin = !GenerelHelper.isStringNullOrEmpty(sessionId);
        return isLogin;
    }

    public void loginOnce(){
        mPreferences.edit().putString(AppConstant.APP_SESSION_TOKEN, "dummy").commit();
    }

    public void clearSession(){
        mPreferences.edit().putString(AppConstant.APP_SESSION_TOKEN,    null).commit();
        mPreferences.edit().putString(AppConstant.APP_SESSION_EMAIL,    null).commit();
        mPreferences.edit().putString(AppConstant.APP_SESSION_USERNAME, null).commit();
        mPreferences.edit().putBoolean(NavigationDrawerFragment.PREF_USER_LEARNED_DRAWER, true).commit();
    }

    public SessionManager(Context context) {
        this.mContext = context;
        mPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
    }

    public void newSession(String sessionToken, String username, String email) {
        mPreferences.edit().putString(AppConstant.APP_SESSION_TOKEN,    sessionToken).commit();
        mPreferences.edit().putString(AppConstant.APP_SESSION_EMAIL,    username).commit();
        mPreferences.edit().putString(AppConstant.APP_SESSION_USERNAME, email).commit();
    }
    public SessionObj getActiveSession(){
        String sessionToken = mPreferences.getString(AppConstant.APP_SESSION_TOKEN,         null);
        String sessionEmail = mPreferences.getString(AppConstant.APP_SESSION_EMAIL,         null);
        String sessionUsername = mPreferences.getString(AppConstant.APP_SESSION_USERNAME,   null);
        SessionObj obj = new SessionObj(sessionToken, sessionUsername, sessionEmail);
        return obj;
    }
}
