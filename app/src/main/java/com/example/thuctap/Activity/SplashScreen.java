package com.example.thuctap.Activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.thuctap.Fragment.Dialog;
import com.example.thuctap.R;

public class SplashScreen extends AppCompatActivity {
    private static int SPLASH_TIME_OUT =3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        checInternet();



    }

    public void checInternet() {
        if (isNetworkConnected()){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent= new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            },SPLASH_TIME_OUT);
        }
        else if (!isNetworkConnected()){
            Toast.makeText(this,"no internet",Toast.LENGTH_SHORT).show();
            builderdialog(SplashScreen.this).show();

        }
    }

//    private void opendialog() {
//        Dialog dialog= new Dialog();
//        dialog.show(getSupportFragmentManager(),"dialog");
//
//    }


    private boolean isNetworkConnected() {
        boolean have_WIFI =false;
        boolean have_Mobiledata =false;
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo[] networkInfos = connectivityManager.getAllNetworkInfo();

        for (NetworkInfo info:networkInfos)
        {
            if (info.getTypeName().equalsIgnoreCase("WIFI"))
                if (info.isConnected())
                    have_WIFI = true;

            if (info.getTypeName().equalsIgnoreCase("MOBILE"))
                if (info.isConnected())
                    have_Mobiledata= true;

        }
        return have_Mobiledata||have_WIFI;
    }

    public AlertDialog.Builder builderdialog(Context c){
        AlertDialog.Builder  builder= new AlertDialog.Builder(c);
        builder.setMessage(R.string.alert_dialog).setPositiveButton(R.string.btn_thulai, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                checInternet();
            }
        });
        return builder;

    }


}
