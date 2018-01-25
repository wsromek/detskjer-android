package com.schibsted.sa.detskjer.ui.EventsList;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.schibsted.sa.detskjer.R;

public class EventsListViewHolder extends RecyclerView.ViewHolder {

    private TextView eventNameLabel;

    EventsListViewHolder(View view) {
        super(view);
        eventNameLabel = view.findViewById(R.id.list_item_event_name);
    }

    public TextView getEventNameLabel() {
        return eventNameLabel;
    }
}
