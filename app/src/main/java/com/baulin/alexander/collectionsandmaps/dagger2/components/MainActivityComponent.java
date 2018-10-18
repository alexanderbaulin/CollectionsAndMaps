package com.baulin.alexander.collectionsandmaps.dagger2.components;

import com.baulin.alexander.collectionsandmaps.dagger2.modules.MainActivityModule;
import com.baulin.alexander.collectionsandmaps.dagger2.scopes.MainActivityScope;

import dagger.Component;


@MainActivityScope
@Component(modules = MainActivityModule.class, dependencies = AppComponent.class)
public interface MainActivityComponent {

}
