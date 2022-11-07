package com.platzi.jobsearch;

import java.util.Arrays;

public class Character {

        private String id;

        private String name;

        private String status;

        private String species;

        private String type;

        private String gender;

        private URL origin;

        private URL location;

        private String image;

        private String[] episode;

        private String url;

        private String created;

    @Override
    public String toString() {
        return "Character{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", species='" + species + '\'' +
                ", type='" + type + '\'' +
                ", gender='" + gender + '\'' +
                ", origin=" + origin +
                ", location=" + location +
                ", image='" + image + '\'' +
                ", episode=" + Arrays.toString(episode) +
                ", url='" + url + '\'' +
                ", created='" + created + '\'' +
                '}';
    }
}
