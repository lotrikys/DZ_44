package com.example.lotrik.realm.realm;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.Required;

/**
 * Created by lotrik on 24.02.16.
 */
public class Person extends RealmObject {

    @Required // Name is not nullable
    private String name;
    private String imageUrl; // imageUrl is an optional field
    private RealmList<Dog> dogs; // A person has many dogs (a relationship)

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public RealmList<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(RealmList<Dog> dogs) {
        this.dogs = dogs;
    }
}
