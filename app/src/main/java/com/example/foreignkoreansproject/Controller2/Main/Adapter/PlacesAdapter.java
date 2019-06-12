package com.example.foreignkoreansproject.Controller2.Main.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.foreignkoreansproject.Model.PlaceResult;
import com.example.foreignkoreansproject.R;

import java.util.List;

public class PlacesAdapter extends RecyclerView.Adapter<PlacesAdapter.PlacesViewHolder> {
    public List<PlaceResult> data;
    Context context;

    public void setData(List<PlaceResult> data) {
        this.data = data;
    }

    public void setContext(Context context) {
        this.context = context;
    }
    @NonNull
    @Override
    public PlacesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.places_item_layout,viewGroup,false);
        return new PlacesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlacesViewHolder placesViewHolder, int i) {
        PlaceResult place = data.get(i);
        placesViewHolder.tvPlaceName.setText(place.getPlaceName());
    }

    @Override
    public int getItemCount()
    {
        return data.size();
    }
    public class PlacesViewHolder extends RecyclerView.ViewHolder{
        TextView tvPlaceName;


        public PlacesViewHolder(@NonNull View itemView){
            super(itemView);
            tvPlaceName = itemView.findViewById(R.id.tv_place_name_for_place);
        }
    }
}
