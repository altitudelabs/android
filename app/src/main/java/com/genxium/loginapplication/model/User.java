package com.genxium.loginapplication.model;

public class User {
    protected String mName = null;
    protected String mPsw = null;

    public User(String name, String psw) {
        mName = name;
        mPsw = psw;
    }

    public String getName() {
        return mName;
    }

    public String getPsw() {
        return mPsw;
    }
}
