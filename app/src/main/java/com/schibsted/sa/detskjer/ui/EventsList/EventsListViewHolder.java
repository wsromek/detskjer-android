package com.schibsted.sa.detskjer.ui.EventsList;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.schibsted.sa.detskjer.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventsListViewHolder extends RecyclerView.ViewHolder {

    private ViewGroup container;
    private TextView eventNameLabel;
    private TextView eventDateLabel;
    private TextView eventLocationLabel;
    private ImageView eventImageView;

    EventsListViewHolder(View view) {
        super(view);

        container = view.findViewById(R.id.list_item_event_container);
        eventNameLabel = view.findViewById(R.id.list_item_event_name);
        eventDateLabel = view.findViewById(R.id.list_item_event_date);
        eventLocationLabel = view.findViewById(R.id.list_item_event_location);
        eventImageView = view.findViewById(R.id.list_item_event_image);
    }

    public ViewGroup getContainer() {
        return container;
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
