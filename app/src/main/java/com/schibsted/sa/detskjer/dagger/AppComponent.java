package com.schibsted.sa.detskjer.dagger;

import com.schibsted.sa.detskjer.repository.EventRepository;
import com.schibsted.sa.detskjer.ui.eventDetail.EventDetailActivity;
import com.schibsted.sa.detskjer.ui.eventDetail.EventDetailPresenterImpl;
import com.schibsted.sa.detskjer.ui.eventsList.EventsListViewScrollListener;
import com.schibsted.sa.detskjer.ui.eventsList.EventsListActivity;
import com.schibsted.sa.detskjer.ui.eventsList.EventsListPresenterImpl;
import com.schibsted.sa.detskjer.ui.searchBarFragment.SearchBarFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        AppModule.class,
        PresenterModule.class,
        NetworkModule.class,
        RepositoryModule.class,
        ListenerModule.class,
        HelperModule.class,
})
public interface AppComponent {
    //EVENT DETAIL INJECTIONS
    void inject(EventDetailActivity target);
    void inject(EventDetailPresenterImpl target);

    //EVENT LIST INJECTIONS
    void inject(SearchBarFragment target);
    void inject(EventsListActivity target);
    void inject(EventsListPresenterImpl target);
    void inject(EventRepository target);
    void inject(EventsListViewScrollListener target);
}
