package com.example.foreignkoreansproject.Controller2.Main;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.foreignkoreansproject.Controller2.Main.Adapter.PlacesAdapter;
import com.example.foreignkoreansproject.Model.Place;
import com.example.foreignkoreansproject.R;
import com.example.foreignkoreansproject.Utils.Utils;
import com.google.gson.Gson;

public class PlacesActivity extends AppCompatActivity {
    RecyclerView rvPlaces;
    Place place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        String strPlace = Utils.loadJSONFromAssetPlace(this);
        Gson gson = new Gson();
        place = gson.fromJson(strPlace, Place.class);
        init();
        configRvPlace();
    }

    private void init() {
        rvPlaces = findViewById(R.id.rv_places);
    }

    private void configRvPlace() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvPlaces.setLayoutManager(linearLayoutManager);
        PlacesAdapter adapter = new PlacesAdapter();
        adapter.setContext(this);
        adapter.setData(place.getPlaceResults());
        rvPlaces.setAdapter(adapter);
    }

}
