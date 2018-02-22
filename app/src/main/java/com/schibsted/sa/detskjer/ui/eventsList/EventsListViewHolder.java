package com.schibsted.sa.detskjer.ui.eventsList;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.schibsted.sa.detskjer.R;

public class EventsListViewHolder extends RecyclerView.ViewHolder {

    private TextView eventNameLabel;
    private TextView eventDateLabel;
    private TextView eventLocationLabel;
    private ImageView eventImageView;

    EventsListViewHolder(View view) {
        super(view);

        eventNameLabel = view.findViewById(R.id.list_item_event_name);
        eventDateLabel = view.findViewById(R.id.list_item_event_date);
        eventLocationLabel = view.findViewById(R.id.list_item_event_location);
        eventImageView = view.findViewById(R.id.list_item_event_image);
    }

    public TextView getEventNameLabel() {
        return eventNameLabel;
    }

    public TextView getEventDateLabel() {
        return eventDateLabel;
    }

    public TextView getEventLocationLabel() {
        return eventLocationLabel;
    }

    public ImageView getEventImageView() {
        return eventImageView;
    }
}
