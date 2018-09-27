package com.rdev.horoscopemvvm.ui.which;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.rdev.horoscopemvvm.R;
import com.rdev.horoscopemvvm.util.AppConstants;
import com.rdev.horoscopemvvm.util.AppNavigation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WhichActivity extends AppCompatActivity {

    private boolean isAlertShown = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_which);

        Spinner month, day;
        String[] months;
        Integer[] days;
        List<String> list_months;
        List<Integer> list_days;

        //setColor to title on the ActionBar
        setTitle(Html.fromHtml("<font color=\"#D8863E\">" + getString(R.string.app_name) + "</font>"));
        setContentView(R.layout.activity_which);


        months= new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        days= new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};


        month = (Spinner) findViewById(R.id.spinnerMonth);
        day = (Spinner) findViewById(R.id.spinnerDay);

        list_months = new ArrayList<String>(Arrays.asList(months));
        list_days = new ArrayList<Integer>(Arrays.asList(days));

        //adapter creation - Months
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list_months);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        month.setAdapter(adapter);

        //adapter creation - Days
        ArrayAdapter<Integer> adapter_days = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, list_days);
        adapter_days.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        day.setAdapter(adapter_days);
    }

    public void onClick(View view)
    {
        Button button = (Button) view;
        String text, sign ;
        Spinner position1, position2;
        int day,month;
        String teste= "R.drawable.";

        text = (String)button.getText();

        position2 = (Spinner) findViewById(R.id.spinnerMonth);
        position1 = (Spinner) findViewById(R.id.spinnerDay);

        month = position2.getSelectedItemPosition();
        day = (Integer)position1.getSelectedItem();

        //calculate the sign
        sign = calculateSign(day, month);
        teste = teste+sign+".1";


        if(text.equalsIgnoreCase(getString(R.string.which1))){
            button.setText(sign);
            button.setTextColor(Color.parseColor("#D8863E"));

            if(sign.compareToIgnoreCase(getString(R.string.gemini)) == 0){
                button.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.gemini1, 0, 0);
            }
            else if(sign.compareToIgnoreCase(getString(R.string.aquarius)) == 0){
                button.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.aquarius1, 0, 0);
            }
            else if(sign.compareToIgnoreCase(getString(R.string.pisces)) == 0){
                button.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pisces1, 0, 0);
            }
            else if(sign.compareToIgnoreCase(getString(R.string.aries)) == 0){
                button.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.aries1, 0, 0);
            }
            else if(sign.compareToIgnoreCase(getString(R.string.taurus)) == 0){
                button.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.taurus1, 0, 0);
            }
            else if(sign.compareToIgnoreCase(getString(R.string.cancer)) == 0){
                button.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.cancer1, 0, 0);
            }
            else if(sign.compareToIgnoreCase(getString(R.string.leo)) == 0){
                button.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.leo1, 0, 0);
            }
            else if(sign.compareToIgnoreCase(getString(R.string.virgo)) == 0){
                button.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.virgo1, 0, 0);
            }
            else if(sign.compareToIgnoreCase(getString(R.string.libra)) == 0){
                button.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.libra1, 0, 0);
            }
            else if(sign.compareToIgnoreCase(getString(R.string.scorpion)) == 0){
                button.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.scorpion1, 0, 0);
            }
            else if(sign.compareToIgnoreCase(getString(R.string.sagittarius)) == 0){
                button.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.sagittarius1, 0, 0);
            }
            else if(sign.compareToIgnoreCase(getString(R.string.capricorn)) == 0){
                button.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.capricorn1, 0, 0);
            }
            else{
                buildDialog(WhichActivity.this).show();;
            }


            button.setPadding(0,36,0,22);


        }
        else{
            // go to SignActivity
            AppNavigation.goToHoroscopes(this, AppConstants.OPTION, sign);
        }
    }

    public String calculateSign(int day, int month){

        String horoscope="";

        if (month == 0) {//January
            if (day <= 20)
                horoscope = getString(R.string.capricorn);
            else
                horoscope = getString(R.string.aquarius);
        }
        else if (month == 1)//February
            if (day <= 19)
                horoscope = getString(R.string.aquarius);
            else if(day <= 29)
                horoscope = getString(R.string.pisces);
            else{
                horoscope = "error";
            }
        else if (month == 2)//March
            if (day <= 20)
                horoscope = getString(R.string.pisces);
            else
                horoscope = getString(R.string.aries);
        else if (month == 3)//April
            if (day <= 20)
                horoscope = getString(R.string.aries);
            else if(day <= 30)
                horoscope = getString(R.string.taurus);
            else
                horoscope = "error";
        else if (month == 4)//May
            if (day <= 20)
                horoscope = getString(R.string.taurus);
            else
                horoscope = getString(R.string.gemini);
        else if (month == 5)//June
            if (day <= 20)
                horoscope = getString(R.string.gemini);
            else if(day <= 30)
                horoscope = getString(R.string.cancer);
            else
                horoscope = "error";
        else if (month == 6)//July
            if (day <= 21)
                horoscope = getString(R.string.cancer);
            else
                horoscope = getString(R.string.leo);
        else if (month == 7)//August
            if (day <= 22)
                horoscope = getString(R.string.leo);
            else
                horoscope = getString(R.string.virgo);
        else if (month == 8) //September
            if (day <= 22)
                horoscope = getString(R.string.virgo);
            else if(day <= 30)
                horoscope = getString(R.string.libra);
            else
                horoscope = "error";
        else if (month == 9) //October
            if (day <= 22)
                horoscope = getString(R.string.libra);
            else
                horoscope = getString(R.string.scorpion);
        else if (month == 10) //November
            if (day <= 21)
                horoscope = getString(R.string.scorpion);
            else if(day <= 30)
                horoscope = getString(R.string.sagittarius);
            else
                horoscope = "error";
        else if (month == 11)
            if (day <= 21)
                horoscope = getString(R.string.sagittarius);
            else
                horoscope = getString(R.string.capricorn);



        return horoscope;

    }

    public AlertDialog.Builder buildDialog(Context c) {
        isAlertShown = true;
        AlertDialog.Builder builder = new AlertDialog.Builder(c);
        builder.setTitle(R.string.wrongDate);
        builder.setMessage(R.string.wrongDate_body);

        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                finish();
            }
        });

        return builder;
    }
}
