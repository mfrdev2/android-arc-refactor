package com.fr.refactordev.di.component;
import com.fr.refactordev.di.mudule.activitymodule.ActivityModule;
import com.fr.refactordev.di.scope.ActivityScope;
import com.fr.refactordev.ui.mainactivity.MainActivity;

import dagger.Component;

@ActivityScope
@Component(modules = ActivityModule.class, dependencies = AppComponent.class)
public interface ActivityComponent {

    void inject(MainActivity activity);
}
