package com.rdev.horoscopemvvm.ui.settings;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.rdev.horoscopemvvm.BuildConfig;
import com.rdev.horoscopemvvm.R;
import com.rdev.horoscopemvvm.ui.about.AboutActivity;
import com.rdev.horoscopemvvm.util.AppNavigation;

public class SettingsActivity extends AppCompatPreferenceActivity{


    /**
     * Helper method to determine if the device has an extra-large screen. For
     * example, 10" tablets are extra-large.
     */
    private static boolean isXLargeTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_XLARGE;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_common, menu);

        return super.onCreateOptionsMenu(menu);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_rate:
                rateApp();
                return true;
            case R.id.action_share:
                shareApp();
                return true;
            case R.id.action_about:
                aboutApp();
                return true;
            case R.id.action_feedback:
                View view = (View) findViewById(R.id.action_feedback);
                commentApp(view);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
        //return true;

    }

    protected void rateApp() {
        //method to rate the application. Go to the Play Google Market to rate.

        Context context = getApplicationContext();

        Uri uri = Uri.parse("market://details?id=com.converter.android.dailyhoroscope");
        Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
        try {
            startActivity(goToMarket);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.converter.android.dailyhoroscope")));
        }
    }

    protected void shareApp() {
        //method to share the app. User can choose the application to share
        Intent i;


        try {
            i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_SUBJECT, "Daily Horoscope");
            String sAux = getString(R.string.recommend);
            sAux = sAux + "https://play.google.com/store/apps/details?id=com.converter.android.dailyhoroscope \n\n";
            i.putExtra(Intent.EXTRA_TEXT, sAux);
            startActivity(Intent.createChooser(i, getString(R.string.choose)));
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    protected void aboutApp() {
        AppNavigation.goToAbout(this);
    }

    protected void commentApp(View view) {
        //method to user give feedback. Opens a Dialog with 2 buttons cancel and ok and an edittext

        final Dialog dialog = new Dialog(this);

        //set color to title of Dialog
        dialog.setTitle(Html.fromHtml("<font color=\"#cde4e3\">" + getString(R.string.feedback) + "</font>"));

        //add color.transparent to can draw the round borders of the dialog
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.setContentView(R.layout.activity_opinion);
        dialog.show();



        Button cancel = (Button) dialog.findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//cancel
                dialog.cancel();
            }
        });


        Button send = (Button) dialog.findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText view = (EditText) dialog.findViewById(R.id.editText2);

               Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.opinion));
                intent.putExtra(Intent.EXTRA_TEXT, view.getText().toString());
                intent.setData(Uri.parse(BuildConfig.MAINEMAIL));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // this will make such that when user returns to your app, your app is displayed, instead of the email app.
                startActivity(intent);
                dialog.cancel();
            }
        });



    }


}
