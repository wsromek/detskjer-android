package com.schibsted.sa.detskjer.ui.EventsList;

import com.schibsted.sa.detskjer.application.Constants;
import com.schibsted.sa.detskjer.model.Event;
import com.schibsted.sa.detskjer.model.EventsList;
import com.schibsted.sa.detskjer.network.EventCalendarApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EventsListPresenterImpl implements EventsListPresenter {

    private EventsListView view;

    @Override
    public void setView(EventsListView view) {
        this.view = view;
    }

    @Override
    public void getEvents() {
        Converter.Factory converter = GsonConverterFactory.create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.EC_API_BASE_URL)
                .addConverterFactory(converter)
                .build();

        EventCalendarApi ecApi = retrofit.create(EventCalendarApi.class);

        view.showLoading();

        ecApi.getEventsList(Constants.EVENTS_PER_PAGE).enqueue(new Callback<List<Event>>() {
            @Override
            public void onResponse(Call<List<Event>> call, Response<List<Event>> response) {
                if (response.code() != 200) {
                    System.out.println("Request failed");
                    System.out.println(response.code());
                    System.out.println(response.message());
                } else {
                    List<Event> body = response.body();
                    EventsList eventsList = new EventsList(body);

                    view.showEvents(eventsList);
                    view.hideLoading();
                }
            }

            @Override
            public void onFailure(Call<List<Event>> call, Throwable t) {
                System.out.println("Request failed");
                System.out.println(t.getMessage());
                view.hideLoading();
            }
        });
    }
}
