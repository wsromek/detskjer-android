package com.schibsted.sa.detskjer.ui.EventDetail;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.MarkerOptions;
import com.schibsted.sa.detskjer.R;
import com.schibsted.sa.detskjer.app.DetskjerApplication;
import com.schibsted.sa.detskjer.model.Event;
import com.schibsted.sa.detskjer.model.GalleryItem;
import com.schibsted.sa.detskjer.model.Image;
import com.schibsted.sa.detskjer.repository.EventRepository;
import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventDetailPresenterImpl implements EventDetailPresenter {

    private EventDetailView view;

    @Inject
    protected EventRepository eventRepository;

    public EventDetailPresenterImpl(Context context) {
        ((DetskjerApplication)context).getAppComponent().inject(this);
    }

    public void loadEvent(String id) {
        LiveData<Event> eventPromise = eventRepository.getEvent(id);

        eventPromise.observeForever(event -> {
            this.view.showEvent(event);
        });
    }

    public void setView(EventDetailView view) {
        this.view = view;
    }
}
