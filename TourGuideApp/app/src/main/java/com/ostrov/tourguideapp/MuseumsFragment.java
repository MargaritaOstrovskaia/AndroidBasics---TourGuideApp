package com.ostrov.tourguideapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MuseumsFragment extends Fragment {
    private ArrayList<Attraction> attractions;

    MuseumsFragment() {
        addAttractions();
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        LinearLayoutManager llm = new LinearLayoutManager(view.getContext());
        RecyclerView rv = view.findViewById(R.id.rv_list);
        rv.setLayoutManager(llm);

        AttractionAdapter adapter = new AttractionAdapter(attractions, new AttractionAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Attraction item) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra(getString(R.string.intent_key), item);
                startActivity(intent);
            }
        });
        rv.setAdapter(adapter);

        return view;
    }

    private void addAttractions() {
        attractions = new ArrayList<>();

        attractions.add(new Attraction("USS Midway Museum",
                "Life-at-sea exhibits, restored planes & flight simulators aboard this legendary aircraft carrier.",
                "910 N Harbor Dr, San Diego, CA 92101",
                "https://www.midway.org/",
                R.drawable.img_midway_museum,
                "https://g.page/uss-midway-museum-san-diego"));
        attractions.add(new Attraction("Maritime Museum of San Diego",
                "Waterfront venue showcasing many types of restored vintage ships & historical exhibits.",
                "1492 N Harbor Dr, San Diego, CA 92101",
                "https://sdmaritime.org/",
                R.drawable.img_star_of_india,
                "https://g.page/sdmaritime"));
        attractions.add(new Attraction("San Diego Air & Space Museum",
                "Popular place with historical aircraft/spacecraft & interactive exhibits, plus a gift shop & grill.",
                "2001 Pan American Plaza, San Diego, CA 92101",
                "https://sandiegoairandspace.org/",
                R.drawable.img_air_space_museum,
                "https://goo.gl/maps/9Lvuir3jfjug6oKS9"));
        attractions.add(new Attraction("San Diego Model Railroad Museum",
                "Kid-friendly museum featuring many working scale models of California rail lines & landscapes.",
                "1649 El Prado Modern and Contemporary Art and Dynamic, San Diego, CA 92101",
                "https://www.sdmrm.org/",
                R.drawable.img_model_railroad_museum,
                "https://g.page/SDMRM"));
        attractions.add(new Attraction("California Tower in Museum of Man",
                "Historical landmark",
                "California Tower, 1350 El Prado, San Diego, CA 92101",
                "https://www.museumofman.org/california-building/",
                R.drawable.img_california_tower,
                "https://goo.gl/maps/i4Saoi2bxoevK9qw7"));
    }
}
