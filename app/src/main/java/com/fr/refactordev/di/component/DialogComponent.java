package com.fr.refactordev.di.component;

import com.fr.refactordev.di.scope.DialogScope;

import dagger.Component;

@DialogScope
@Component(dependencies = AppComponent.class)
public interface DialogComponent {


}
