package com.arcode.moviesfeed.root;

import com.arcode.moviesfeed.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    void inject(MainActivity target);
}
