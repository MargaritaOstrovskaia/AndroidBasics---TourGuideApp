package com.ostrov.tourguideapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;

public class AnimalAttractionsFragment extends Fragment {
    private Guide guide;

    AnimalAttractionsFragment(String json) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            guide = objectMapper.readValue(json, Guide.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        if (guide != null) {
            getActivity().setTitle(guide.getTitle());

            LinearLayoutManager llm = new LinearLayoutManager(view.getContext());
            RecyclerView rv = view.findViewById(R.id.rv_list);
            rv.setLayoutManager(llm);

            AttractionAdapter adapter = new AttractionAdapter(view.getContext(),
                    guide.getAttractions(),
                    new AttractionAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(Attraction item) {
                    Intent intent = new Intent(getActivity(), DetailActivity.class);
                    intent.putExtra(getString(R.string.intent_key), item);
                    startActivity(intent);
                }
            });
            rv.setAdapter(adapter);
        }

        return view;
    }
}
