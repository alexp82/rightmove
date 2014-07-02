/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rightmove;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author alexp
 */
public class PersonCSVFileRepository implements PersonRepository {

    private static PersonRepository instance = null;
    private Set<Person> persons = new LinkedHashSet<Person>();
    private CSVSerializer csvSerializer;

    private PersonCSVFileRepository(String fileLocation) {
        csvSerializer = new CSVSerializer(fileLocation);
        try {
            persons.addAll(csvSerializer.loadData());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static PersonRepository getInstance(String fileLocation) {
        if (instance == null) {
            synchronized (PersonCSVFileRepository.class) {
                if (instance == null) {
                    instance = new PersonCSVFileRepository(fileLocation);
                }
            }
        }
        return instance;
    }

    public int getNoOfPeople(Sex sex) {
        if (persons == null || persons.isEmpty()) {
            throw new IllegalStateException("persons should be loaded");
        }
        int noOfPeople = 0;
        for (Person person : persons) {
            if (person.getSex() != null && person.getSex() == sex) {
                ++noOfPeople;
            }
        }
        return noOfPeople;
    }

    public Person getPersonByName(String fullName) throws PersonNotFoundException {
        if (persons == null || persons.isEmpty()) {
            throw new IllegalStateException("persons should be loaded");
        }
        for (Person person : persons) {
            if (person.getFullName() != null && !person.getFullName().isEmpty() && person.getFullName().equals(fullName)) {
                return person;
            }
        }
        throw new PersonNotFoundException(fullName);
    }

    public Set<Person> getAllPersons() {
        return new LinkedHashSet<Person>(persons);
    }

    public double getAverageAge() {
        if (persons == null || persons.isEmpty()) {
            throw new IllegalStateException("persons should be loaded");
        }
        Integer ageSum = 0;
        for (Person person : persons) {
            if (person.getAge() != null) {
                ageSum += person.getAge();
            }
        }

        return ageSum.doubleValue() / persons.size();
    }

}
