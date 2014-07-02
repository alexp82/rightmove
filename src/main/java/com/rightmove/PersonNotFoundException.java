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
public class PersonNotFoundException extends Exception {

    private String personName;

    public PersonNotFoundException(String personName) {
        super();
        this.personName = personName;
    }

    public String getPersonName() {
        return personName;
    }

}
