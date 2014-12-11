package com.genxium.loginapplication.utility;

import android.content.Context;
import android.util.TypedValue;

public class Image {

    public static int getDip(final Context context, int val) {
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                val,
                context.getResources().getDisplayMetrics()
        );
    }

    public static float getSp(final Context context, float val) {
        float scaledDensity = context.getResources().getDisplayMetrics().scaledDensity;
        return val/scaledDensity;
    }

}
