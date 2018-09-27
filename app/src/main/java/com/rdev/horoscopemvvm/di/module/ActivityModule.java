package com.rdev.horoscopemvvm.di.module;

import com.rdev.horoscopemvvm.ui.extended.ExtendedActivity;
import com.rdev.horoscopemvvm.ui.extended.ExtendedActivityModule;


import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by ritadacostaferreira on 20/08/18.
 */

@Module
public abstract class ActivityModule {

    @ContributesAndroidInjector(modules = {ExtendedActivityModule.class})
    abstract ExtendedActivity contributeExtendedActivity();


}
