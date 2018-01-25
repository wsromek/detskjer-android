package com.schibsted.sa.detskjer.dagger;

import com.schibsted.sa.detskjer.repository.EventRepository;
import com.schibsted.sa.detskjer.ui.EventsList.EventsListActivity;
import com.schibsted.sa.detskjer.ui.EventsList.EventsListPresenterImpl;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, PresenterModule.class, NetworkModule.class, RepositoryModule.class})
public interface AppComponent {
    void inject(EventsListActivity target);
    void inject(EventsListPresenterImpl target);
    void inject(EventRepository target);
}
