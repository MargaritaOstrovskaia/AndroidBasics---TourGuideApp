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

public class RestaurantsFragment extends Fragment {
    private ArrayList<Attraction> attractions;

    RestaurantsFragment() {
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

        attractions.add(new Attraction("North Park Breakfast Company",
                "North Park is more known for late nights than early mornings, but the opening of North Park Breakfast Company means that’s poised to change. Their menu is simple but extensive, with everything from yogurt bowls to mashed potato waffles (which are perfect for those who can’t decide between sweet and savory). This being North Park, the heart of hipster territory, there are several vegan options as well as mocktails to accompany the various cocktails, cold brews, and kombuchas.",
                "3131 University Ave, San Diego, CA 92104",
                "https://breakfast-company.com/",
                R.drawable.img_breakfast_company,
                "https://g.page/northpark-breakfast"));
        attractions.add(new Attraction("Il Dandy",
                "A duo of Michelin-starred chefs run the kitchen at Il Dandy, a much-hyped addition to the thriving San Diego food scene. The Calabrian-inspired menu features regional Italian favorites with a California spin, including locally-caught sea bass, spot prawns, and sea urchin served over spaghetti. There’s plenty of pizza and pasta, of course, but expect a much grander presentation with serious attention to detail. This eye for perfection extends to the decor as well; every inch of the gigantic space is lavishly and lovingly created with plenty of European touches paying homage to the Calabrian countryside.",
                "2550 Fifth Ave UNIT 120, San Diego, CA 92103",
                "https://www.ildandyrestaurant.com/",
                R.drawable.img_dandy,
                "https://goo.gl/maps/8mFSfEW1E5Weogpf6"));
        attractions.add(new Attraction("International Smoke",
                "The fourth location of this celebrity-backed wood-fired cuisine concept brings an elevated look to the already chic One Paseo development in the center of San Diego county. With Michelin award-winning chef Michael Mina and restaurateur/cookbook author Ayesha Curry at the helm, the menu spans the globe in search of different approaches to utilizing fire and smoke in every dish. Plates like wood-fired oysters, Jamaican jerk chicken cutlets, and five-spice fried chicken capture the smells and tastes from around the world and present them in a fresh space that’s both kid-friendly and upscale without getting stuffy.",
                "3387 Del Mar Heights Road, Building 1 San Diego, CA 92130",
                "https://internationalsmoke.com/",
                R.drawable.img_international_smoke,
                "https://goo.gl/maps/5SA3fjjFJkDnd2Jb6"));
        attractions.add(new Attraction("Original 40 Brewing Company",
                "This North Park newcomer gets its name from the first 40 acre plot that eventually became the modern day Mid-City neighborhood. Over the past few years, North Park has transformed into a drinking-and-dining destination for anyone looking for local beer and high-quality eats (both of which it boasts in abundance). Head brewer Chris Gillogly is a local vet of the craft beer scene and keeps the taps flowing with a variety of beers like hazy IPAs, Mexican lagers, blonde ales, stouts, and a bevy of collaborations with other local breweries. The accompanying food menu is anything but your basic brewpub fare; think braised adobo ribs and mussels, rather than buffalo wings and onion rings. OG40 also recently opened for brunch, so you can turn a trip to this stylish brewery into an all-day affair.",
                "3117 University Ave, San Diego, CA 92104",
                "https://original40brewing.com/",
                R.drawable.img_original_brewing_company,
                "https://g.page/Original40Beer?share"));
        attractions.add(new Attraction("Grand Ole BBQ Flinn Springs",
                "Owner and pitmaster Andy Harris opened the first Grand Ole BBQ y Asado in North Park to rave reviews, thanks to his unapologetic devotion to high-quality Central Texas-style barbecue in a town that historically lacked smoked meat-centric options. His second location, although a decent distance away from the city center, has proven to be a draw for folks looking for a chiller vibe and much more seating. (The addition of two full bars helps, too.) You can’t go wrong with the pulled pork and short ribs, but the Texas hot links are a surprise favorite.",
                "15505 Olde Hwy 80, El Cajon, CA 92021",
                "https://flinnsprings.grandolebbq.com/",
                R.drawable.img_grand_ole,
                "https://goo.gl/maps/P9pQuy7DXR3UB8ag9"));
    }
}
