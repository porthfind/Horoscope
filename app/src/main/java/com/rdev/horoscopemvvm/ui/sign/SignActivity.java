package com.rdev.horoscopemvvm.ui.sign;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.rdev.horoscopemvvm.R;
import com.rdev.horoscopemvvm.util.AppConstants;
import com.rdev.horoscopemvvm.util.AppNavigation;
import com.rdev.horoscopemvvm.util.AppUtils;

public class SignActivity extends AppCompatActivity {


    boolean isAlertShown = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
    }

    public void onClick (View view) {

        String type = "";

        int id = view.getId();

        if(id==R.id.daily) {
            type = AppConstants.daily;
        }
        else if(id==R.id.weekly){
            type = AppConstants.weekly;
        }
        else if(id==R.id.monthly){
           type = AppConstants.monthly;
        }


        //is there any internet connection available?
        if (AppUtils.existsInternet(getApplicationContext())){
            AppNavigation.goToExtended(this,AppConstants.TYPE, type,AppConstants.OPTION,getIntent().getExtras().getString(AppConstants.OPTION));
        }
        else
        {
            buildDialog(SignActivity.this).show();
        }
    }

    public AlertDialog.Builder buildDialog(Context c) {
        isAlertShown = true;
        AlertDialog.Builder builder = new AlertDialog.Builder(c);
        builder.setTitle(R.string.noInternet);
        builder.setMessage(R.string.noInternet_body);

        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                finish();
            }
        });

        return builder;
    }

}
