package com.stylo.fashion.util.Session;

/**
 * Created by goman on 15/11/14.
 */
public class SessionObj {
    private String sessionToken;
    private String username;
    private String email;

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public SessionObj() {

    }

    public SessionObj(String sessionToken, String username, String email) {
        this.sessionToken = sessionToken;
        this.username = username;
        this.email = email;
    }
}
