package com.genxium.loginapplication.utility;

import android.view.View;

import com.nineoldandroids.animation.ObjectAnimator;

public class Animation {
    public static void fadeInView(final View view) {
        ObjectAnimator fadeIn = ObjectAnimator.ofFloat(view, "alpha", 0, 1);
        long cycle = 300;
        fadeIn.setDuration(cycle);
        fadeIn.start();
    }

    public static void fadeOutView(final View view) {
        ObjectAnimator fadeOut = ObjectAnimator.ofFloat(view, "alpha", 1, 0);
        long cycle = 300;
        fadeOut.setDuration(cycle);
        fadeOut.start();
    }
}
