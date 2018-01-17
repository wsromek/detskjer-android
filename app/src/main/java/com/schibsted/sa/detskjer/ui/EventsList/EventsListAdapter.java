package com.schibsted.sa.detskjer.ui.EventsList;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.schibsted.sa.detskjer.R;
import com.schibsted.sa.detskjer.model.Event;

import java.util.List;

class EventsListAdapter extends RecyclerView.Adapter<EventsListViewHolder> {

    private List<Event> eventList;
    private Context parentContext;

    EventsListAdapter(List<Event> eventList, Context parentContext) {
        this.eventList = eventList;
        this.parentContext = parentContext;
    }

    @Override
    public EventsListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parentContext);
        return new EventsListViewHolder(inflater.inflate(R.layout.list_item_event, parent, false));
    }

    @Override
    public void onBindViewHolder(EventsListViewHolder holder, int position) {
        Event event = eventList.get(position);
        System.out.println(event.getName());
        holder.getEventName().setText(event.getName());
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }
}
