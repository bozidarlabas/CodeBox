package com.labas.bozidar.foi.codebox.dialogs;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;

import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyDialogBuilder;
import com.labas.bozidar.foi.codebox.R;

/**
 * Created by bozidar on 11.04.15..
 */
public class DialogBase {
    protected NiftyDialogBuilder builder;
    private Context context;
    private int layout;

    public DialogBase(Context context) {
        this.context = context;
        main();
    }

    public DialogBase(Context paramContext, int paramInt) {
        this.context = paramContext;
        this.layout = paramInt;
        main();
        this.builder.setCustomView(paramInt, paramContext);
        this.builder.withDuration(700);
    }

    private void main() {
        this.builder = NiftyDialogBuilder.getInstance(this.context);
        this.builder.withMessage(null);
        this.builder.withTitle(null);
    }

    public NiftyDialogBuilder getDialogBuilder() {
        return this.builder;
    }

    public void showDialog() {
        this.builder.show();
    }

    public void setDialogArgs(final Activity activity, String title, String message) {
        this.builder
                .withTitle(title)
                .withTitleColor(context.getResources().getColor(R.color.accentcolor))
                .withTitleColor(Color.WHITE)
                .withMessage(message);

        if (title.equals("Error")) {
            this.builder
                    .withButton1Text("ok")
                    .setButton1Click(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            builder.cancel();
                        }
                    });
        } else if (title.equals("Exit")) {
            this.builder
                    .withButton1Text("Yes")
                    .withButton2Text("No")
                    .setButton1Click(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {
                            activity.finish();
                            System.exit(0);
                        }
                    })
                    .setButton2Click(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {
                            builder.cancel();
                        }
                    });
        }

    }
}
