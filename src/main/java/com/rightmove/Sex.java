/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rightmove;

/**
 *
 * @author alexp
 */
public enum Sex {

    MALE("male"), FEMALE("female");
    private String name;

    private Sex(String name) {
        this.name = name;
    }

    public static Sex fromString(String name) {
        for (Sex sex : Sex.values()) {
            if (sex.name().equalsIgnoreCase(name)) {
                return sex;
            }
        }
        throw new IllegalArgumentException("The sex [" + name + "] is not a recognized enum value in the " + Sex.class.getCanonicalName());
    }

}
