package com.schibsted.sa.detskjer.ui.EventDetail;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.schibsted.sa.detskjer.R;
import com.schibsted.sa.detskjer.app.DetskjerApplication;
import com.schibsted.sa.detskjer.model.Event;
import com.squareup.picasso.Picasso;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventDetailActivity extends AppCompatActivity implements EventDetailView {

    @BindView(R.id.detail_item_event_name)
    public TextView eventNameLabel;

    @BindView(R.id.detail_item_event_description)
    public TextView eventDescriptionLabel;

    @BindView(R.id.detail_item_event_image)
    public ImageView eventDetailImage;

    @BindView(R.id.detail_loading_progressBar)
    public ProgressBar progressBar;

    private GoogleMap mapInstance;

    @Inject
    protected EventDetailPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);

        ((DetskjerApplication)getApplication()).getAppComponent().inject(this);
        ButterKnife.bind(this);

        SupportMapFragment eventLocationMap = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.detail_item_event_map);

        showLoading();
        String eventId = getIntent().getStringExtra(Event.EVENT_ID);
        eventLocationMap.getMapAsync(map -> {
            mapInstance = map;

            map.getUiSettings().setScrollGesturesEnabled(false);

            presenter.setView(this);
            presenter.loadEvent(eventId);
        });
    }

    public void showEvent(Event event) {
        this.eventNameLabel.setText(event.name);
        this.eventDescriptionLabel.setText(event.description);

        String detailImageUrl = event.getDetailImageUrl();
        if (detailImageUrl != null) {
            Picasso.with(this).load(detailImageUrl).into(eventDetailImage);
        }

        LatLng eventLocation = event.getLatLng();
        if (eventLocation != null) {
            mapInstance.addMarker(new MarkerOptions().position(eventLocation));
            mapInstance.moveCamera(CameraUpdateFactory.newLatLngZoom(eventLocation, 15));
        }

        hideLoading();
    }

    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }
    
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }
}
