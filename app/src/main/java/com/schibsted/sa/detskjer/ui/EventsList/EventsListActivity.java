package com.schibsted.sa.detskjer.ui.EventsList;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.schibsted.sa.detskjer.R;
import com.schibsted.sa.detskjer.model.Event;
import com.schibsted.sa.detskjer.model.EventsList;

import java.util.ArrayList;
import java.util.List;

public class EventsListActivity extends AppCompatActivity implements EventsListView {

    EventsListPresenter presenter;
    RecyclerView eventsRecyclerView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        List<Event> emptyList = new ArrayList<Event>();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        //TODO: binding
        progressBar = findViewById(R.id.activity_event_progressBar);

        eventsRecyclerView = findViewById(R.id.activity_event_recyclerView);
        eventsRecyclerView.setAdapter(new EventsListAdapter(emptyList, EventsListActivity.this));
        eventsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        presenter = new EventsListPresenterImpl();
        presenter.setView(this);
        presenter.getEvents();
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    public void showEvents(EventsList list) {
        eventsRecyclerView.setAdapter(new EventsListAdapter(list.getEventsList(), EventsListActivity.this));
        eventsRecyclerView.getAdapter().notifyDataSetChanged();
    }
}
