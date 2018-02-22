package com.schibsted.sa.detskjer.dagger;

import android.content.Context;

import com.schibsted.sa.detskjer.ui.eventsList.EventsListViewScrollListener;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ListenerModule {
    @Provides
    @Singleton
    EventsListViewScrollListener provideEventListViewScrollListener(Context context) {
        return new EventsListViewScrollListener(context);
    }
}
