package com.ostrov.tourguideapp;

import java.io.Serializable;

class Attraction implements Serializable {
    private String title;
    private String description;
    private String address;
    private String link;
    private String uri;
    private int imageId;

    /**
     * Constructor
     * @param title place name
     * @param description place description
     * @param address place address
     * @param link internet url
     * @param imageId image resource id
     * @param uri string uri
     */
    Attraction(String title, String description, String address, String link, int imageId, String uri) {
        this.title = title;
        this.description = description;
        this.address = address;
        this.link = link;
        this.imageId = imageId;
        this.uri = uri;
    }

    /**
     * Get place name
     * @return place name
     */
    String getTitle() {
        return title;
    }

    /**
     * Get place description
     * @return place description
     */
    String getDescription() {
        return description;
    }

    /**
     * Get place address
     * @return place address
     */
    String getAddress() {
        return address;
    }

    /**
     * Get internet url
     * @return internet url
     */
    String getLink() {
        return link;
    }

    /**
     * Get image resource id
     * @return image resource id
     */
    int getImageId() {
        return imageId;
    }

    /**
     * Get string uri
     * @return string uri
     */
    String getUri() {
        return uri;
    }
}
