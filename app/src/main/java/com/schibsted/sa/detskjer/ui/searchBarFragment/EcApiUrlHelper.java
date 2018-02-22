package com.schibsted.sa.detskjer.ui.searchBarFragment;

import java.util.Date;
import java.util.Observable;

public class EcApiUrlHelper extends Observable {
    SearchParams params;

    EcApiUrlHelper() {
        params = new SearchParams(new Date());
    }

    public void searchByDate(Date dateToSearchBy) {
        synchronized (this) {
            params.date = dateToSearchBy;
        }
        setChanged();
        notifyObservers();
    }
}

class SearchParams {
    public Date date;

    SearchParams(Date date) {
        this.date = date;
    }
}