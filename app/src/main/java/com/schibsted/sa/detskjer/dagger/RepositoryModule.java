package com.schibsted.sa.detskjer.dagger;

import android.content.Context;

import com.schibsted.sa.detskjer.repository.EventRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {
    @Provides
    @Singleton
    EventRepository provideEventRepository(Context context) {
        return new EventRepository(context);
    }
}
