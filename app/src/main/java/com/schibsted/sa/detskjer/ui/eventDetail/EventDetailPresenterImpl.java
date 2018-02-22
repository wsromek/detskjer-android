package com.schibsted.sa.detskjer.ui.eventDetail;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import com.schibsted.sa.detskjer.app.DetskjerApplication;
import com.schibsted.sa.detskjer.model.Event;
import com.schibsted.sa.detskjer.repository.EventRepository;

import javax.inject.Inject;

public class EventDetailPresenterImpl implements EventDetailPresenter {

    private EventDetailView view;

    @Inject
    protected EventRepository eventRepository;

    public EventDetailPresenterImpl(Context context) {
        ((DetskjerApplication)context).getAppComponent().inject(this);
    }

    public void loadEvent(String id) {
        LiveData<Event> eventPromise = eventRepository.getEvent(id);

        eventPromise.observeForever(event -> {
            this.view.showEvent(event);
        });
    }

    public void setView(EventDetailView view) {
        this.view = view;
    }
}
