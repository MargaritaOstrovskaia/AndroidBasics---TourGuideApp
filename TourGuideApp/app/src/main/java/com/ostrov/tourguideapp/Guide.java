package com.ostrov.tourguideapp;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "title",
        "attractions"
})
class Guide {
    @JsonProperty("title")
    private String title;
    @JsonProperty("attractions")
    private ArrayList<Attraction> attractions;

    /** Constructor */
    Guide() {
        attractions = new ArrayList<>();
    }

    @JsonProperty("title")
    String getTitle() {
        return title;
    }

    @JsonProperty("title")
    void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("attractions")
    ArrayList<Attraction> getAttractions() {
        return attractions;
    }

    @JsonProperty("attractions")
    void setAttractions(ArrayList<Attraction> attractions) {
        this.attractions = attractions;
    }
}
