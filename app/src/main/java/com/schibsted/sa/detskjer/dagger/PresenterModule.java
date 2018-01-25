package com.schibsted.sa.detskjer.dagger;

import android.content.Context;

import com.schibsted.sa.detskjer.ui.EventsList.EventsListPresenter;
import com.schibsted.sa.detskjer.ui.EventsList.EventsListPresenterImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {
    @Provides
    @Singleton
    EventsListPresenter provideEventsListPresenter(Context context) {
        return new EventsListPresenterImpl(context);
    }
}
