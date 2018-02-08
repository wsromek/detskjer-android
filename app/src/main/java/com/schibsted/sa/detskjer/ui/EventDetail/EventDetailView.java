package com.schibsted.sa.detskjer.ui.EventDetail;

import com.schibsted.sa.detskjer.model.Event;

public interface EventDetailView {
    void showEvent(Event event);

    void showLoading();

    void hideLoading();
}
