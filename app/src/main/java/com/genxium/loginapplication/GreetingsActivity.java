package com.genxium.loginapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.genxium.loginapplication.exception.NullParentException;
import com.genxium.loginapplication.exception.UnknownTypeException;
import com.genxium.loginapplication.view.widget.ClickableImageWidget;

public class GreetingsActivity extends QooActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greetings);

        Intent it = getIntent();
        if (it == null) return;
        handleIntent(it);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_greetings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void handleIntent(Intent it) {

        LinearLayout llClickableImage = (LinearLayout) findViewById(R.id.ll_clickable_image);

        ClickableImageWidget imgWidget = new ClickableImageWidget();
        try {
            imgWidget.attachWidget(mContext, mHandler, llClickableImage);
        } catch (NullParentException e) {
            Log.e(this.getClass().getName(), e.getMessage());
        }

        Button btnBack = (Button) this.findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GreetingsActivity.this.finish();
            }
        });
    }

    @Override
    public void finish() {
        super.finish();
        this.overridePendingTransition(R.animator.right_to_centre, R.animator.centre_to_left);
    }
}
