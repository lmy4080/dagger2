package com.lmy.dagger2.di;

import com.lmy.dagger2.di.auth.AuthModule;
import com.lmy.dagger2.di.auth.AuthScope;
import com.lmy.dagger2.di.auth.AuthViewModelsModule;
import com.lmy.dagger2.di.main.MainFragmentBuildersModule;
import com.lmy.dagger2.di.main.MainModule;
import com.lmy.dagger2.di.main.MainScope;
import com.lmy.dagger2.di.main.MainViewModelsModule;
import com.lmy.dagger2.ui.auth.AuthActivity;
import com.lmy.dagger2.ui.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @AuthScope
    @ContributesAndroidInjector(
            modules = {
                    AuthViewModelsModule.class,
                    AuthModule.class
            }
    )
    abstract AuthActivity contributeAuthActivity();

    @MainScope
    @ContributesAndroidInjector(
            modules = {
                    MainFragmentBuildersModule.class,
                    MainViewModelsModule.class,
                    MainModule.class
            }
    )
    abstract MainActivity contributeMainActivity();

}
