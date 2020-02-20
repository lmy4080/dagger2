package com.lmy.dagger2.di.main;

import androidx.lifecycle.ViewModel;

import com.lmy.dagger2.di.ViewModelKey;
import com.lmy.dagger2.ui.main.profile.ProfileViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class MainViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel.class)
    public abstract ViewModel bindProfileViewModel(ProfileViewModel viewModel);
}
