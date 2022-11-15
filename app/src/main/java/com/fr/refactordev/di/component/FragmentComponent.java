package com.fr.refactordev.di.component;

import com.fr.refactordev.di.scope.FragmentScope;

import dagger.Component;

@FragmentScope
@Component(dependencies = AppComponent.class)
public interface FragmentComponent {

}
