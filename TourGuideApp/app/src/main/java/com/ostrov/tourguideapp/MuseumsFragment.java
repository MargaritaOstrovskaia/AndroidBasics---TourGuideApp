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
    private ArrayList<Attraction> museums;

    MuseumsFragment(ArrayList<Attraction> museums) {
        this.museums = museums;
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        LinearLayoutManager llm = new LinearLayoutManager(view.getContext());
        RecyclerView rv = view.findViewById(R.id.rv_list);
        rv.setLayoutManager(llm);

        AttractionAdapter adapter = new AttractionAdapter(museums, new AttractionAdapter.OnItemClickListener() {
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
}
