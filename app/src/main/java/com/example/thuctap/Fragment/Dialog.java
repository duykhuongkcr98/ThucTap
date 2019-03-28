package com.example.thuctap.Fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;

import com.example.thuctap.Activity.SplashScreen;
import com.example.thuctap.R;

public class Dialog extends AppCompatDialogFragment {
    @Override
    public android.app.Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder  builder= new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.alert_dialog).setPositiveButton(R.string.btn_thulai, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        return builder.create();

    }
}
