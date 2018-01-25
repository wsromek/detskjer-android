package com.schibsted.sa.detskjer.ui.EventsList;

import android.content.Context;

import com.schibsted.sa.detskjer.BuildConfig;
import com.schibsted.sa.detskjer.app.DetskjerApplication;
import com.schibsted.sa.detskjer.model.Event;
import com.schibsted.sa.detskjer.model.EventsList;
import com.schibsted.sa.detskjer.network.EventCalendarApi;

import java.util.ArrayList;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventsListPresenterImpl implements EventsListPresenter {

    private EventsListView view;

    @Inject
    protected EventCalendarApi eventCalendarApi;

    public EventsListPresenterImpl(Context context) {
        ((DetskjerApplication)context).getAppComponent().inject(this);
    }

    @Override
    public void setView(EventsListView view) {
        this.view = view;
    }

    @Override
    public void getEvents() {
        view.showLoading();

        eventCalendarApi.getEventsList(BuildConfig.EVENTS_PER_PAGE).enqueue(new Callback<ArrayList<Event>>() {
            @Override
            public void onResponse(Call<ArrayList<Event>> call, Response<ArrayList<Event>> response) {
                if (response.code() != 200) {
                    System.out.println("Request failed");
                    System.out.println(response.code());
                    System.out.println(response.message());
                } else {
                    ArrayList<Event> body = response.body();
                    EventsList eventsList = new EventsList(body);

                    view.showEvents(eventsList);
                    view.hideLoading();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Event>> call, Throwable t) {
                System.out.println("Request failed");
                System.out.println(t.getMessage());
                view.hideLoading();
            }
        });
    }
}
