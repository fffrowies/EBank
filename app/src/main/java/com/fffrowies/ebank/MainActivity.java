package com.fffrowies.ebank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.makeText;

public class MainActivity extends AppCompatActivity {

    final String correctUsername = "Camiluchi";
    final String correctPassword = "chachuesnegra";

    EditText userNameInput;
    EditText passwordInput;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findAllViews();
        loginButtonListener();
    }

    private void findAllViews() {
        userNameInput = findViewById(R.id.userNameInput);
        passwordInput = findViewById(R.id.passwordInput);
        loginButton = findViewById(R.id.loginButton);
    }

    private void loginButtonListener() {
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = userNameInput.getText().toString();
                String password = passwordInput.getText().toString();

                if (username.equals(correctUsername) && password.equals(correctPassword)) {
                    Toast loginSuccesToast = makeText(getApplicationContext(),"Login Success!", Toast.LENGTH_LONG);
                    loginSuccesToast.show();

                    Log.d("BUTTON", "Correct password!");
                    Log.d("BUTTON", "username: " + username);
                    Log.d("BUTTON", "password: " + password);

                    Intent launchUserAccount = new Intent(MainActivity.this, UserAccountActivity.class);
                    launchUserAccount.putExtra("username", correctUsername);
                    startActivity(launchUserAccount);
                }
                else {
                    Toast loginFailToast = makeText(getApplicationContext(),"Login Fail!", Toast.LENGTH_LONG);
                    loginFailToast.show();

                    Log.d("BUTTON", "INCORRECT PASSWORD!");
                }
            }
        });
    }
}
