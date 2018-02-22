package com.schibsted.sa.detskjer.dagger;

import android.content.Context;

import com.schibsted.sa.detskjer.ui.eventDetail.EventDetailPresenter;
import com.schibsted.sa.detskjer.ui.eventDetail.EventDetailPresenterImpl;
import com.schibsted.sa.detskjer.ui.eventsList.EventsListPresenter;
import com.schibsted.sa.detskjer.ui.eventsList.EventsListPresenterImpl;

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

    @Provides
    @Singleton
    EventDetailPresenter provideEventDetailPresenter(Context context) {
        return new EventDetailPresenterImpl(context);
    }
}
