package com.schibsted.sa.detskjer.ui.eventsList;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.schibsted.sa.detskjer.app.DetskjerApplication;

import javax.inject.Inject;

public class EventsListViewScrollListener extends RecyclerView.OnScrollListener {

    @Inject
    protected EventsListPresenter presenter;

    public EventsListViewScrollListener(Context context) {
        ((DetskjerApplication)context).getAppComponent().inject(this);
    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);

        if (!recyclerView.canScrollVertically(1)) {
            presenter.getEvents();
        }
    }
}
