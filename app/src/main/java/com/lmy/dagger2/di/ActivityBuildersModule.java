package com.lmy.dagger2.di;

import com.lmy.dagger2.di.auth.AuthModule;
import com.lmy.dagger2.di.auth.AuthViewModelsModule;
import com.lmy.dagger2.ui.auth.AuthActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
            modules = {
                    AuthViewModelsModule.class,
                    AuthModule.class
            }
    )
    abstract AuthActivity contributeAuthActivity();

}
