package com.schibsted.sa.detskjer.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.util.Log;

import com.schibsted.sa.detskjer.BuildConfig;
import com.schibsted.sa.detskjer.app.DetskjerApplication;
import com.schibsted.sa.detskjer.model.Event;
import com.schibsted.sa.detskjer.model.EventsList;
import com.schibsted.sa.detskjer.network.EventCalendarApi;
import com.schibsted.sa.detskjer.ui.searchBarFragment.EcApiUrlHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventRepository {
    @Inject
    protected EventCalendarApi eventCalendarApi;

    public EventRepository(Context context) {
        ((DetskjerApplication) context).getAppComponent().inject(this);
    }

    public LiveData<Event> getEvent(String id) {
        final MutableLiveData<Event> result = new MutableLiveData<>();
        Call<Event> methodCall = eventCalendarApi.getEvent(id);

        methodCall.enqueue(new Callback<Event>() {
            @Override
            public void onResponse(Call<Event> call, Response<Event> response) {
                if (response.code() != 200) {
                    System.out.println("Request failed");
                    System.out.println(response.code());
                    System.out.println(response.message());
                } else {
                    Event body = response.body();

                    result.postValue(body);
                }
            }

            @Override
            public void onFailure(Call<Event> call, Throwable t) {
                System.out.println(call.request().url().toString());
                System.out.println("Request failed");
                System.out.println(t.getMessage());
            }
        });

        return result;
    }

    public LiveData<EventsList> getEvents(int page) {
        final MutableLiveData<EventsList> result = new MutableLiveData<>();
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

        Call<ArrayList<Event>> methodCall = eventCalendarApi.getEventsList(
                        BuildConfig.EVENTS_PER_PAGE,
                        page,
                        BuildConfig.DISTRIBUTION_CHANNEL,
                        BuildConfig.STATUS,
                        BuildConfig.SORT_ORDER,
                        BuildConfig.SORT_COLUMN,
                        dateFormat.format(new Date())
                );

        methodCall.enqueue(new Callback<ArrayList<Event>>() {
            @Override
            public void onResponse(Call<ArrayList<Event>> call, Response<ArrayList<Event>> response) {
                if (response.code() != 200) {
                    System.out.println("Request failed");
                    System.out.println(response.code());
                    System.out.println(response.message());
                } else {
                    ArrayList<Event> body = response.body();

                    result.postValue(new EventsList(body));
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Event>> call, Throwable t) {
                System.out.println("Request failed");
                System.out.println(t.getMessage());
            }
        });

        return result;
    }
}
