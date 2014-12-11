package com.genxium.loginapplication.view.widget;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.genxium.loginapplication.R;
import com.genxium.loginapplication.exception.NullParentException;
import com.genxium.loginapplication.exception.UnknownTypeException;
import com.genxium.loginapplication.model.User;
import com.genxium.loginapplication.utility.Navigation;
import com.genxium.loginapplication.utility.RegexChecker;

public class FormWidget extends QooWidget {

    InputWidget mUnameWidget = null;
    InputWidget mPswWidget = null;

    public FormWidget() {

    }

    @Override
    public void attachWidget(final Context context, final Handler handler, final ViewGroup parent) throws NullParentException {
        super.attachWidget(context, handler, parent);
        final LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mContainer = (ViewGroup) inflater.inflate(R.layout.widget_login_form, null);
        if (mContainer == null) return;

        parent.addView(mContainer);

        mUnameWidget = new InputWidget(InputWidget.TYPE_UNAME);
        mPswWidget = new InputWidget(InputWidget.TYPE_PSW);

        mUnameWidget.attachWidget(context, handler, mContainer);
        mPswWidget.attachWidget(context, handler, mContainer);

        Button btnLogin = new Button(context);
        btnLogin.setText(R.string.title_login);
        btnLogin.setBackgroundResource(R.drawable.solid_gray);
        btnLogin.setTextColor(context.getResources().getColor(R.color.white));
        LinearLayout.LayoutParams btnLoginParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        btnLogin.setLayoutParams(btnLoginParams);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                v.setEnabled(false);

                String uname = mUnameWidget.getVal();
                String psw = mPswWidget.getVal();
                User user = new User(uname, psw);

                AsyncTask loginTask = new AsyncTask<Object, Void, Void>() {

                    protected boolean mIsPswValid = false;
                    protected boolean mIsUnameValid = false;

                    @Override
                    protected Void doInBackground(Object... params) {
                        User user = (User)params[0];
                        if (user == null) return null;
                        mIsUnameValid = RegexChecker.validateName(user.getName());
                        mIsPswValid = RegexChecker.validatePassword(user.getPsw());
                        return null;
                    }

                    @Override
                    protected void onPostExecute(Void result) {
                        v.setEnabled(true);
                        if (!mIsPswValid) {
                            Toast.makeText(context, context.getResources().getString(R.string.message_invalid_psw), Toast.LENGTH_SHORT).show();
                            return;
                        }
                        if (!mIsUnameValid) {
                            Toast.makeText(context, context.getResources().getString(R.string.message_invalid_uname), Toast.LENGTH_SHORT).show();
                            return;
                        }
                        FormWidget.this.clear();
                        Navigation.goToGreetings(context);
                    }
                };

                loginTask.execute(user);
            }
        });
        mContainer.addView(btnLogin);
    }

    public void clear() {
        if (mUnameWidget != null) mUnameWidget.clear();
        if (mPswWidget != null) mPswWidget.clear();
    }
}