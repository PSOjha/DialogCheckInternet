package com.asw.dialogcheckinternet;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (!isNetworkAvailable()) {

            AlertDialog.Builder a_builder1 = new AlertDialog.Builder(this);
            a_builder1.setMessage("No Internet Connection Please Check Internet Connection !!!")
                    .setCancelable(false)
                    .setPositiveButton("Ok", (dialog, which) -> {
                        Intent iLoginVendor = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(iLoginVendor);
                        MainActivity.this.finishAffinity();
                    });

            AlertDialog alert = a_builder1.create();
            alert.setTitle("Your Application Name...");
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Title");

            WindowManager.LayoutParams lp = new WindowManager.LayoutParams();

            lp.copyFrom(alert.getWindow().getAttributes());
            lp.width = 40;
            lp.height = 40;
            lp.x = -170;
            lp.y = 40;
            alert.getWindow().setAttributes(lp);
            alert.show();
        } else {

        }
    }

    private boolean isNetworkAvailable() {

        ConnectivityManager connectivityManager = (ConnectivityManager) this
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager
                .getActiveNetworkInfo();
        return activeNetworkInfo != null;
    }
}