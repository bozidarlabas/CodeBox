package com.labas.bozidar.foi.codebox.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.labas.bozidar.foi.codebox.R;

import com.labas.bozidar.foi.codebox.dialogs.NotificationDialog;
import com.labas.bozidar.foi.codebox.dialogs.RegisterDialog;
import com.labas.bozidar.foi.codebox.mvp.models.User;
import com.labas.bozidar.foi.codebox.mvp.modules.LoginModule;
import com.labas.bozidar.foi.codebox.mvp.presenters.LoginPresenter;
import com.labas.bozidar.foi.codebox.mvp.views.LoginView;
import com.labas.bozidar.foi.codebox.util.Constants;

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
    List<EditText> userData;
    private RegisterDialog registerDialog;
    private NotificationDialog notificationDialog;

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
        notificationDialog = new NotificationDialog(this);
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
        userData.get(0).setError("Username is empty");
    }

    @Override
    public void setPasswordError() {
        userData.get(1).setError("Password is empty");
    }

    @Override
    public void navigateToHome(User user) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(Constants.KEY_USERNAME, user.getUsername());
        intent.putExtra(Constants.KEY_SCORE, user.getScore());
        startActivity(intent);
        finish();
    }

    @Override
    public void showErrorDialog() {
        notificationDialog.setDialogArgs(this, "Error", "Wrong username or password");
        notificationDialog.showDialog();
    }

    @Override
    protected List<Object> getModules() {
        return Arrays.<Object>asList(new LoginModule(this));
    }

    @OnClick(R.id.btnLogin)
    public void klik() {
        String userName = userData.get(0).getText().toString();
        String password = userData.get(1).getText().toString();

        presenter.validate(userName, password);
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