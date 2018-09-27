package com.rdev.horoscopemvvm.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.rdev.horoscopemvvm.R;
import com.rdev.horoscopemvvm.ui.settings.SettingsActivity;
import com.rdev.horoscopemvvm.util.AppNavigation;
import com.rdev.horoscopemvvm.util.AppConstants;

public class MainActivity extends SettingsActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick (View view){

        int id;
        String sign="";

        id = view.getId();

        if(id==R.id.which){
            AppNavigation.goToWhich(this);
        }
        else if(id == R.id.aquarius) {
            sign = getString(R.string.aquarius);
            AppNavigation.goToHoroscopes(this, AppConstants.OPTION,sign);
        }
        else if(id==R.id.pisces) {
            sign = getString(R.string.pisces);
            AppNavigation.goToHoroscopes(this, AppConstants.OPTION,sign);
        }
        else if(id==R.id.aries) {
            sign = getString(R.string.aries);
            AppNavigation.goToHoroscopes(this, AppConstants.OPTION,sign);
        }
        else if(id==R.id.taurus) {
            sign = getString(R.string.taurus);
            AppNavigation.goToHoroscopes(this, AppConstants.OPTION,sign);
        }
        else if(id==R.id.gemini) {
            sign = getString(R.string.gemini);
            AppNavigation.goToHoroscopes(this, AppConstants.OPTION,sign);
        }
        else if(id==R.id.cancer) {
            sign = getString(R.string.cancer);
            AppNavigation.goToHoroscopes(this, AppConstants.OPTION,sign);
        }
        else if(id==R.id.leo) {
            sign = getString(R.string.leo);
            AppNavigation.goToHoroscopes(this, AppConstants.OPTION,sign);
        }
        else if(id==R.id.virgo) {
            sign = getString(R.string.virgo);
            AppNavigation.goToHoroscopes(this, AppConstants.OPTION,sign);
        }
        else if(id==R.id.libra) {
            sign = getString(R.string.libra);
            AppNavigation.goToHoroscopes(this, AppConstants.OPTION,sign);
        }
        else if(id==R.id.scorpius) {
            sign = getString(R.string.scorpion);
            AppNavigation.goToHoroscopes(this, AppConstants.OPTION,sign);
        }
        else if(id==R.id.sagitarius) {
            sign = getString(R.string.sagittarius);
            AppNavigation.goToHoroscopes(this, AppConstants.OPTION,sign);
        }
        else if(id==R.id.capricorn) {
            sign = getString(R.string.capricorn);
            AppNavigation.goToHoroscopes(this, AppConstants.OPTION,sign);
        }
    }
}
