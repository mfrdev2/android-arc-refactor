package com.fr.refactordev;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.fr.refactordev.di.component.AppComponent;
import com.fr.refactordev.utils.applogger.AppLogger;

public class MyApp extends Application {
    public static final String SP_KEY_LABEL_OFFSET = "labelOffset";
    public static final String SP_KEY_LABEL_SIZE = "labelSize";

    public static MyApp instance = null;

    public static final String SP_NAME_SETTING = "setting";


    public AppComponent appComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        SharedPreferences sp = getSharedPreferences(MyApp.SP_NAME_SETTING, Context.MODE_PRIVATE);

        instance = this;



        AppLogger.init();

    }

    public static MyApp getInstance() {
        return instance;
    }


}
