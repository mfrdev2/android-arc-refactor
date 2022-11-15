package com.fr.refactordev.di.component;


import com.fr.refactordev.di.mudule.notificationmodule.NotificationModule;
import com.fr.refactordev.di.scope.ServiceScope;

import dagger.Component;

@ServiceScope
@Component(modules = NotificationModule.class, dependencies = AppComponent.class)
public interface ServiceComponent {

}
