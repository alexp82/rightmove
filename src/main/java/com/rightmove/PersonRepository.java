/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rightmove;

import java.util.Set;

/**
 *
 * @author alexp
 */
public interface PersonRepository {

    /**
     Return the number of people having the given sex
     @param sex
     @return
     */
    public int getNoOfPeople(Sex sex);

    /**
     Return the Person based on the fullName
     @param fullName
     @return
     */
    public Person getPersonByName(String fullName) throws PersonNotFoundException;

    /**
     Return all the persons in the repository
     @return
     */
    public Set<Person> getAllPersons();

    /**
     Return the average age of the persons in the list
     @return
     */
    public double getAverageAge();

}
