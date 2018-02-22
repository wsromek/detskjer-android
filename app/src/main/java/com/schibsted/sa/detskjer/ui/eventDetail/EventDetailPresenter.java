package com.schibsted.sa.detskjer.ui.eventDetail;

public interface EventDetailPresenter {
    void setView(EventDetailView view);

    void loadEvent(String id);
}
