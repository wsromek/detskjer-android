package com.schibsted.sa.detskjer.ui.EventsList;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.schibsted.sa.detskjer.R;
import com.schibsted.sa.detskjer.model.Event;
import com.schibsted.sa.detskjer.model.EventsList;

import java.util.List;

public class EventsListAdapter extends RecyclerView.Adapter<EventsListViewHolder> {

    private List<Event> eventList;
    private LayoutInflater inflater;

    public EventsListAdapter(List<Event> eventList, Context parentContext) {
        this.eventList = eventList;
        this.inflater = LayoutInflater.from(parentContext);
    }

    @Override
    public EventsListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new EventsListViewHolder(this.inflater.inflate(R.layout.list_item_event, parent, false));
    }

    @Override
    public void onBindViewHolder(EventsListViewHolder holder, int position) {
        Event event = eventList.get(position);

        holder.getEventNameLabel().setText(event.name);
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public void updateEvents(EventsList eventsList) {
        eventList.clear();
        eventList.addAll(eventsList.eventsList);

        notifyDataSetChanged();
    }
}
