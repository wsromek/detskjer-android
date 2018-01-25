package com.schibsted.sa.detskjer.network;

import com.schibsted.sa.detskjer.BuildConfig;
import com.schibsted.sa.detskjer.model.Event;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface EventCalendarApi {
    @GET(BuildConfig.EC_API_EVENTS_ENDPOINT)
    Call<ArrayList<Event>> getEventsList(
            @Query("per_page") int quantity,
            @Query("page") int page,
            @Query("distribution_channel") String distributionChannel,
            @Query("status") String status,
            @Query("sort_order") String sortOrder,
            @Query("sort_column") String sortColumn,
            @Query("date_from") String dateFrom
    );
}
