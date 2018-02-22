package com.schibsted.sa.detskjer.ui.eventDetail;

import com.schibsted.sa.detskjer.model.Event;

public interface EventDetailView {
    void showEvent(Event event);

    void showLoading();

    void hideLoading();
}
