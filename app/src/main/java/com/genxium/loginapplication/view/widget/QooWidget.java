package com.genxium.loginapplication.view.widget;

import android.content.Context;
import android.os.Handler;
import android.view.ViewGroup;

import com.genxium.loginapplication.exception.NullParentException;

public abstract class QooWidget {

    protected Context mContext = null;
    protected Handler mHandler = null;
    protected boolean mIsShowingWidget = false;
    protected ViewGroup mContainer = null;

    public void attachWidget(final Context context, final Handler handler, final ViewGroup parent) throws NullParentException {
        mContext = context;
        mHandler = handler;
        if (parent == null) throw new NullParentException();
        mIsShowingWidget = true;
    }

    public void removeWidget() {

        mIsShowingWidget = false;
        if (mContainer== null) return;
        ViewGroup parent = (ViewGroup) mContainer.getParent();
        if (parent == null) return;
        parent.removeView(mContainer);
        mContainer = null;

    }

    public boolean isShowingWidget() {
        return mIsShowingWidget;
    }
}
