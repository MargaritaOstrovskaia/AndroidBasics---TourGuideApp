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

public class OtherAttractionsFragment extends Fragment {
    private ArrayList<Attraction> attractions;

    OtherAttractionsFragment() {
        addAttractions();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
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

        attractions.add(new Attraction("San Diego California Temple",
                "The San Diego California Temple is the 47th constructed and 45th operating temple of The Church of Jesus Christ of Latter-day Saints. Located near the La Jolla community of San Diego, it was built with two main spires, but unique to this temple are four smaller spires at the base of each main spire.",
                "7474 Charmant Dr, San Diego, CA 92122",
                "https://www.churchofjesuschrist.org/temples/details/san-diego-california-temple?lang=eng",
                R.drawable.img_california_temple,
                "https://goo.gl/maps/UgVUEnjY21HZCPCz8"));
        attractions.add(new Attraction("La Jolla Cove",
                "La Jolla Cove is a very small beach, tucked between sandstone cliffs. Because of its extraordinary beauty, La Jolla Cove is one of the most photographed beaches in Southern California.",
                "1100 Coast Blvd, La Jolla, CA 92037",
                "https://www.sandiego.gov/lifeguards/beaches/cove",
                R.drawable.img_la_jolla_cove,
                "https://goo.gl/maps/sWMSkVBMsMjRCVXs6"));
    }
}
