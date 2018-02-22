package com.schibsted.sa.detskjer.ui.eventsList;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.util.Log;

import com.schibsted.sa.detskjer.app.DetskjerApplication;
import com.schibsted.sa.detskjer.model.EventsList;
import com.schibsted.sa.detskjer.repository.EventRepository;

import java.util.Date;
import java.util.Observer;

import javax.inject.Inject;

public class EventsListPresenterImpl implements EventsListPresenter {

    private EventsListView view;

    private int page = 0;

    @Inject
    protected EventRepository eventRepository;

    public EventsListPresenterImpl(Context context) {
        ((DetskjerApplication)context).getAppComponent().inject(this);
    }

    @Override
    public void setView(EventsListView view) {
        this.view = view;
    }

    @Override
    public void getEventsByDate(Date date) {
        Log.d("SEARCH", date.toString());
    }

    @Override
    public void getEvents() {
        view.showLoading();

        LiveData<EventsList> events = eventRepository.getEvents(page++);

        events.observeForever(eventsList -> {
            view.showEvents(eventsList);
            view.hideLoading();
        });
    }
}
