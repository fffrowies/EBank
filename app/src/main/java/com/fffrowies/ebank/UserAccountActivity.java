package com.fffrowies.ebank;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserAccountActivity extends AppCompatActivity {

    Button logoutButton;
    Button depositButton;
    Button withdrawButton;
    TextView welcomeMessage;
    TextView accountBalance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account);

        findAllViews();
        unpackIntent();
        setupLogoutButton();
        setDepositButton();
        setWithdrawButton();
    }

    private void findAllViews() {
        logoutButton = findViewById(R.id.logoutButton);
        depositButton = findViewById(R.id.depositButton);
        withdrawButton = findViewById(R.id.withdrawButton);
        accountBalance = findViewById(R.id.accountBalance);
        welcomeMessage = findViewById(R.id.userAccountWelcome);
    }

    private void unpackIntent() {
        String username = getIntent().getStringExtra("username");
        welcomeMessage.setText(String.format("Welcome %s", username));
    }

    private void setupLogoutButton() {
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setDepositButton() {
        depositButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String balance = accountBalance.getText().toString();

                int numBalance = Integer.valueOf(balance);
                numBalance += 10;

                final String updatedBalance = String.valueOf(numBalance);
                accountBalance.post(new Runnable() {
                    @Override
                    public void run() {
                        accountBalance.setText(updatedBalance);
                    }
                });
            }
        });
    }

    private void setWithdrawButton() {
        withdrawButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String balance = accountBalance.getText().toString();

                int numBalance = Integer.valueOf(balance);
                numBalance -= 10;

                final String updatedBalace = String.valueOf(numBalance);
                accountBalance.post(new Runnable() {
                    @Override
                    public void run() {
                        accountBalance.setText(updatedBalace);
                    }
                });
            }
        });
    }
}
