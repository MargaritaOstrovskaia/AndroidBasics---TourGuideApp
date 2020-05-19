package com.ostrov.tourguideapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class AttractionAdapter extends RecyclerView.Adapter<AttractionAdapter.AttractionViewHolder> {
    public interface OnItemClickListener {
        void onItemClick(Attraction item);
    }
    private final OnItemClickListener listener;
    private ArrayList<Attraction> attractions;
    private Context context;

    AttractionAdapter(Context context, ArrayList<Attraction> attractions, OnItemClickListener listener) {
        this.context = context;
        this.attractions = attractions;
        this.listener = listener;
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @NonNull
    @Override
    public AttractionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new AttractionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AttractionViewHolder holder, int position) {
        final Attraction attraction = attractions.get(position);
        holder.tv.setText(attraction.getTitle());
        int id = context.getResources().getIdentifier(attraction.getImage(),
                context.getString(R.string.def_type),
                context.getPackageName());
        holder.img.setImageResource(id);

        holder.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(attraction);
            }
        });
    }

    @Override
    public int getItemCount() {
        return attractions.size();
    }

    static class AttractionViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tv;

        AttractionViewHolder(@NonNull View itemView) {
            super(itemView);

            this.img = itemView.findViewById(R.id.cv_image);
            this.tv = itemView.findViewById(R.id.cv_title);
        }
    }
}
