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

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    private MenuItem currentItem;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

    /** Load data from json file */
    public String loadJSONFromAsset(int file) {
        String json = null;
        try {
            String FILE = getString(file);
            InputStream is = this.getAssets().open(FILE);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, getString(R.string.standard_charsets));
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    private void changeFragment(MenuItem menuItem) {
        currentItem.setChecked(false);
        currentItem = menuItem;
        menuItem.setChecked(true);

        Fragment fragment;
        String json;
        switch (menuItem.getItemId()) {
            case R.id.menu_item_restaurants:
                json = loadJSONFromAsset(R.string.file_restaurants);
                fragment = new RestaurantsFragment(json);
                break;
            case R.id.menu_item_museums:
                json = loadJSONFromAsset(R.string.file_museums);
                fragment = new MuseumsFragment(json);
                break;
            case R.id.menu_item_parks:
                json = loadJSONFromAsset(R.string.file_parks);
                fragment = new ParksFragment(json);
                break;
            case R.id.menu_item_animal_attractions:
                json = loadJSONFromAsset(R.string.file_animals);
                fragment = new AnimalAttractionsFragment(json);
                break;
            case R.id.menu_item_other_attractions:
                json = loadJSONFromAsset(R.string.file_other);
                fragment = new OtherAttractionsFragment(json);
                break;
            default:

                fragment = new HomeFragment();
                break;
        }

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
}
