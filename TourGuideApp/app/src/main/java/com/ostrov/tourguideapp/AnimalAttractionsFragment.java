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

public class AnimalAttractionsFragment extends Fragment {
    private ArrayList<Attraction> attractions;

    AnimalAttractionsFragment() {
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

        attractions.add(new Attraction("SeaWorld San Diego",
                "Marine life shows, thrill rides, aquariums & up-close encounters with dolphins, penguins & more.",
                "500 Sea World Dr, San Diego, CA 92109",
                "https://seaworld.com/san-diego",
                R.drawable.img_seaworld,
                "https://g.page/SeaWorldSanDiegoCA"));
        attractions.add(new Attraction("San Diego Zoo",
                "Zoo features giraffes, koalas, apes & more, plus a safari park for tours & a conservation society.",
                "2920 Zoo Dr, San Diego, CA 92101",
                "https://zoo.sandiegozoo.org/",
                R.drawable.img_san_diego_zoo,
                "https://goo.gl/maps/tuqdtjJBNPaBEHRg8"));
        attractions.add(new Attraction("San Diego Zoo Safari Park",
                "Visitor tours of a 1,800-acre wildlife sanctuary with over 300 species of African & Asian animals.",
                "15500 San Pasqual Valley Rd, Escondido, CA 92027",
                "https://www.sdzsafaripark.org/",
                R.drawable.img_safari_park,
                "https://goo.gl/maps/FZZXtTHyZdGBGnfKA"));
        attractions.add(new Attraction("Birch Aquarium at Scripps",
                "Interactive tide pools & exhibitions for all things under the sea in an oceanside building.",
                "2300 Expedition Way, La Jolla, CA 92037",
                "https://aquarium.ucsd.edu/",
                R.drawable.img_birch_aquarium,
                "https://goo.gl/maps/BpxRVGeARgjUpbTB6"));
    }
}
