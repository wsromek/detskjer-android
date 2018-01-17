package com.schibsted.sa.detskjer.ui.EventsList;

import com.schibsted.sa.detskjer.model.EventsList;

public interface EventsListView {
    void showEvents(EventsList eventsList);

    void showLoading();

    void hideLoading();
}
