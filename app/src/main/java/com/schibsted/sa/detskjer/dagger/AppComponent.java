package com.schibsted.sa.detskjer.dagger;

import com.schibsted.sa.detskjer.repository.EventRepository;
import com.schibsted.sa.detskjer.ui.EventDetail.EventDetailActivity;
import com.schibsted.sa.detskjer.ui.EventDetail.EventDetailPresenterImpl;
import com.schibsted.sa.detskjer.ui.EventsList.EventsListViewScrollListener;
import com.schibsted.sa.detskjer.ui.EventsList.EventsListActivity;
import com.schibsted.sa.detskjer.ui.EventsList.EventsListPresenterImpl;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        AppModule.class,
        PresenterModule.class,
        NetworkModule.class,
        RepositoryModule.class,
        ListenerModule.class
})
public interface AppComponent {
    //EVENT DETAIL INJECTIONS
    void inject(EventDetailActivity target);
    void inject(EventDetailPresenterImpl target);

    //EVENT LIST INJECTIONS
    void inject(EventsListActivity target);
    void inject(EventsListPresenterImpl target);
    void inject(EventRepository target);
    void inject(EventsListViewScrollListener target);
}
