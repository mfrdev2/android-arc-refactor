package com.fr.refactordev.di.component;

import android.app.Application;

import com.fr.refactor.di.mudule.appmodule.RetrofitModule;
import com.fr.refactordev.MyApp;
import com.fr.refactordev.data.preferances.prefs.PreferencesHelper;
import com.fr.refactordev.data.remote.dao.AddressDao;
import com.fr.refactordev.data.remote.repositories.AddressRepo;
import com.fr.refactordev.di.mudule.appmodule.ApiModule;
import com.fr.refactordev.ui.mainactivity.ActivityMainViewModel;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {RetrofitModule.class, ApiModule.class})
public interface AppComponent {

    void inject(MyApp app);
    void inject(AddressDao addressDao);
    void inject(AddressRepo addressDao);
    void inject(ActivityMainViewModel mainViewModel);

    PreferencesHelper providePreferencesHelper();


    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
