package com.jorgerobertodev.tsurueventos.listeners;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.jorgerobertodev.tsurueventos.MainActivity;
import com.jorgerobertodev.tsurueventos.adapters.AdapterListCardView;
import com.jorgerobertodev.tsurueventos.collections.EventsCollection;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;

/**
 * Created by jorge on 04/04/2015.
 */
public class ListEventsRequestListener implements RequestListener<EventsCollection> {
    private static Activity activity;
    private RecyclerView ListView;

    public ListEventsRequestListener(Activity activity,RecyclerView listview) {
        this.activity = activity;
        this.ListView = listview;
    }

    @Override
    public void onRequestFailure(SpiceException spiceException) {
        Toast.makeText(activity,
                "Error during request: " + spiceException.getLocalizedMessage(), Toast.LENGTH_LONG)
                .show();
        activity.setProgressBarIndeterminateVisibility(false);
    }

    @Override
    public void onRequestSuccess(EventsCollection events) {
        AdapterListCardView adapter = new AdapterListCardView(events.getEvents());
        this.ListView.setAdapter(adapter);
       activity.setProgressBarIndeterminateVisibility(false);
    }
}
