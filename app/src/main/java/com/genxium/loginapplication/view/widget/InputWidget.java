package com.genxium.loginapplication.view.widget;

import android.content.Context;
import android.os.Handler;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.genxium.loginapplication.R;
import com.genxium.loginapplication.exception.NullParentException;
import com.genxium.loginapplication.exception.UnknownTypeException;
import com.genxium.loginapplication.utility.Image;

public class InputWidget extends QooWidget {

    public static final int TYPE_INVALID = -1;
    public static final int TYPE_UNAME = 0;
    public static final int TYPE_PSW = 1;

    protected int mType = TYPE_INVALID;
    protected EditText mInput = null;

    public InputWidget(int type) {
        mType = type;
    }

    @Override
    public void attachWidget(final Context context, final Handler handler, final ViewGroup parent) throws NullParentException {
        super.attachWidget(context, handler, parent);
        final LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mContainer = (ViewGroup) inflater.inflate(R.layout.widget_container, null);
        if (mContainer == null) return;

        parent.addView(mContainer);

        TextView tvTitle = new TextView(context);
        tvTitle.setTextColor(context.getResources().getColor(R.color.gray));
        LinearLayout.LayoutParams tvTitleParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        tvTitle.setLayoutParams(tvTitleParams);

        mInput = new EditText(context);
        LinearLayout.LayoutParams inputParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        mInput.setLayoutParams(inputParams);
        mInput.setMaxLines(1);
        int paddingPixels = Image.getDip(context, 5);
        mInput.setPadding(paddingPixels, paddingPixels, paddingPixels, paddingPixels);
        mInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    v.setBackgroundResource(R.drawable.border_light);
                } else {
                    v.setBackgroundResource(R.drawable.border_gray);
                }
            }
        });
        mInput.setBackgroundResource(R.drawable.border_gray);

        TextView tvHint = new TextView(context);
        LinearLayout.LayoutParams tvHintParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        tvHint.setLayoutParams(tvHintParams);

        switch (mType) {
            case TYPE_UNAME:
                tvTitle.setText(R.string.title_uname);
                mInput.setHint(R.string.hint_uname);
                mInput.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
                break;
            case TYPE_PSW:
                tvTitle.setText(R.string.title_psw);
                mInput.setHint(R.string.hint_psw);
                mInput.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                mInput.setTransformationMethod(PasswordTransformationMethod.getInstance());
                break;
            default:
                Log.e(this.getClass().getName(), "unknown input type");
                break;
        }

        mContainer.addView(tvTitle);
        mContainer.addView(mInput);
        mContainer.addView(tvHint);
    }

    public String getVal() {
        if (mInput == null) return "";
        return mInput.getText().toString();
    }

    public void clear() {
        if (mInput == null) return;
        mInput.setText("");
    }
}