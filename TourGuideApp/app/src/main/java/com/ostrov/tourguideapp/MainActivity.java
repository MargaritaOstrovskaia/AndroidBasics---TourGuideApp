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

    private void changeFragment(MenuItem menuItem) {
        currentItem.setChecked(false);
        currentItem = menuItem;
        menuItem.setChecked(true);

        Fragment fragment;
        switch (menuItem.getItemId()) {
            case R.id.menu_item_restaurants:
                fragment = new RestaurantsFragment();
                break;
            case R.id.menu_item_museums:
                fragment = new MuseumsFragment();
                break;
            case R.id.menu_item_parks:
                fragment = new ParksFragment();
                break;
            case R.id.menu_item_animal_attractions:
                fragment = new AnimalAttractionsFragment();
                break;
            case R.id.menu_item_other_attractions:
                fragment = new OtherAttractionsFragment();
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
}
