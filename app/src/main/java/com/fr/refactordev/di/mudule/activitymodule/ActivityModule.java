package com.fr.refactordev.di.mudule.activitymodule;

import android.app.Activity;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import com.fr.refactordev.ui.mainactivity.ActivityMainViewModel;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;

@Module
@InstallIn(ActivityComponent.class)
public class ActivityModule {
    private Activity activity;



    @Provides
    public ActivityMainViewModel provideMainActivityViewModel() {
        return new ViewModelProvider((ViewModelStoreOwner) activity).get(ActivityMainViewModel.class);
    }


}
