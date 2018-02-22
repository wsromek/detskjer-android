package com.schibsted.sa.detskjer.ui.eventsList;

import com.schibsted.sa.detskjer.model.EventsList;

public interface EventsListView {
    void showEvents(EventsList eventsList);

    void showLoading();

    void hideLoading();
}
