package com.labas.bozidar.foi.codebox.activities;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.labas.bozidar.foi.codebox.R;

public class RegistrationActivity extends ActionBarActivity {

    EditText inputFirstName;
    EditText inputLastName;
    EditText inputUsername;
    EditText inputEmail;
    EditText inputPassword;
    EditText inputPasswordConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }

    public void registerUser(View view) {
        if ((!inputUsername.getText().toString().equals(""))
                && (!inputPassword.getText().toString().equals(""))
                && (!inputPasswordConfirm.getText().toString().equals(""))
                && (!inputFirstName.getText().toString().equals(""))
                && (!inputLastName.getText().toString().equals(""))
                && (!inputEmail.getText().toString().equals(""))) {
            if (inputUsername.getText().toString().length() > 4 && isOnline()) {
                //requestRegisterData();
            } else {
                Toast.makeText(getApplicationContext(),
                        "Korisnièko ime mora imati minimalno 5 znakova",
                        Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getApplicationContext(),
                    "Imate praznih polja", Toast.LENGTH_SHORT).show();
        }
    }

    protected boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        } else {
            return false;
        }
    }
}
