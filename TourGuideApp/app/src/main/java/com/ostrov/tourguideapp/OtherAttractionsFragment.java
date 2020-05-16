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

    OtherAttractionsFragment(ArrayList<Attraction> attractions) {
        this.attractions = attractions;
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
}
