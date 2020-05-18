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

public class ParksFragment extends Fragment {
    private ArrayList<Attraction> attractions;

    ParksFragment() {
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

        attractions.add(new Attraction("Belmont Park",
                "Vintage games, gift shops, rides & an iconic wooden roller coaster right next to the beach.",
                "3146 Mission Blvd, San Diego, CA 92109",
                "https://www.belmontpark.com/",
                R.drawable.img_belmont_park,
                "https://g.page/belmontparksd"));
        attractions.add(new Attraction("Balboa Park",
                "Ever changing. Always amazing.  Where culture, science, and nature collide, Balboa Park is home to more than 16 museums, multiple performing arts venues, lovely gardens, trails, and many other creative and recreational attractions, including the San Diego Zoo. With a variety of cultural institutions among its 1,200 beautiful and lushly planted acres, there is something for everyone.",
                "1549 El Prado, San Diego, CA 92101",
                "https://www.balboapark.org/",
                R.drawable.img_balboa_park,
                "https://goo.gl/maps/KY3j4cgChoVV9PGY6"));
    }
}
