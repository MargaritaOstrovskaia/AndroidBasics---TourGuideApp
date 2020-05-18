package com.ostrov.tourguideapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        if (intent.hasExtra(getString(R.string.intent_key))) {
            final Attraction attraction = (Attraction) intent.getSerializableExtra(getString(R.string.intent_key));

            ImageView image = findViewById(R.id.detail_image);
            image.setImageResource(attraction.getImageId());

            TextView title = findViewById(R.id.detail_title);
            title.setText(attraction.getTitle());
            setTitle(attraction.getTitle());

            TextView description = findViewById(R.id.detail_description);
            description.setText(attraction.getDescription());

            TextView address = findViewById(R.id.detail_address);
            address.setText(attraction.getAddress());
            address.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent next = new Intent(Intent.ACTION_VIEW, Uri.parse(attraction.getUri()));
                    startActivity(next);
                }
            });

            ImageView link = findViewById(R.id.detail_link);
            link.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent next = new Intent(Intent.ACTION_VIEW);
                    next.setData(Uri.parse(attraction.getLink()));
                    startActivity(next);
                }
            });
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
