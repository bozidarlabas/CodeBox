package com.labas.bozidar.foi.codebox.activities;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.labas.bozidar.foi.codebox.R;

public class RegistrationActivity extends ActionBarActivity {

    private static final String SERVER = "http://test.jtrupina.com";
    private static final String REGISTER_TAG = "registracija";
    private static final String CALL_PHP_FROM_ANDROID = "callPHPfromAndroid";
    EditText inputFirstName;
    EditText inputLastName;
    EditText inputUsername;
    EditText inputEmail;
    EditText inputPassword;
    EditText inputPasswordConfirm;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        /*inputFirstName = (EditText) findViewById(R.id.etRegIme);
        inputLastName = (EditText) findViewById(R.id.etRegPrezime);
        inputUsername = (EditText) findViewById(R.id.etRegKorIme);
        inputEmail = (EditText) findViewById(R.id.etRegMail);
        inputPassword = (EditText) findViewById(R.id.etRegLozinka);
        inputPasswordConfirm = (EditText) findViewById(R.id.etRegPotvrdaLoz);
        btnRegister = (Button) findViewById(R.id.btnRegisterConfirm);
        */
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

    /*
    private void requestRegisterData() {
        String firstName, lastName, username, email, password, passwordConfirm;
        firstName = inputFirstName.getText().toString();
        lastName = inputLastName.getText().toString();
        username = inputUsername.getText().toString();
        email = inputEmail.getText().toString();
        password = inputPassword.getText().toString();
        passwordConfirm = inputPasswordConfirm.getText().toString();
//Retrofit - Slanje zahtjeva i konvertiranje u JSON format
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(SERVER).build();
        RequestAPI post = restAdapter.create(RequestAPI.class);
        post.sendRegistrationRequest(REGISTER_TAG, CALL_PHP_FROM_ANDROID, firstName, lastName, email, username, password, passwordConfirm, new Callback<RegistrationResponse>() {
            @Override
            public void failure(RetrofitError arg0) {

            }

            @Override
            public void success(RegistrationResponse response, Response arg1) {

                Log.d("reg_da", response.getLastName());
            }
        });
    }
    */

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
