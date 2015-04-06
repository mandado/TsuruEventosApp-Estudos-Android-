package com.jorgerobertodev.tsurueventos.adapters;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.jorgerobertodev.tsurueventos.R;
import com.jorgerobertodev.tsurueventos.adapters.Holder.ListCardViewHolder;
import com.jorgerobertodev.tsurueventos.model.Event;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorge on 04/04/2015.
 */
public class AdapterListCardView extends RecyclerView.Adapter<ListCardViewHolder>{
    private List<Event> listEvents = new ArrayList<Event>();

    public AdapterListCardView(List<Event> listEvents) {
        Log.d("I'm Here",listEvents.toString());
        this.listEvents = listEvents;
    }

    public AdapterListCardView() {

    }

    public void setListEvents(List<Event> listEvents) {
        this.listEvents = listEvents;
    }

    @Override
    public ListCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_events,parent,false);
        itemView.setOnClickListener(new ClickListenerItem());
        return new ListCardViewHolder(itemView);

    }



    @Override
    public void onBindViewHolder(ListCardViewHolder event, int position) {
        Event ev = listEvents.get(position);
        event.title.setText(ev.getTitle());
        event.setImage(ev.getImageUrl());
    }

    @Override
    public int getItemCount() {
        return this.listEvents.size();
    }

    final public class ClickListenerItem implements AdapterView.OnClickListener {

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(),"Ok",Toast.LENGTH_LONG).show();
        }
    }

}
