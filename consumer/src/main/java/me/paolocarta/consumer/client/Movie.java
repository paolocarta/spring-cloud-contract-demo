package me.paolocarta.consumer.client;

import lombok.Data;


@Data
public class Movie {

    private boolean published;

    public Movie(boolean published) {
        this.published = published;
    }

}