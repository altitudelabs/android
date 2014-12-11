package com.genxium.loginapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.genxium.loginapplication.exception.NullParentException;
import com.genxium.loginapplication.view.widget.FormWidget;

public class MainActivity extends QooActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent it = getIntent();
        if (it == null) return;
        handleIntent(it);
    }

    protected void reload() {
        LinearLayout llContainer = (LinearLayout) this.findViewById(R.id.ll_container);
        if (llContainer == null) return;
        FormWidget formWidget = new FormWidget();
        try {
            formWidget.attachWidget(mContext, mHandler, llContainer);
        } catch (NullParentException e) {
            Log.e(this.getClass().getName(), e.getMessage());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void handleIntent(Intent it) {
        reload();
    }
}
