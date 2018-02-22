package com.schibsted.sa.detskjer.ui.eventsList;

import java.util.Date;

public interface EventsListPresenter {
    void setView(EventsListView view);

    void getEvents();

    void getEventsByDate(Date date);
}
