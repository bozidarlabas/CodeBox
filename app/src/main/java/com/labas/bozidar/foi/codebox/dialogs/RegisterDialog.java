package com.labas.bozidar.foi.codebox.dialogs;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.labas.bozidar.foi.codebox.R;

/**
 * Created by bozidar on 11.04.15..
 */
public class RegisterDialog extends DialogBase implements View.OnClickListener{

    private OnClickListener listener;
    private EditText etUsername;
    private EditText etPassword;
    private Button btnRegister;
    private Context context;

    public RegisterDialog(Context context) {
        super(context, R.layout.dialog_register);
        this.context = context;
        main();
    }

    private void main() {
        this.etUsername = (EditText)this.getDialogBuilder().findViewById(R.id.etUsername);
        this.etPassword = (EditText)this.getDialogBuilder().findViewById(R.id.etPassword);
        this.btnRegister = (Button)this.getDialogBuilder().findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(this);
    }

    public void setOnButtonCLickListener(OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();
        listener.onClickListener(username, password);
        builder.dismiss();
        Toast.makeText(context, "You are registered", Toast.LENGTH_SHORT).show();
    }

    public interface OnClickListener {
        public void onClickListener(String username, String password);
    }



}
