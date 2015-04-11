package com.labas.bozidar.foi.codebox.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.labas.bozidar.foi.codebox.R;
import com.labas.bozidar.foi.codebox.dialogs.RegisterDialog;
import com.labas.bozidar.foi.codebox.mvp.modules.LoginModule;
import com.labas.bozidar.foi.codebox.mvp.presenters.LoginPresenter;
import com.labas.bozidar.foi.codebox.mvp.views.LoginView;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.InjectViews;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginView, RegisterDialog.OnClickListener {

    @Inject
    LoginPresenter presenter;

    @InjectView(R.id.pbLogin)
    ProgressBar progressBar;
    @InjectView(R.id.btnLogin)
    Button btnLogin;
    @InjectViews({R.id.etUsername, R.id.etPassword})
    List<EditText> credentials;
    private RegisterDialog registerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setSupportActionBar((Toolbar)findViewById(R.id.app_bar));
        ButterKnife.inject(this);
        main();
    }

    private void main(){
        registerDialog = new RegisterDialog(this);
        registerDialog.setOnButtonCLickListener(this);
    }

    private void setLayouts() {

    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void setUsernameError() {
        credentials.get(0).setError("Username is empty");
    }

    @Override
    public void setPasswordError() {
        credentials.get(1).setError("Password is empty");
    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    protected List<Object> getModules() {
        return Arrays.<Object>asList(new LoginModule(this));
    }

    @OnClick(R.id.btnLogin)
    public void klik() {
        //TODO call presenter (username, password)
        presenter.validate("b", "1");
    }

    @OnClick(R.id.btnRegistration)
    public void registration(){
        this.registerDialog.showDialog();
    }

    @Override
    public void onClickListener(String username, String password) {
        presenter.sendRegistrationData(username, password);
    }
}