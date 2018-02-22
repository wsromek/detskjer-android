package com.schibsted.sa.detskjer.dagger;

import com.schibsted.sa.detskjer.ui.searchBarFragment.EcApiUrlHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class HelperModule {
    @Provides
    @Singleton
    EcApiUrlHelper provideEcApiUrlHelper() {
        return new EcApiUrlHelper();
    }
}
