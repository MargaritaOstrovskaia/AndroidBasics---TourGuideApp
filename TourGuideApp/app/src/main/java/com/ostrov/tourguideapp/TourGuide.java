package com.ostrov.tourguideapp;

import java.util.ArrayList;

class TourGuide {
    private ArrayList<Attraction> restaurants;
    private ArrayList<Attraction> museums;
    private ArrayList<Attraction> parks;
    private ArrayList<Attraction> animalAttractions;
    private ArrayList<Attraction> otherAttractions;

    /**
     * Constructor
     */
    TourGuide() {
        this.restaurants = new ArrayList<>();
        this.museums = new ArrayList<>();
        this.parks = new ArrayList<>();
        this.animalAttractions = new ArrayList<>();
        this.otherAttractions = new ArrayList<>();
    }

    /**
     * Get list of restaurants
     * @return list of restaurants
     */
    ArrayList<Attraction> getRestaurants() {
        return restaurants;
    }

    /**
     * Set restaurant to list of attractions
     * @param attraction restaurant attraction
     */
    void setRestaurant(Attraction attraction) {
        this.restaurants.add(attraction);
    }

    /**
     * Get list of museums
     * @return list of museums
     */
    ArrayList<Attraction> getMuseums() {
        return museums;
    }

    /**
     * Set museum to list of attractions
     * @param attraction museum attraction
     */
    void setMuseum(Attraction attraction) {
        this.museums.add(attraction);
    }

    /**
     * Get list of parks
     * @return list of parks
     */
    ArrayList<Attraction> getParks() {
        return parks;
    }

    /**
     * Set park to list of attractions
     * @param attraction park attraction
     */
    void setPark(Attraction attraction) {
        this.parks.add(attraction);
    }

    /**
     * Get list of animal attractions
     * @return list of animal attractions
     */
    ArrayList<Attraction> getAnimalAttractions() {
        return animalAttractions;
    }

    /**
     * Set animal attraction to list of attractions
     * @param attraction animal attraction
     */
    void setAnimalAttraction(Attraction attraction) {
        this.animalAttractions.add(attraction);
    }

    /**
     * Get list of other attractions
     * @return list of other attractions
     */
    ArrayList<Attraction> getOtherAttractions() {
        return otherAttractions;
    }

    /**
     * Set other attraction to list of attractions
     * @param attraction other attraction
     */
    void setOtherAttraction(Attraction attraction) {
        this.otherAttractions.add(attraction);
    }
}
