package com.rdev.horoscopemvvm.di.component;

import android.app.Application;

import com.rdev.horoscopemvvm.HoroscopeMVVM;
import com.rdev.horoscopemvvm.di.module.ActivityModule;
import com.rdev.horoscopemvvm.di.module.AppModule;
import com.rdev.horoscopemvvm.di.module.NetModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by ritacf on 20/08/18.
 */

@Singleton
@Component(modules = {AndroidInjectionModule.class, NetModule.class, AppModule.class, ActivityModule.class})
public interface ExtendedComponent
{
    @Component.Builder
    interface Builder{
        @BindsInstance
        Builder application(Application application);


        ExtendedComponent build();
    }
    void inject(HoroscopeMVVM app);
}

