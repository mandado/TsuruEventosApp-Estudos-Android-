package com.jorgerobertodev.tsurueventos.Requests;

import com.jorgerobertodev.tsurueventos.collections.EventsCollection;
import com.jorgerobertodev.tsurueventos.util.Api;
import com.octo.android.robospice.request.springandroid.SpringAndroidSpiceRequest;

/**
 * Created by jorge on 04/04/2015.
 */
public class EventsRequest extends SpringAndroidSpiceRequest<EventsCollection> {
    public EventsRequest() {
        super(EventsCollection.class);
    }

    @Override
    public EventsCollection loadDataFromNetwork() throws Exception {
        return getRestTemplate().getForObject(Api.url("events"),EventsCollection.class);
    }
}