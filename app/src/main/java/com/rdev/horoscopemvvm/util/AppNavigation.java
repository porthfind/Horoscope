package com.rdev.horoscopemvvm.util;

import android.app.Activity;
import android.content.Intent;

import com.rdev.horoscopemvvm.ui.about.AboutActivity;
import com.rdev.horoscopemvvm.ui.extended.ExtendedActivity;
import com.rdev.horoscopemvvm.ui.sign.SignActivity;
import com.rdev.horoscopemvvm.ui.which.WhichActivity;

/**
 * Created by ritacf on 15/09/18.
 */

public class AppNavigation
{

        public static void goToHoroscopes(Activity activityFrom, String extra, String extraValue){
            Intent intent = new Intent(activityFrom, SignActivity.class);
            intent.putExtra(extra, extraValue);
            activityFrom.startActivity(intent);
        }

        public static void goToWhich(Activity activityFrom){
            Intent intent = new Intent(activityFrom, WhichActivity.class);
            activityFrom.startActivity(intent);
        }

        public static void goToExtended(Activity activityFrom, String extra, String extraValue, String sndExtra, String sndExtraValue){
            Intent intent = new Intent(activityFrom, ExtendedActivity.class);
            intent.putExtra(extra, extraValue);
            intent.putExtra(sndExtra,sndExtraValue);
            activityFrom.startActivity(intent);
        }


        public static void goToAbout(Activity activityFrom){
            Intent intent = new Intent(activityFrom, AboutActivity.class);
            activityFrom.startActivity(intent);
        }


}
