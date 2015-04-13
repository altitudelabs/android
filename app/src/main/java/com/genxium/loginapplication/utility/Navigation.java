package com.genxium.loginapplication.utility;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.genxium.loginapplication.GreetingsActivity;
import com.genxium.loginapplication.R;

public class Navigation {

    public static void goToGreetings(final Context context) {
        Intent it = new Intent(context, GreetingsActivity.class);
        context.startActivity(it);
        Activity activity = (Activity) context;
        activity.overridePendingTransition(R.animator.left_to_centre, R.animator.centre_to_right);
    }
}
