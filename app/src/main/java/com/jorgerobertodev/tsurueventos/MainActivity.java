package com.jorgerobertodev.tsurueventos;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

import com.jorgerobertodev.tsurueventos.Requests.EventsRequest;
import com.jorgerobertodev.tsurueventos.adapters.AdapterListCardView;
import com.jorgerobertodev.tsurueventos.collections.EventsCollection;
import com.jorgerobertodev.tsurueventos.listeners.ListEventsRequestListener;
import com.octo.android.robospice.Jackson2SpringAndroidSpiceService;
import com.octo.android.robospice.SpiceManager;
import com.octo.android.robospice.persistence.DurationInMillis;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity{
    private SpiceManager spiceManager = new SpiceManager(Jackson2SpringAndroidSpiceService.class);
    private RecyclerView ListCards;
    private AdapterListCardView adapter;
    private SwipeRefreshLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setProgressBarIndeterminate(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spiceManager.start(this);

        ListCards = (RecyclerView) findViewById(R.id.list_events);
        layout = (SwipeRefreshLayout) findViewById(R.id.swype);
        layout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                executeRequest();
                layout.setRefreshing(false);
            }
        });
        ListCards.setHasFixedSize(true);
        executeRequest();
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        ListCards.setLayoutManager(llm);
    }

    @Override
    protected void onStop() {
        spiceManager.shouldStop();
        super.onStop();
    }

    private void executeRequest() {
        MainActivity.this.setProgressBarIndeterminate(true);
        EventsRequest request = new EventsRequest();
        spiceManager.execute(request, new ListEventsRequestListener(MainActivity.this, ListCards));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
