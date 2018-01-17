package com.schibsted.sa.detskjer.ui.EventsList;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.schibsted.sa.detskjer.R;

public class EventsListViewHolder extends RecyclerView.ViewHolder {

    private ViewGroup container;
    private TextView eventName;

    EventsListViewHolder(View view) {
        super(view);
        container = view.findViewById(R.id.list_item_event_container);
        eventName = view.findViewById(R.id.list_item_event_name);
    }

    public ViewGroup getContainer() {
        return container;
    }

    public TextView getEventName() {
        return eventName;
    }
}
