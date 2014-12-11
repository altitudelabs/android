package com.genxium.loginapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;

public abstract class QooActivity extends ActionBarActivity {

    protected Context mContext = null;
    protected Handler mHandler = null;

    public QooActivity() {
        mContext = this;
        mHandler = new Handler();
    }

    @Override
    public void onNewIntent(Intent it) {
        if (it == null) return;
        handleIntent(it);
    }

    protected abstract void handleIntent(Intent it);
}
