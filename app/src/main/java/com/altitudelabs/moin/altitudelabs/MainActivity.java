package com.altitudelabs.moin.altitudelabs;

import android.app.Activity;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.view.*;
import android.widget.*;
import android.content.Intent;


public class MainActivity extends Activity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText userEditText = (EditText) findViewById(R.id.editText);
        EditText passEditText = (EditText) findViewById(R.id.editText2);

        userEditText.setText("");
        passEditText.setText("");

        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                EditText userEditText = (EditText) findViewById(R.id.editText);
                EditText passEditText = (EditText) findViewById(R.id.editText2);

                if(userEditText.getText().toString().matches("^[a-zA-Z ]+$") && userEditText.getText().toString().length() > 7 && passEditText.getText().toString().length() > 7 )
                {
                    Intent intent = new Intent(getApplication(), ImageActivity.class);
                    startActivity(intent);
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
