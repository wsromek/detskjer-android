package com.schibsted.sa.detskjer.ui.EventsList;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.schibsted.sa.detskjer.R;
import com.schibsted.sa.detskjer.app.DetskjerApplication;
import com.schibsted.sa.detskjer.model.Event;
import com.schibsted.sa.detskjer.model.EventsList;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventsListActivity extends AppCompatActivity implements EventsListView {

    @BindView(R.id.activity_event_recyclerView)
    protected RecyclerView eventsRecyclerView;

    @BindView(R.id.activity_event_progressBar)
    protected ProgressBar progressBar;

    @Inject
    protected EventsListPresenter presenter;

    public EventsListAdapter eventsListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        List<Event> emptyList = new ArrayList<Event>();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        ((DetskjerApplication)getApplication()).getAppComponent().inject(this);
        ButterKnife.bind(this);

        eventsListAdapter = new EventsListAdapter(emptyList, EventsListActivity.this);
        eventsRecyclerView.setAdapter(eventsListAdapter);
        eventsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

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
        eventsListAdapter.updateEvents(list);
    }
}
