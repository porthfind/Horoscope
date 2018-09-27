package com.rdev.horoscopemvvm.ui.extended;

import android.arch.lifecycle.ViewModelProvider;

import com.rdev.horoscopemvvm.repository.DataManager;
import com.rdev.horoscopemvvm.util.ViewModelProviderFactory;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ritacf on 20/08/18.
 */



@Module
public class ExtendedActivityModule {

    @Provides
    ExtendedViewModel provideStartViewModel(DataManager dataManager) {
        return new ExtendedViewModel(dataManager);
    }

    @Provides
    ViewModelProvider.Factory extendedViewModelProvider(ExtendedViewModel extendedViewModel) {
        return new ViewModelProviderFactory<>(extendedViewModel);
    }

}