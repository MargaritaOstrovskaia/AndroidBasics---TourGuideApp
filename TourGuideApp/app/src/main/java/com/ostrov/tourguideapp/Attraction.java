package com.ostrov.tourguideapp;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "title",
        "description",
        "address",
        "link",
        "uri",
        "image"
})
class Attraction implements Serializable {
    @JsonProperty("title")
    private String title;
    @JsonProperty("description")
    private String description;
    @JsonProperty("address")
    private String address;
    @JsonProperty("link")
    private String link;
    @JsonProperty("uri")
    private String uri;
    @JsonProperty("image")
    private String image;

    /** Constructor */
    Attraction() {
    }

    @JsonProperty("title")
    String getTitle() {
        return title;
    }

    @JsonProperty("title")
    void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("description")
    String getDescription() {
        return description;
    }

    @JsonProperty("description")
    void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("address")
    String getAddress() {
        return address;
    }

    @JsonProperty("address")
    void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("link")
    String getLink() {
        return link;
    }

    @JsonProperty("link")
    void setLink(String link) {
        this.link = link;
    }

    @JsonProperty("uri")
    String getUri() {
        return uri;
    }

    @JsonProperty("uri")
    void setUri(String uri) {
        this.uri = uri;
    }

    @JsonProperty("image")
    String getImage() {
        return image;
    }

    @JsonProperty("image")
    void setImage(String image) {
        this.image = image;
    }
}
