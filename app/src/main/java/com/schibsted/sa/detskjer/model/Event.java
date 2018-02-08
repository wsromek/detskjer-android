package com.schibsted.sa.detskjer.model;

import com.google.android.gms.maps.model.LatLng;

import java.util.List;

public class Event {
    public final static String EVENT_ID = "event_id";

    public String id;
    public String name;
    public String description;
    public Place place;
    public List<GalleryItem> galleryItems = null;

    public LatLng getLatLng() {
        if (place != null) {
            GeoLocation location = place.geoLocation;
            if (location != null) {
                Double latitude = Double.parseDouble(place.geoLocation.lat);
                Double longitute = Double.parseDouble(place.geoLocation.lon);

                return new LatLng(latitude, longitute);
            }
        }

        return null;
    }

    public String getListImageUrl() {
        List<GalleryItem> eventImages = this.galleryItems;
        if (eventImages != null) {
            GalleryItem detailImageItem = eventImages.get(0);
            if (detailImageItem != null) {
                Image detailImage = detailImageItem.image;

                return detailImage.listImage;
            }
        }

        return null;
    }

    public String getDetailImageUrl() {
        List<GalleryItem> eventImages = this.galleryItems;
        if (eventImages != null) {
            GalleryItem detailImageItem = eventImages.get(0);
            if (detailImageItem != null) {
                Image detailImage = detailImageItem.image;

                return detailImage.detailImage;
            }
        }

        return null;
    }
}
