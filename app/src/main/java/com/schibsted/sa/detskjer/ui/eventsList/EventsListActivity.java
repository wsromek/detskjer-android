package com.schibsted.sa.detskjer.ui.eventsList;

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
import com.schibsted.sa.detskjer.ui.searchBarFragment.EcApiUrlHelper;

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

    @Inject
    protected EventsListViewScrollListener scrollListener;

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
        eventsRecyclerView.addOnScrollListener(scrollListener);

        eventsRecyclerView.setNestedScrollingEnabled(false);

        presenter.setView(this);
        presenter.getEvents();
    }

    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    public void showEvents(EventsList list) {
        eventsListAdapter.updateEvents(list);
    }
}
