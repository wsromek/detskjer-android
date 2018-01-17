package com.schibsted.sa.detskjer.network;

import com.schibsted.sa.detskjer.application.Constants;

import com.schibsted.sa.detskjer.model.Event;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface EventCalendarApi {
    @GET(Constants.EC_API_EVENTS_ENDPOINT)
    Call<List<Event>> getEventsList(@Query("per_page") int quantity);
}
