package com.genxium.loginapplication.view.widget;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.genxium.loginapplication.R;
import com.genxium.loginapplication.exception.NullParentException;
import com.genxium.loginapplication.utility.Animation;

public class ClickableImageWidget extends QooWidget {
    protected boolean mIsTapped = false;

    @Override
    public void attachWidget(final Context context, final Handler handler, final ViewGroup parent) throws NullParentException {
        super.attachWidget(context, handler, parent);
        final LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mContainer = (ViewGroup) inflater.inflate(R.layout.widget_clickable_image, null);
        if (mContainer == null) return;

        parent.addView(mContainer);

        RelativeLayout rlContainer = (RelativeLayout) mContainer.findViewById(R.id.rl_container);
        rlContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tvMsg = (TextView) v.findViewById(R.id.tv_msg);
                Animation.fadeInView(tvMsg);

                if (!ClickableImageWidget.this.getIsTapped())   {
                    ClickableImageWidget.this.setIsTapped(true);
                    ImageView imgTap = (ImageView)v.findViewById(R.id.img_tap);
                    Animation.fadeOutView(imgTap);
                    return;
                }

                String msg = context.getResources().getString(R.string.message_already_tapped);
                Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
            }
        });
    }

    public boolean getIsTapped() {
        return mIsTapped;
    }

    public void setIsTapped(boolean val) {
        mIsTapped = val;
    }
}