package com.schibsted.sa.detskjer.ui.EventDetail;

public interface EventDetailPresenter {
    void setView(EventDetailView view);

    void loadEvent(String id);
}
