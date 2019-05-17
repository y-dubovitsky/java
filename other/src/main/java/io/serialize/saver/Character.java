package io.serialize.saver;

import java.io.Serializable;

/**
 * This class describes a computer saver character
 */
public class Character implements Serializable {

    String name;
    String race;
    int age;
    String[] weapons;

    // if i try io.serialize object with this field, throw exception!
    // because class Relationship not implements Serializable
    Relationship relationship;


    public Character(String name, String race, int age, String[] weapons) {
        this.name = name;
        this.race = race;
        this.age = age;
        this.weapons = weapons;
    }

    public Character(String name, String race, int age, String[] weapons, Relationship relationship) {
        this.name = name;
        this.race = race;
        this.age = age;
        this.weapons = weapons;
        this.relationship = relationship;
    }
}
