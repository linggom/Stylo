package com.stylo.fashion.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseFacebookUtils;
import com.parse.ParseUser;
import com.stylo.fashion.R;
import com.stylo.fashion.helper.LoginHelper;
import com.stylo.fashion.util.Session.SessionManager;
import com.stylo.fashion.util.http.UICallback;

import org.opensocial.Client;
import org.opensocial.RequestException;
import org.opensocial.Response;
import org.opensocial.auth.AuthScheme;
import org.opensocial.auth.OAuth2LeggedScheme;
import org.opensocial.models.Model;
import org.opensocial.providers.Provider;
import org.opensocial.services.PeopleService;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by goman on 15/11/14.
 */
public class LoginActivity extends Activity implements UICallback, LoginHelper.LoginPresenter {

    private LoginHelper mHelper;
    private Button mBntLoginFacebook;

    public LoginActivity() {
        mHelper = new LoginHelper(this, this);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mBntLoginFacebook = (Button) findViewById(R.id.btn_login_fb);
        mBntLoginFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ParseFacebookUtils.logIn(LoginActivity.this, new LogInCallback() {
//                    @Override
//                    public void done(ParseUser user, ParseException err) {
                        SessionManager
                                .getInstance(LoginActivity.this)
                                .newSession("1516241068642254",
                                        "goman",
                                        "linggom@ymail.com");
                        Intent i = new Intent(LoginActivity.this, ProfileActivity.class);
                        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        finish();
                        startActivity(i);
//                        if (user == null) {
//                            Toast
//                                    .makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_LONG)
//                                    .show();
//                        } else if (user.isNew()) {
//                            SessionManager
//                                    .getInstance(LoginActivity.this)
//                                    .newSession(user.getSessionToken(),
//                                            user.getUsername(),
//                                            user.getEmail());
//                            Intent i = new Intent(LoginActivity.this, HomeActivity.class);
//                            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                            startActivity(i);
//                            finish();
//                        } else {
//                            SessionManager
//                                    .getInstance(LoginActivity.this)
//                                    .newSession(user.getSessionToken(),
//                                            user.getUsername(),
//                                            user.getEmail());
//                            Intent i = new Intent(LoginActivity.this, HomeActivity.class);
//                            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                            startActivity(i);
//                            finish();
//                        }
//                    }
//                });
            }
        });

    }

    @Override
    public void preLoad() {

    }

    @Override
    public void postLoad() {

    }

    @Override
    public void empty() {

    }

    @Override
    public void failed() {

    }
}
