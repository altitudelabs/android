package challengeapp.com.androidapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;


public class Login extends Activity {

    private EditText username,password;
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        loginBtn = (Button) findViewById(R.id.login);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().length()<8){
                    say("Sorry, Username must contain at least 8 characters.\nPlease try again.");
                    return;
                }
                if(password.getText().length()<8){
                    say("Sorry, Password must contain at least 8 characters.\nPlease try again.");
                    return;
                }
                else if(!Pattern.matches("[a-zA-Z]+",username.getText())){
                    say("Sorry, Username must be all alphabetic.\nPlease try again.");
                    return;
                }

                Intent intent = new Intent(Login.this, showActivity.class);
                startActivityForResult(intent,0);

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 0) {
            if(resultCode == RESULT_OK){
               username.setText("");
                password.setText("");
                username.requestFocus();
            }
            else if (resultCode == RESULT_CANCELED) {

            }
        }
    }

    public void say(String text){
      Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
    }
}
