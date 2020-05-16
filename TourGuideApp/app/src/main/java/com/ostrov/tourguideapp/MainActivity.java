package com.ostrov.tourguideapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private MenuItem currentItem;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private TourGuide guide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createTourGuideClass();

        mDrawerLayout = findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigation = findViewById(R.id.nav_view);
        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                changeFragment(menuItem);
                return true;
            }
        });

        currentItem = navigation.getMenu().getItem(0);
        changeFragment(currentItem);
    }

    private void changeFragment(MenuItem menuItem) {
        currentItem.setChecked(false);
        currentItem = menuItem;
        menuItem.setChecked(true);

        Fragment fragment;
        switch (menuItem.getItemId()) {
            case R.id.menu_item_restaurants:
                fragment = new RestaurantsFragment(guide.getRestaurants());
                break;
            case R.id.menu_item_museums:
                fragment = new MuseumsFragment(guide.getMuseums());
                break;
            case R.id.menu_item_parks:
                fragment = new ParksFragment(guide.getParks());
                break;
            case R.id.menu_item_animal_attractions:
                fragment = new AnimalAttractionsFragment(guide.getAnimalAttractions());
                break;
            case R.id.menu_item_other_attractions:
                fragment = new OtherAttractionsFragment(guide.getOtherAttractions());
                break;
            default:
                fragment = new HomeFragment();
                break;
        }
        if (menuItem.getItemId() == R.id.menu_home)
            setTitle(getString(R.string.menu_item_home_name));
        else
            setTitle(menuItem.getTitle());

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .replace(R.id.main_content, fragment)
                .commit();

        mDrawerLayout.closeDrawers();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (mToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mToggle.syncState();
    }

    private void createTourGuideClass() {
        guide = new TourGuide();

        guide.setAnimalAttraction(new Attraction("SeaWorld San Diego",
                "Marine life shows, thrill rides, aquariums & up-close encounters with dolphins, penguins & more.",
                "500 Sea World Dr, San Diego, CA 92109",
                "https://seaworld.com/san-diego",
                R.drawable.img_seaworld,
                "https://g.page/SeaWorldSanDiegoCA"));
        guide.setAnimalAttraction(new Attraction("San Diego Zoo",
                "Zoo features giraffes, koalas, apes & more, plus a safari park for tours & a conservation society.",
                "2920 Zoo Dr, San Diego, CA 92101",
                "https://zoo.sandiegozoo.org/",
                R.drawable.img_san_diego_zoo,
                "https://goo.gl/maps/tuqdtjJBNPaBEHRg8"));
        guide.setAnimalAttraction(new Attraction("San Diego Zoo Safari Park",
                "Visitor tours of a 1,800-acre wildlife sanctuary with over 300 species of African & Asian animals.",
                "15500 San Pasqual Valley Rd, Escondido, CA 92027",
                "https://www.sdzsafaripark.org/",
                R.drawable.img_safari_park,
                "https://goo.gl/maps/FZZXtTHyZdGBGnfKA"));
        guide.setAnimalAttraction(new Attraction("Birch Aquarium at Scripps",
                "Interactive tide pools & exhibitions for all things under the sea in an oceanside building.",
                "2300 Expedition Way, La Jolla, CA 92037",
                "https://aquarium.ucsd.edu/",
                R.drawable.img_birch_aquarium,
                "https://goo.gl/maps/BpxRVGeARgjUpbTB6"));

        guide.setMuseum(new Attraction("USS Midway Museum",
                "Life-at-sea exhibits, restored planes & flight simulators aboard this legendary aircraft carrier.",
                "910 N Harbor Dr, San Diego, CA 92101",
                "https://www.midway.org/",
                R.drawable.img_midway_museum,
                "https://g.page/uss-midway-museum-san-diego"));
        guide.setMuseum(new Attraction("Maritime Museum of San Diego",
                "Waterfront venue showcasing many types of restored vintage ships & historical exhibits.",
                "1492 N Harbor Dr, San Diego, CA 92101",
                "https://sdmaritime.org/",
                R.drawable.img_star_of_india,
                "https://g.page/sdmaritime"));
        guide.setMuseum(new Attraction("San Diego Air & Space Museum",
                "Popular place with historical aircraft/spacecraft & interactive exhibits, plus a gift shop & grill.",
                "2001 Pan American Plaza, San Diego, CA 92101",
                "https://sandiegoairandspace.org/",
                R.drawable.img_air_space_museum,
                "https://goo.gl/maps/9Lvuir3jfjug6oKS9"));
        guide.setMuseum(new Attraction("San Diego Model Railroad Museum",
                "Kid-friendly museum featuring many working scale models of California rail lines & landscapes.",
                "1649 El Prado Modern and Contemporary Art and Dynamic, San Diego, CA 92101",
                "https://www.sdmrm.org/",
                R.drawable.img_model_railroad_museum,
                "https://g.page/SDMRM"));
        guide.setMuseum(new Attraction("California Tower in Museum of Man",
                "Historical landmark",
                "California Tower, 1350 El Prado, San Diego, CA 92101",
                "https://www.museumofman.org/california-building/",
                R.drawable.img_california_tower,
                "https://goo.gl/maps/i4Saoi2bxoevK9qw7"));

        guide.setPark(new Attraction("Belmont Park",
                "Vintage games, gift shops, rides & an iconic wooden roller coaster right next to the beach.",
                "3146 Mission Blvd, San Diego, CA 92109",
                "https://www.belmontpark.com/",
                R.drawable.img_belmont_park,
                "https://g.page/belmontparksd"));
        guide.setPark(new Attraction("Balboa Park",
                "Ever changing. Always amazing.  Where culture, science, and nature collide, Balboa Park is home to more than 16 museums, multiple performing arts venues, lovely gardens, trails, and many other creative and recreational attractions, including the San Diego Zoo. With a variety of cultural institutions among its 1,200 beautiful and lushly planted acres, there is something for everyone.",
                "1549 El Prado, San Diego, CA 92101",
                "https://www.balboapark.org/",
                R.drawable.img_balboa_park,
                "https://goo.gl/maps/KY3j4cgChoVV9PGY6"));

        guide.setOtherAttraction(new Attraction("San Diego California Temple",
                "The San Diego California Temple is the 47th constructed and 45th operating temple of The Church of Jesus Christ of Latter-day Saints. Located near the La Jolla community of San Diego, it was built with two main spires, but unique to this temple are four smaller spires at the base of each main spire.",
                "7474 Charmant Dr, San Diego, CA 92122",
                "https://www.churchofjesuschrist.org/temples/details/san-diego-california-temple?lang=eng",
                R.drawable.img_california_temple,
                "https://goo.gl/maps/UgVUEnjY21HZCPCz8"));
        guide.setOtherAttraction(new Attraction("La Jolla Cove",
                "La Jolla Cove is a very small beach, tucked between sandstone cliffs. Because of its extraordinary beauty, La Jolla Cove is one of the most photographed beaches in Southern California.",
                "1100 Coast Blvd, La Jolla, CA 92037",
                "https://www.sandiego.gov/lifeguards/beaches/cove",
                R.drawable.img_la_jolla_cove,
                "https://goo.gl/maps/sWMSkVBMsMjRCVXs6"));

        guide.setRestaurant(new Attraction("North Park Breakfast Company",
                "North Park is more known for late nights than early mornings, but the opening of North Park Breakfast Company means that’s poised to change. Their menu is simple but extensive, with everything from yogurt bowls to mashed potato waffles (which are perfect for those who can’t decide between sweet and savory). This being North Park, the heart of hipster territory, there are several vegan options as well as mocktails to accompany the various cocktails, cold brews, and kombuchas.",
                "3131 University Ave, San Diego, CA 92104",
                "https://breakfast-company.com/",
                R.drawable.img_breakfast_company,
                "https://g.page/northpark-breakfast"));
        guide.setRestaurant(new Attraction("Il Dandy",
                "A duo of Michelin-starred chefs run the kitchen at Il Dandy, a much-hyped addition to the thriving San Diego food scene. The Calabrian-inspired menu features regional Italian favorites with a California spin, including locally-caught sea bass, spot prawns, and sea urchin served over spaghetti. There’s plenty of pizza and pasta, of course, but expect a much grander presentation with serious attention to detail. This eye for perfection extends to the decor as well; every inch of the gigantic space is lavishly and lovingly created with plenty of European touches paying homage to the Calabrian countryside.",
                "2550 Fifth Ave UNIT 120, San Diego, CA 92103",
                "https://www.ildandyrestaurant.com/",
                R.drawable.img_dandy,
                "https://goo.gl/maps/8mFSfEW1E5Weogpf6"));
        guide.setRestaurant(new Attraction("International Smoke",
                "The fourth location of this celebrity-backed wood-fired cuisine concept brings an elevated look to the already chic One Paseo development in the center of San Diego county. With Michelin award-winning chef Michael Mina and restaurateur/cookbook author Ayesha Curry at the helm, the menu spans the globe in search of different approaches to utilizing fire and smoke in every dish. Plates like wood-fired oysters, Jamaican jerk chicken cutlets, and five-spice fried chicken capture the smells and tastes from around the world and present them in a fresh space that’s both kid-friendly and upscale without getting stuffy.",
                "3387 Del Mar Heights Road, Building 1 San Diego, CA 92130",
                "https://internationalsmoke.com/",
                R.drawable.img_international_smoke,
                "https://goo.gl/maps/5SA3fjjFJkDnd2Jb6"));
        guide.setRestaurant(new Attraction("Original 40 Brewing Company",
                "This North Park newcomer gets its name from the first 40 acre plot that eventually became the modern day Mid-City neighborhood. Over the past few years, North Park has transformed into a drinking-and-dining destination for anyone looking for local beer and high-quality eats (both of which it boasts in abundance). Head brewer Chris Gillogly is a local vet of the craft beer scene and keeps the taps flowing with a variety of beers like hazy IPAs, Mexican lagers, blonde ales, stouts, and a bevy of collaborations with other local breweries. The accompanying food menu is anything but your basic brewpub fare; think braised adobo ribs and mussels, rather than buffalo wings and onion rings. OG40 also recently opened for brunch, so you can turn a trip to this stylish brewery into an all-day affair.",
                "3117 University Ave, San Diego, CA 92104",
                "https://original40brewing.com/",
                R.drawable.img_original_brewing_company,
                "https://g.page/Original40Beer?share"));
        guide.setRestaurant(new Attraction("Grand Ole BBQ Flinn Springs",
                "Owner and pitmaster Andy Harris opened the first Grand Ole BBQ y Asado in North Park to rave reviews, thanks to his unapologetic devotion to high-quality Central Texas-style barbecue in a town that historically lacked smoked meat-centric options. His second location, although a decent distance away from the city center, has proven to be a draw for folks looking for a chiller vibe and much more seating. (The addition of two full bars helps, too.) You can’t go wrong with the pulled pork and short ribs, but the Texas hot links are a surprise favorite.",
                "15505 Olde Hwy 80, El Cajon, CA 92021",
                "https://flinnsprings.grandolebbq.com/",
                R.drawable.img_grand_ole,
                "https://goo.gl/maps/P9pQuy7DXR3UB8ag9"));
    }
}
