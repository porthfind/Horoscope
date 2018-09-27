package com.rdev.horoscopemvvm.di.module;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.rdev.horoscopemvvm.repository.AppDataManager;
import com.rdev.horoscopemvvm.repository.DataManager;
import com.rdev.horoscopemvvm.util.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ritacf on 20/08/18.
 */

@Module
public class AppModule {

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application.getApplicationContext();
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }



}
