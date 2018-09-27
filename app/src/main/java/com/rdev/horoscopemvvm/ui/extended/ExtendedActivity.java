package com.rdev.horoscopemvvm.ui.extended;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.text.Html;

import com.rdev.horoscopemvvm.BR;
import com.rdev.horoscopemvvm.R;
import com.rdev.horoscopemvvm.databinding.ActivityExtendedBinding;
import com.rdev.horoscopemvvm.ui.base.BaseActivity;
import com.rdev.horoscopemvvm.util.AppConstants;
import com.rdev.horoscopemvvm.vo.Horoscopo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.inject.Inject;

import timber.log.Timber;

public class ExtendedActivity extends BaseActivity<ActivityExtendedBinding, ExtendedViewModel> {

    @Inject
    ViewModelProvider.Factory mViewModelFactory;
    ActivityExtendedBinding mActivityStartBinding;
    private ExtendedViewModel mExtendedViewModel;

    private String caps, horos, tipo;
    private String data, prefString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_extended);

        //setColor to Title in the ActionBar
        setTitle(Html.fromHtml("<font color=\"#f9f9f9\">" + getString(R.string.app_name) + "</font>"));


        Bundle extras = getIntent().getExtras();
        horos = extras.getString(AppConstants.OPTION);
        tipo =  extras.getString(AppConstants.TYPE);

        //Obtain today's date in String
        Calendar c = Calendar.getInstance();
        SimpleDateFormat dateformat = new SimpleDateFormat("ddMMMyyyy");
        data = dateformat.format(c.getTime());



        prefString = data+'-'+horos+'-'+tipo;


        mActivityStartBinding = getViewDataBinding();



        mExtendedViewModel.getHoroscope(data,horos, tipo).observe(this, new Observer<Horoscopo>() {
            @Override
            public void onChanged(@Nullable Horoscopo horoscopo) {
                if (horoscopo.getDescription().length()>1){

                    mActivityStartBinding.textSign.setText(horos);
                    mActivityStartBinding.textSign.setTextSize(30);
                    mActivityStartBinding.textExtended.setText(horoscopo.getDescription());
                    mActivityStartBinding.textType.setText(tipo);
                    mActivityStartBinding.textType.setTextSize(25);
                }
                else
                {
                    mActivityStartBinding.textSign.setText(horos);
                    mActivityStartBinding.textSign.setTextSize(30);
                    mActivityStartBinding.textExtended.setText(R.string.error_try);
                    mActivityStartBinding.textType.setText(tipo);
                    mActivityStartBinding.textType.setTextSize(25);
                }


            }
        });

    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    public ExtendedViewModel getViewModel() {
        mExtendedViewModel = ViewModelProviders.of(this, mViewModelFactory).get(ExtendedViewModel.class);
        return mExtendedViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_extended;
    }
}
