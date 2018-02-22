package com.schibsted.sa.detskjer.ui.eventsList;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.schibsted.sa.detskjer.R;
import com.schibsted.sa.detskjer.model.Event;
import com.schibsted.sa.detskjer.model.EventsList;
import com.schibsted.sa.detskjer.model.Place;
import com.schibsted.sa.detskjer.ui.eventDetail.EventDetailActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class EventsListAdapter extends RecyclerView.Adapter<EventsListViewHolder> {

    private List<Event> eventList;
    private LayoutInflater inflater;
    private Context eventListContext;

    public EventsListAdapter(List<Event> eventList, Context parentContext) {
        this.eventList = eventList;
        this.eventListContext = parentContext;
        this.inflater = LayoutInflater.from(parentContext);
    }

    @Override
    public EventsListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new EventsListViewHolder(this.inflater.inflate(R.layout.list_item_event, parent, false));
    }

    @Override
    public void onBindViewHolder(EventsListViewHolder holder, int position) {
        Event event = eventList.get(position);

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(this.eventListContext, EventDetailActivity.class);
            intent.putExtra(Event.EVENT_ID, event.id);
            this.eventListContext.startActivity(intent);
        });

        holder.getEventNameLabel().setText(event.name);
        holder.getEventDateLabel().setText("i dag");

        Place location = event.place;
        if (location != null) {
            holder.getEventLocationLabel().setText(location.name);
        }

        String listImageUrl = event.getListImageUrl();
        if (listImageUrl != null) {
            Picasso.with(this.eventListContext)
                    .load(listImageUrl)
                    .resize(100, 100)
                    .centerCrop()
                    .into(holder.getEventImageView());
        }
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public void updateEvents(EventsList eventsList) {
        eventList.addAll(eventsList.eventsList);

        notifyDataSetChanged();
    }
}
